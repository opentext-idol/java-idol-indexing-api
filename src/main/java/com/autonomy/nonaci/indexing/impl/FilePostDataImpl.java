/*
 * Copyright 2008-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */
package com.autonomy.nonaci.indexing.impl;

import org.apache.http.entity.ContentType;

import java.io.File;
import java.nio.charset.Charset;

/**
 * This implementation of the {@link com.autonomy.nonaci.indexing.PostData} interface can be used to send the contents
 * of a file. If the initial request fails and the underlying HTTP implementation supports retires, this implementation
 * <strong>is</strong> repeatable. The content length is worked out from the length of the file and the content type
 * defaults to <tt>text/plain; charset=UTF-8</tt>.
 *
 * @author boba
 * @version $Revision$ $Date$
 * @deprecated As of 2.0.0, use {@link PostDataImpl} instead
 */
@Deprecated
public class FilePostDataImpl extends PostDataImpl {

    public FilePostDataImpl(final File data) {
        this(data, ContentType.create("text/plain", Charset.forName("UTF-8")));
    }

    public FilePostDataImpl(final File data, final String contentType) {
        super(data, contentType);
    }

    public FilePostDataImpl(final File data, final ContentType contentType) {
        super(data, contentType);
    }
    
}
