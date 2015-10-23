/*
 * Copyright 2008-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */
package com.autonomy.nonaci.indexing.impl;

import com.autonomy.nonaci.ServerDetails;
import com.autonomy.nonaci.indexing.IndexCommand;
import com.autonomy.nonaci.indexing.IndexingException;
import com.autonomy.nonaci.indexing.IndexingService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Core implementation of the {@link com.autonomy.nonaci.indexing.IndexingService} interface. This implementation uses
 * the Apache {@link org.apache.http.client.HttpClient} library to do the actual communication with the IDOL's index
 * port.
 * <p/>
 * The {@link org.apache.http.client.HttpClient} instance to be used should be set before calling either of the execute
 * methods. The {@link com.autonomy.nonaci.ServerDetails} can either be set before calling the execute method, or
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

        // Create the URI to use... We can't use URLEncodedUtils.parse() or setQuery() since they decode
        // command.getQueryString(), which we shouldn't do since both '+' and '%20' will be decoded-and-reencoded
        // to '+', which causes problems since IDOL treats these differently e.g. when listing DREREFERENCEs.
        final URI uri = new URIBuilder()
                .setScheme(serverDetails.getProtocol().toString().toLowerCase(Locale.ENGLISH))
                .setHost(serverDetails.getHost())
                .setPort(serverDetails.getPort())
                .setPath('/' + command.getCommand())
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

        HttpResponse httpResponse = null;

        try {
            // Create the HTTP method to use...
            final HttpUriRequest httpRequest = (command.getPostData() == null)
                    ? createGetMethod(serverDetails, command)
                    : createPostMethod(serverDetails, command);

            LOGGER.debug("Executing a {} index command...", command.getCommand());

            // Execute the command...
            httpResponse = httpClient.execute(httpRequest);

            LOGGER.debug("Successfully executed the index command, HTTP status - {}...", httpResponse.getStatusLine().getStatusCode());

            // Get the response...
            final ByteArrayOutputStream baos = new ByteArrayOutputStream();
            httpResponse.getEntity().writeTo(baos);
            final String response = baos.toString("UTF-8");

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
        finally {
            try {
                if(httpResponse != null) {
                    // Release the HTTP connection...
                    EntityUtils.consume(httpResponse.getEntity());
                }
            }
            catch(final IOException ioe) {
                LOGGER.error("Unable to consume any remaining content from the IndexCommand response.", ioe);
            }
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
