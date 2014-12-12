/*
 * $Id$
 *
 * Copyright (c) 2008 - 2009, Autonomy Systems Ltd.
 *
 * InputStreamPostDataImpl.java
 * Created on 09-Oct-2008
 * Last modified by $Author$ on $Date$
 */
package com.autonomy.nonaci.indexing.impl;

import java.io.InputStream;

/**
 * This implementation of the {@link com.autonomy.nonaci.indexing.PostData} interface can be used to send {@link
 * java.io.InputStream} objects. If the initial request fails and the underlying HTTP implementation supports retires,
 * this implementation <strong>is not</strong> repeatable. If the content length is unknown, then it should be set to a
 * negative number and the underlying HTTP implementation should chunk the stream when sending it, as this
 * implementation doesn't do any chunking.
 *
 * @author boba
 * @version $Revision$ $Date$
 * @deprecated As of 2.0.0, use {@link PostDataImpl} instead
 */
@Deprecated
public class InputStreamPostDataImpl extends PostDataImpl {

    public InputStreamPostDataImpl(final InputStream inputStream) {
        this(inputStream, -1);
    }

    public InputStreamPostDataImpl(final InputStream inputStream, final long length) {
        super(inputStream, length);
    }
    
}
