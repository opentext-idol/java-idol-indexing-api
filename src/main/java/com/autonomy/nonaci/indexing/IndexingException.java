/*
 * Copyright 2008-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */
package com.autonomy.nonaci.indexing;

/**
 * This Exception is thrown when an error response is detected when sending an index command.
 *
 * @author boba
 * @version $Revision$ $Date$
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
