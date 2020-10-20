/*
 * (c) Copyright 2008-2015 Micro Focus or one of its affiliates.
 *
 * Licensed under the MIT License (the "License"); you may not use this file
 * except in compliance with the License.
 *
 * The only warranties for products and services of Micro Focus and its affiliates
 * and licensors ("Micro Focus") are as may be set forth in the express warranty
 * statements accompanying such products and services. Nothing herein should be
 * construed as constituting an additional warranty. Micro Focus shall not be
 * liable for technical or editorial errors or omissions contained herein. The
 * information contained herein is subject to change without notice.
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
