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
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpHeaders;
import org.apache.hc.core5.http.io.entity.AbstractHttpEntity;
import org.apache.hc.core5.http.message.BasicHeader;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * A simple implementation of the {@link HttpEntity} interface that proxies all calls to the underlying
 * {@link com.autonomy.nonaci.indexing.PostData} implementation.
 *
 * @author boba
 */
public class PostDataHttpEntity extends AbstractHttpEntity {

    private final PostData postData;

    public PostDataHttpEntity(final PostData postData) {
        super(postData.getContentType(), postData.getContentEncoding(), postData.isChunked());
        this.postData = postData;
    }

    @Override
    public boolean isRepeatable() {
        return postData.isRepeatable();
    }

    @Override
    public long getContentLength() {
        return postData.getContentLength();
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

    @Override
    public void close() throws IOException {
        postData.finish();
    }

}
