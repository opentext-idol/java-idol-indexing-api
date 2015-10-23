/*
 * Copyright 2008-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */
package com.autonomy.nonaci.indexing.impl;

/**
 * This implementation of the {@link com.autonomy.nonaci.indexing.PostData} interface can be used to send {@link
 * java.lang.String} objects. If the initial request fails and the underlying HTTP implementation supports retires, this
 * implementation <strong>is</strong> repeatable. The content length is worked out from the length of the string and the
 * content type defaults to <tt>text/plain; charset=UTF-8</tt>.
 *
 * @author boba
 * @deprecated As of 2.0.0, use {@link PostDataImpl} instead
 */
@Deprecated
public class StringPostDataImpl extends PostDataImpl {

    public StringPostDataImpl(final String string) {
        this(string, null);
    }

    public StringPostDataImpl(final String string, final String charset) {
        super(string, charset);
    }

}
