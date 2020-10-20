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
package com.autonomy.nonaci.indexing;

/**
 * This Exception is thrown when an error response is detected when sending an index command.
 *
 * @author boba
 */
public class IndexingException extends RuntimeException {

    private static final long serialVersionUID = -3047555994803656717L;

    /**
     * Constructs a new {@code IndexingException} without specified detail message.
     */
    public IndexingException() {
        super();
    }

    /**
     * Constructs a new {@code IndexingException} with specified detail message.
     *
     * @param msg The error message.
     */
    public IndexingException(final String msg) {
        super(msg);
    }

    /**
     * Constructs a new {@code IndexingException} with specified nested {@code Throwable}.
     *
     * @param cause the exception or error that caused this exception to be thrown
     */
    public IndexingException(final Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new {@code IndexingException} with specified detail message and nested {@code Throwable}.
     *
     * @param msg the error message
     * @param cause the exception or error that caused this exception to be thrown
     */
    public IndexingException(final String msg, final Throwable cause) {
        super(msg, cause);
    }

}  // End of class IndexingException...
