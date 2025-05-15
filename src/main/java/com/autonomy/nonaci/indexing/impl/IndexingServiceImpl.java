/*
 * Copyright 2008-2015 Open Text.
 *
 * Licensed under the MIT License (the "License"); you may not use this file
 * except in compliance with the License.
 *
 * The only warranties for products and services of Open Text and its affiliates
 * and licensors ("Open Text") are as may be set forth in the express warranty
 * statements accompanying such products and services. Nothing herein should be
 * construed as constituting an additional warranty. Open Text shall not be
 * liable for technical or editorial errors or omissions contained herein. The
 * information contained herein is subject to change without notice.
 */
package com.autonomy.nonaci.indexing.impl;

import com.autonomy.nonaci.ServerDetails;
import com.autonomy.nonaci.indexing.IndexCommand;
import com.autonomy.nonaci.indexing.IndexingException;
import com.autonomy.nonaci.indexing.IndexingService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
import org.apache.hc.core5.net.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Core implementation of the {@link IndexingService} interface. This implementation uses
 * the Apache {@link HttpClient} library to do the actual communication with the IDOL's index
 * port.
 * <p/>
 * The {@link HttpClient} instance to be used should be set before calling either of the execute
 * methods. The {@link ServerDetails} can either be set before calling the execute method, or
 * optionally sent as a method parameter to the execute method. This allows the API to be set up to talk to a single IDOL
 * server by setting the details once, or multiple IDOL Servers by sending the details with every invocation of execute.
 *
 * @author boba
 */
public class IndexingServiceImpl implements IndexingService {

    /** Class logger... */
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexingServiceImpl.class);

    private HttpClient httpClient;

    private ServerDetails serverDetails;

    private final Pattern pattern = Pattern.compile(".*=(\\d+).*", Pattern.DOTALL);

    public IndexingServiceImpl() {
        super();
    }

    public IndexingServiceImpl(final HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public IndexingServiceImpl(final ServerDetails serverDetails, final HttpClient httpClient) {
        this.serverDetails = serverDetails;
        this.httpClient = httpClient;
    }

    private URI createIndexCommandURI(final ServerDetails serverDetails, final IndexCommand command) throws URISyntaxException {
        LOGGER.trace("createIndexCommandURI() called...");

        final String path = serverDetails.getPath();
        // Create the URI to use... We can't use URLEncodedUtils.parse() or setQuery() since they decode
        // command.getQueryString(), which we shouldn't do since both '+' and '%20' will be decoded-and-reencoded
        // to '+', which causes problems since IDOL treats these differently e.g. when listing DREREFERENCEs.
        final URI uri = new URIBuilder()
                .setScheme(serverDetails.getProtocol().toString().toLowerCase(Locale.ENGLISH))
                .setHost(serverDetails.getHost())
                .setPort(serverDetails.getPort())
                .setPath((path.endsWith("/") ? path : (path + '/')) + command.getCommand())
                .build();

        final String qs = command.getQueryString();

        return StringUtils.isBlank(qs) ? uri : new URI(uri + "?" + qs);
    }

    /**
     *
     * @param serverDetails The connection details of the server to use...
     * @param command The command to get the POST content from
     * @return a <tt>HttpUriRequest</tt> containing the contents of the <tt>Command</tt>
     * @throws java.net.URISyntaxException If there was a problem converting the IndexCommand into a URI
     */
    private HttpUriRequest createGetMethod(final ServerDetails serverDetails, final IndexCommand command) throws URISyntaxException {
        LOGGER.trace("createGetMethod() called...");

        // Return the constructed get method...
        return new HttpGet(createIndexCommandURI(serverDetails, command));
    }
    
    /**
     * Create a <tt>HttpClient</tt> <tt>PostMethod</tt> instance that contains the POST content.
     *
     * @param serverDetails The connection details of the server to use...
     * @param command The command to get the POST content from
     * @return a <tt>HttpUriRequest</tt> containing the contents of the <tt>Command</tt>
     * @throws java.net.URISyntaxException If there was a problem converting the IndexCommand into a URI
     */
    private HttpUriRequest createPostMethod(final ServerDetails serverDetails, final IndexCommand command) throws URISyntaxException {
        LOGGER.trace("createPostMethod() called...");

        final HttpPost httpPost = new HttpPost(createIndexCommandURI(serverDetails, command));
        httpPost.setEntity(new PostDataHttpEntity(command.getPostData()));
        return httpPost;
    }

    /**
     * Executes an index command
     *
     * @param command The index command to execute
     * @return the index queue id for the command
     * @throws com.autonomy.nonaci.indexing.IndexingException if an error response was detected
     */
    @Override
    public int executeCommand(final IndexCommand command) throws IndexingException {
        LOGGER.trace("executeCommand() called...");

        // Execute and return the result...
        return executeCommand(serverDetails, command);
    }

    /**
     * Executes an index command
     *
     * @param serverDetails The connection details of the indexing server.
     * @param command The index command to execute
     * @return the index queue id for the command
     * @throws com.autonomy.nonaci.indexing.IndexingException if an error response was detected, or if something went
     * wrong while executing the command
     */
    @Override
    public int executeCommand(final ServerDetails serverDetails, final IndexCommand command) throws IndexingException {
        LOGGER.trace("executeCommand() called...");

        // Sanity check...
        Validate.notNull(serverDetails, "Indexing server connection details must be set before calling this method.");
        Validate.notNull(command.getCommand(), "You must set a valid index command to execute");
        Validate.notNull(httpClient, "You must set httpClient before executing commands");

        try {
            // Create the HTTP method to use...
            final HttpUriRequest httpRequest = (command.getPostData() == null)
                    ? createGetMethod(serverDetails, command)
                    : createPostMethod(serverDetails, command);

            LOGGER.debug("Executing a {} index command...", command.getCommand());

            // Execute the command...
            final String response = httpClient.execute(httpRequest, httpResponse -> {
                LOGGER.debug("Successfully executed the index command, HTTP status - {}...", httpResponse.getCode());
                final ByteArrayOutputStream baos = new ByteArrayOutputStream();
                httpResponse.getEntity().writeTo(baos);
                return baos.toString(StandardCharsets.UTF_8);
            });

            if(!response.contains("INDEXID")) {
                throw new IndexingException(response.trim());
            }

            // Get the index queue id...
            final Matcher matcher = pattern.matcher(response);
            if(matcher.matches()) {
                return NumberUtils.toInt(matcher.group(1));
            }

            throw new IndexingException("Unable to get index queue id from response: [" + response + ']');
        }
        catch(final IOException ioe) {
            throw new IndexingException("Unable to execute the Index command", ioe);
        }
        catch(final URISyntaxException urise) {
            throw new IndexingException("Unable to construct the Index command URI.", urise);
        }
    }

    public HttpClient getHttpClient() {
        return httpClient;
    }

    public void setHttpClient(final HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public ServerDetails getIndexingServerDetails() {
        return serverDetails;
    }

    public void setIndexingServerDetails(final ServerDetails serverDetails) {
        this.serverDetails = serverDetails;
    }

}  // End of class IndexingServiceImpl...
