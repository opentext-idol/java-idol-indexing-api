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
