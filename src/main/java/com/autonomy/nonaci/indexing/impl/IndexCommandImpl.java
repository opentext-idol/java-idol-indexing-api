/*
 * Copyright 2008-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */
package com.autonomy.nonaci.indexing.impl;

import com.autonomy.nonaci.indexing.IndexCommand;
import com.autonomy.nonaci.indexing.PostData;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** 
 * Core implementation of the <tt>IndexCommand</tt> interface. Provides methods to supply all the necessary information
 * to execute any index command. 
 *
 * @author boba
 * @version $Revision$ $Date$
 */
public class IndexCommandImpl implements IndexCommand {

    /** Holds the name of the index command to be executed. */
    private final String command;

    /** Holds the parameters to be sent as part of the URI. */
    private Map<String, String> parameters = new LinkedHashMap<String, String>();

    /** If the index command requires POST content, then it should be contained in this. */
    private PostData postData;

    public IndexCommandImpl(final String command) {
        this.command = command;
    }

    /**
     * Convenience method for adding a parameter to the command.
     *
     * @param key The parameter key
     * @param Value The parameter value
     * @return previous value associated with specified key, or <tt>null</tt> if there was no mapping for key.
     */
    public String put(final String key, final String Value) {
        return parameters.put(key, Value);
    }

    /**
     * Convenience method for getting a parameter value from the command.
     *
     * @param key The parameter key
     * @return The value of the command parameter
     */
    public String get(final String key) {
        return parameters.get(key);
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(9, 35)
                .append(command)
                .append(parameters)
                .append(postData)
                .toHashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        // Default to false...
        boolean returnValue = false;

        // Is the obj of the same class...?
        if(obj instanceof IndexCommandImpl) {
            // Cast the object...
            final IndexCommandImpl that = (IndexCommandImpl) obj;

            // Work out the equality...
            returnValue = new EqualsBuilder()
                    .append(this.command, that.command)
                    .append(this.parameters, that.parameters)
                    .append(this.postData, that.postData)
                    .isEquals();
        }

        // Return the result...
        return returnValue;
    }

    @Override
    public String getCommand() {
        return command;
    }

    @Override
    public String getQueryString() {
        final List<NameValuePair> pairs = new ArrayList<NameValuePair>(parameters.size());

        for(final Map.Entry<String, String> entry : parameters.entrySet()) {
            pairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }

        return URLEncodedUtils.format(pairs, "UTF-8");
    }

    @Override
    public PostData getPostData() {
        return postData;
    }

    public void setPostData(final PostData postData) {
        this.postData = postData;
    }

    public void setPostData(final String postData) {
        this.postData = new PostDataImpl(postData);
    }

    public void setPostData(final InputStream postData) {
        this.postData = new PostDataImpl(postData);
    }

    public void setPostData(final File postData) {
        this.postData = new PostDataImpl(postData);
    }

    public int getPriority() {
        return NumberUtils.toInt(parameters.get(PARAM_PRIORITY), -1);
    }
    
    /**
     * Change or set the priority of an indexing job. Indexing jobs are processed in priority order, where priority 0 is
     * processed first. In the event of a tie, the index ID is used instead.
     * <p />
     * This affects the order in which jobs are processed, but will not interrupt the current job.
     * 
     * @param priority Sets the priority of an indexing job. 
     */
    public void setPriority(final int priority) {
        parameters.put(PARAM_PRIORITY, String.valueOf(priority));
    }

    public Map<String, String> getParameters() {
        return new LinkedHashMap<String, String>(parameters);
    }

    public void setParameters(final Map<String, String> parameters) {
        this.parameters = (parameters == null) ? new LinkedHashMap<String, String>() : new LinkedHashMap<String, String>(parameters);
    }

} // End of class IndexCommandImpl...
