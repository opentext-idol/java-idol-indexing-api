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
package com.autonomy.nonaci.indexing;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Defines methods for handling post data. This interface is based on the Apache HttpClient <tt>HttpEntity</tt> 
 * interface, but without any reference to other HttpClient specific classes or interfaces.
 *
 * @author boba
 */
public interface PostData {

    /**
     * Tells if the entity is capable of producing its data more than once. A repeatable entity's getContent() and
     * writeTo(OutputStream) methods can be called more than once whereas a non-repeatable entity's can not.
     *
     * @return <tt>true</tt> if the entity is repeatable, <tt>false</tt> otherwise.
     */
    boolean isRepeatable();

    /**
     * Tells about chunked encoding for this entity. The primary purpose of this method is to indicate whether chunked
     * encoding should be used when the entity is sent.
     *
     * @return <tt>true</tt> if chunked encoding is preferred for this entity, or <tt>false</tt> if it is not
     */
    boolean isChunked();

    /**
     * Tells the length of the content, if known.
     *
     * @return the number of bytes of the content, or a negative number if unknown. If the content length is known but
     * exceeds {@link java.lang.Long#MAX_VALUE Long.MAX_VALUE}, a negative number is returned.
     */
    long getContentLength();

    /**
     * Obtains the Content-Type header, if known. This is the header that should be used when sending the entity, It can
     * include a charset attribute.
     *
     * @return the Content-Type header for this entity, or <tt>null</tt> if the content type is unknown
     */
    String getContentType();

    /**
     * Obtains the Content-Encoding header, if known. This is the header that should be used when sending the entity.
     * Wrapping entities that modify the content encoding should adjust this header accordingly.
     *
     * @return the Content-Encoding header for this entity, or <tt>null</tt> if the content encoding is unknown
     */
    String getContentEncoding();

    /**
     * Creates a new InputStream object of the entity. It is a programming error to return the same InputStream object
     * more than once. Entities that are not {@link #isRepeatable repeatable} will throw an exception if this method is
     * called multiple times.
     *
     * @return a new input stream that returns the entity data.
     * @throws IOException if the stream could not be created
     * @throws IllegalStateException if this entity is not repeatable and the stream has already been obtained
     * previously
     */
    InputStream getContent() throws IOException;

    /**
     * Writes the entity content to the output stream.
     *
     * @param outstream the output stream to write entity content to
     * @throws IOException if an I/O error occurs
     */
    void writeTo(OutputStream outstream) throws IOException;

    /**
     * Tells whether this entity depends on an underlying stream. Streamed entities should return <tt>true</tt> until
     * the content has been consumed, <tt>false</tt> afterwards. Self-contained entities should return <tt>false</tt>.
     * Wrapping entities should delegate this call to the wrapped entity.
     * <p />
     * The content of a streamed entity is consumed when the stream returned by {@link #getContent getContent} has been
     * read to EOF, or after {@link #finish() finish} has been called. If a streamed entity can not detect whether the
     * stream has been read to EOF, it should return <tt>true</tt> until {@link #finish() finish} is called.
     *
     * @return <tt>true</tt> if the entity content is streamed and not yet consumed, <tt>false</tt> otherwise
     */
    boolean isStreaming();

    /**
     * This method is called to indicate that the content of this entity is no longer required. All entity
     * implementations are expected to release all allocated resources as a result of this method invocation. Content
     * streaming entities are also expected to dispose of the remaining content, if any. Wrapping entities should
     * delegate this call to the wrapped entity.
     *
     * @throws IOException if an I/O error occurs. This indicates that connection keep-alive is not possible.
     */
    void finish() throws IOException;

}
