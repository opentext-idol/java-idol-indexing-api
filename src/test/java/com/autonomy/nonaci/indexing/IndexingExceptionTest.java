/*
 * $Id$
 *
 * Copyright (c) 2008 - 2009, Autonomy Systems Ltd.
 *
 * IndexingExceptionTest.java
 * Created on 04-Jul-2008, 17:06:29
 * Last modified by $Author$ on $Date$
 */
package com.autonomy.nonaci.indexing;

import java.io.IOException;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * JUnit tests for <tt>com.autonomy.nonaci.indexing.IndexingException</tt>.
 *
 * @author boba
 * @version $Revision$ $Date$
 */
public class IndexingExceptionTest {

    @Test
    public void testDefaultConstructor() {
        // Create an empty one...
        final IndexingException exception = new IndexingException();

        // Check it's properties...
        assertThat("Exception message isn't null.", exception.getMessage(), is(nullValue()));
        assertThat("Exception cause isn't null.", exception.getCause(), is(nullValue()));
    }
    
    @Test
    public void testMessageConstructor() {
        // This is the message to use...
        final String message = "This is a message";
        
        // Create an exception with the message...
        final IndexingException exception = new IndexingException(message);

        // Check it's properties...
        assertThat("Exception message doesn't match.", exception.getMessage(), is(equalTo(message)));
        assertThat("Exception cause isn't null.", exception.getCause(), is(nullValue()));
    }
    
    @Test
    public void testCauseConstructor() {
        // This is the cause to use...
        final String message = "This is the cause...";
        final IOException cause = new IOException(message);
        
        // Create an exception with the message...
        final IndexingException exception = new IndexingException(cause);

        // Check it's properties...
        assertThat("Exception message doesn't match.", exception.getMessage(), is(equalTo(cause.getClass().getName() + ": " + message)));
        assertThat("Exception cause doesn't match.", exception.getCause(), is(sameInstance((Throwable) cause)));
    }
    
    @Test
    public void testMessageAndCauseConstructor() {
        // This is the cause to use...
        final String message = "This is the message...";
        final IOException cause = new IOException("This is the cause...");
        
        // Create an exception with the message...
        final IndexingException exception = new IndexingException(message, cause);

        // Check it's properties...
        assertThat("Exception message doesn't match.", exception.getMessage(), is(equalTo(message)));
        assertThat("Exception cause doesn't match.", exception.getCause(), is(sameInstance((Throwable) cause)));
    }

} // End of class IndexingExceptionTest...
