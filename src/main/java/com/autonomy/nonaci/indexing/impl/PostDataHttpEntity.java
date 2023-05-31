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

import com.autonomy.nonaci.indexing.PostData;
import org.apache.commons.lang3.Validate;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * A simple implementation of the {@link org.apache.http.HttpEntity} interface that proxies all calls to the underlying
 * {@link com.autonomy.nonaci.indexing.PostData} implementation.
 *
 * @author boba
 */
public class PostDataHttpEntity implements HttpEntity {

    private final PostData postData;

    public PostDataHttpEntity(final PostData postData) {
        Validate.notNull(postData, "postData must not be null.");
        this.postData = postData;
    }

    @Override
    public boolean isRepeatable() {
        return postData.isRepeatable();
    }

    @Override
    public boolean isChunked() {
        return postData.isChunked();
    }

    @Override
    public long getContentLength() {
        return postData.getContentLength();
    }

    @Override
    public Header getContentType() {
        Header header = null;

        final String ctString = postData.getContentType();
        if(ctString != null) {
            header = new BasicHeader(HTTP.CONTENT_TYPE, ctString);
        }
        
        return header;
    }

    @Override
    public Header getContentEncoding() {
        Header header = null;

        final String ceString = postData.getContentEncoding();
        if(ceString != null) {
            header = new BasicHeader(HTTP.CONTENT_ENCODING, ceString);
        }

        return header;
    }

    @Override
    public InputStream getContent() throws IOException {
        return postData.getContent();
    }

    @Override
    public void writeTo(final OutputStream outstream) throws IOException {
        postData.writeTo(outstream);
    }

    @Override
    public boolean isStreaming() {
        return postData.isStreaming();
    }

    /**
     * @deprecated Use {@link org.apache.http.util.EntityUtils#consume(org.apache.http.HttpEntity)} instead.
     */
    @Override
    @Deprecated
    public void consumeContent() throws IOException {
        postData.finish();
    }

}
