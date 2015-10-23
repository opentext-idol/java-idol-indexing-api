/*
 * $Id$
 *
 * Copyright (c) 2008 - 2014, Autonomy Systems Ltd.
 *
 * FilePostDataImpl.java
 * Created on 09-Oct-2008
 * Last modified by $Author$ on $Date$
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
