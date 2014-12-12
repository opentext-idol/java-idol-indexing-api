/*
 * $Id$
 *
 * Copyright (c) 2008 - 2009, Autonomy Systems Ltd.
 *
 * IndexingException.java
 * Created on 19-Jun-2008
 * Last modified by $Author$ on $Date$
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
