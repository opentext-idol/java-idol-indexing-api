/*
 * $Id$
 *
 * Copyright (c) 2008 - 2014, Autonomy Systems Ltd.
 *
 * PostDataHttpEntity.java
 * Created on 09-Oct-2008
 * Last modified by $Author$ on $Date$
 */
package com.autonomy.nonaci.indexing.impl;

import com.autonomy.nonaci.indexing.PostData;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.lang3.Validate;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;

/**
 * A simple implementation of the {@link org.apache.http.HttpEntity} interface that proxies all calls to the underlying
 * {@link com.autonomy.nonaci.indexing.PostData} implementaiton.
 *
 * @author boba
 * @version $Revision$ $Date$
 */
public class PostDataHttpEntity implements HttpEntity {

    private final PostData postData;

    public PostDataHttpEntity(final PostData postData) {
        Validate.notNull(postData, "postData must not be null.");
        this.postData = postData;
    }

    public boolean isRepeatable() {
        return postData.isRepeatable();
    }

    public boolean isChunked() {
        return postData.isChunked();
    }

    public long getContentLength() {
        return postData.getContentLength();
    }

    public Header getContentType() {
        Header header = null;

        final String ctString = postData.getContentType();
        if(ctString != null) {
            header = new BasicHeader(HTTP.CONTENT_TYPE, ctString);
        }
        
        return header;
    }

    public Header getContentEncoding() {
        Header header = null;

        final String ceString = postData.getContentEncoding();
        if(ceString != null) {
            header = new BasicHeader(HTTP.CONTENT_ENCODING, ceString);
        }

        return header;
    }

    public InputStream getContent() throws IOException {
        return postData.getContent();
    }

    public void writeTo(final OutputStream outstream) throws IOException {
        postData.writeTo(outstream);
    }

    public boolean isStreaming() {
        return postData.isStreaming();
    }

    /**
     * @deprecated Use {@link org.apache.http.util.EntityUtils#consume(org.apache.http.HttpEntity)} instead.
     */
    @Deprecated
    public void consumeContent() throws IOException {
        postData.finish();
    }

}
