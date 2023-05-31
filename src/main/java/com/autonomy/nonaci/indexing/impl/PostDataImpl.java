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

import com.autonomy.nonaci.indexing.IndexingException;
import com.autonomy.nonaci.indexing.PostData;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

/**
 * This implementation of the {@link com.autonomy.nonaci.indexing.PostData} interface can be used to send the contents
 * of a {@link java.lang.String}, {@link java.io.File} or {@link java.io.InputStream}. It is backed by the appropriate
 * {@link org.apache.http.HttpEntity} implementation from the Apache {@link org.apache.http.client.HttpClient} library.
 *
 * @author boba
 */
public class PostDataImpl implements PostData {

    private final HttpEntity httpEntity;

    public PostDataImpl(final String string) {
        this(string, null);
    }

    public PostDataImpl(final String string, final String charset) {
        try {
            httpEntity = new StringEntity(string, StringUtils.isBlank(charset) ? "UTF-8" : charset);
        }
        catch(final UnsupportedCharsetException uce) {
            throw new IndexingException("Unsupported charset specified, " + charset, uce);
        }
    }

    public PostDataImpl(final File file) {
        this(file, ContentType.create("text/plain", Charset.forName("UTF-8")));
    }

    public PostDataImpl(final File file, final String contentType) {
        this.httpEntity = new FileEntity(file, ContentType.create(contentType));
    }

    public PostDataImpl(final File file, final ContentType contentType) {
        this.httpEntity = new FileEntity(file, contentType);
    }

    public PostDataImpl(final InputStream inputStream) {
        this(inputStream, -1);
    }

    public PostDataImpl(final InputStream inputStream, final long length) {
        this.httpEntity = new InputStreamEntity(inputStream, length);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(9, 13)
                .append(httpEntity)
                .toHashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        // Default to false...
        boolean returnValue = false;

        // Is the obj of the same class...?
        if(obj instanceof PostDataImpl) {
            // Cast the object...
            final PostDataImpl that = (PostDataImpl) obj;

            // Work out the equality...
            returnValue = new EqualsBuilder()
                    .append(this.httpEntity, that.httpEntity)
                    .isEquals();
        }

        // Return the result...
        return returnValue;
    }

    @Override
    public boolean isRepeatable() {
        return httpEntity.isRepeatable();
    }

    @Override
    public boolean isChunked() {
        return httpEntity.isChunked();
    }

    @Override
    public long getContentLength() {
        return httpEntity.getContentLength();
    }

    @Override
    public String getContentType() {
        return (httpEntity.getContentType() == null) ? null : httpEntity.getContentType().getValue();
    }

    @Override
    public String getContentEncoding() {
        return (httpEntity.getContentEncoding() == null) ? null : httpEntity.getContentEncoding().getValue();
    }

    @Override
    public InputStream getContent() throws IOException {
        return httpEntity.getContent();
    }

    @Override
    public void writeTo(final OutputStream outstream) throws IOException {
        httpEntity.writeTo(outstream);
    }

    @Override
    public boolean isStreaming() {
        return httpEntity.isStreaming();
    }

    @Override
    public void finish() throws IOException {
        EntityUtils.consume(httpEntity);
    }

}
