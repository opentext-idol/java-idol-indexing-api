/*
 * $Id$
 *
 * Copyright (c) 2013, Autonomy Systems Ltd.
 *
 * ServerDetailsTest.java
 * Created on 03/12/13, 17:39
 * Last modified by $Author$ on $Date$
 */
package com.autonomy.nonaci;

import org.junit.Test;

import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.fail;

/**
 * .
 *
 * @author boba
 * @version $Revision$ $Date$
 */
public class ServerDetailsTest {

    @Test
    public void testDefaultConstructor() {
        // Create an instance...
        final ServerDetails details = new ServerDetails();
        
        // Check everything is null...
        assertThat("protocol property is not HTTP", details.getProtocol(), is(equalTo(ServerDetails.TransportProtocol.HTTP)));
        assertThat("host property is not null", details.getHost(), is(nullValue()));
        assertThat("port property is not 0", details.getPort(), is(0));
        assertThat("charsetName property is incorrect", details.getCharsetName(), is("UTF-8"));
    }

    @Test
    public void testTwoParamConstructor() {
        try {
            new ServerDetails(null, 10);
            fail("Should have thrown a NullPointerException as host is null.");
        }
        catch(NullPointerException npe) { /* ignore */ }

        try {
            new ServerDetails("localhost", -10);
            fail("Should have thrown an IllegalArgumentException as the port is out of range.");
        }
        catch(IllegalArgumentException iae) { /* ignore */ }

        try {
            new ServerDetails("localhost", 123456789);
            fail("Should have thrown an IllegalArgumentException as the port is out of range.");
        }
        catch(IllegalArgumentException iae) { /* ignore */ }

        // Create one for real...
        final ServerDetails details = new ServerDetails("localhost", 10);

        // Check everything is null...
        assertThat(details.getProtocol(), is(equalTo(ServerDetails.TransportProtocol.HTTP)));
        assertThat(details.getHost(), is(equalTo("localhost")));
        assertThat(details.getPort(), is(10));
        assertThat(details.getCharsetName(), is("UTF-8"));
    }

    @Test
    public void testThreeParamConstructor() {
        try {
            new ServerDetails(null, null, 10);
            fail("Should have thrown a NullPointerException as the protocol was set to null.");
        }
        catch(NullPointerException npe) { /* ignore */ }

        try {
            new ServerDetails(ServerDetails.TransportProtocol.HTTPS, null, 10);
            fail("Should have thrown a NullPointerException as host is null.");
        }
        catch(NullPointerException npe) { /* ignore */ }

        try {
            new ServerDetails(ServerDetails.TransportProtocol.HTTPS, "localhost", -10);
            fail("Should have thrown an IllegalArgumentException as the port is out of range.");
        }
        catch(IllegalArgumentException iae) { /* ignore */ }

        try {
            new ServerDetails(ServerDetails.TransportProtocol.HTTPS, "localhost", 123456789);
            fail("Should have thrown an IllegalArgumentException as the port is out of range.");
        }
        catch(IllegalArgumentException iae) { /* ignore */ }

        // Create one for real...
        final ServerDetails details = new ServerDetails(ServerDetails.TransportProtocol.HTTPS, "localhost", 10);

        // Check everything is null...
        assertThat(details.getProtocol(), is(equalTo(ServerDetails.TransportProtocol.HTTPS)));
        assertThat(details.getHost(), is(equalTo("localhost")));
        assertThat(details.getPort(), is(10));
        assertThat(details.getCharsetName(), is("UTF-8"));
    }

    @Test
    public void testCopyConstructor() {
        // Create an instance...
        final ServerDetails details = new ServerDetails();
        details.setHost("localhost");
        details.setPort(12345);

        // Copy...
        final ServerDetails newDetails = new ServerDetails(details);
        
        // Check everything was coppied across...
        assertThat("protocol", newDetails.getProtocol(), is(equalTo(details.getProtocol())));
        assertThat("host", newDetails.getHost(), is(equalTo(details.getHost())));
        assertThat("port", newDetails.getPort(), is(equalTo(details.getPort())));
        assertThat("charsetName", newDetails.getCharsetName(), is(equalTo(details.getCharsetName())));
    }
    
    @Test(expected=NullPointerException.class)
    public void testProtocolProperty() {
        // Create an instance...
        final ServerDetails details = new ServerDetails();
        assertThat("protocol property is not HTTP", details.getProtocol(), is(ServerDetails.TransportProtocol.HTTP));
        
        // Set the protocol to something else...
        details.setProtocol(ServerDetails.TransportProtocol.HTTPS);
        assertThat("protocol property is not HTTPS", details.getProtocol(), is(ServerDetails.TransportProtocol.HTTPS));
        
        // Set the protocol to null and check....
        details.setProtocol(null);
        fail("Should have thrown an NullPointerException as the protocol has been set to null.");
    }
    
    @Test(expected=NullPointerException.class)
    public void testHostProperty() {
        // Create an instance...
        final ServerDetails details = new ServerDetails();
        assertThat("host property is not null", details.getHost(), is(nullValue()));
        
        // Set the host to something...
        final String host = "host.example.com";
        details.setHost(host);
        assertThat("host property is not as expected", details.getHost(), is(equalTo(host)));
        
        // Set the host to null and check....
        details.setHost(null);
        fail("Should have thrown an NullPointerException as the host has been set to null.");
    }
    
    @Test
    public void testPortProperty() {
        // Create an instance...
        final ServerDetails details = new ServerDetails();
        assertThat("port property is not 0", details.getPort(), is(0));
        
        // Set the port to minus out of range...
        try {
            details.setPort(-10);
            fail("Should have thrown an IllegalArgumentException as port is out of range.");
        }
        catch(IllegalArgumentException iae) {
            // Expected due to out of range port number...
        }
        
        // Set port to positive out of range...
        try {
            details.setPort(90000);
            fail("Should have thrown an IllegalArgumentException as port is out of range.");
        }
        catch(IllegalArgumentException iae) {
            // Expected due to out of range port number...
        }
        
        // Set the port to a number in range...
        final int port = 12000;
        details.setPort(port);
        assertThat("port property is not as expected", details.getPort(), is(equalTo(port)));
    }

    @Test
    public void testCharsetNameProperty() {
        // Create an instance...
        final ServerDetails details = new ServerDetails();
        assertThat("charsetName property is not null", details.getCharsetName(), is("UTF-8"));
        
        // Set the charsetName to something...
        final String charsetName = "ISO-8859-1";
        details.setCharsetName(charsetName);
        assertThat("charsetName property is not as expected", details.getCharsetName(), is(equalTo(charsetName)));
        
        // Set the charsetName to null and check....
        try {
            details.setCharsetName(null);
            fail("Should have thrown an IllegalArgumentException as charsetName is null.");
        }
        catch(IllegalArgumentException iae) {
            // Expected...
        }
        
        // Set the charsetName to an illegal charset name and check....
        try {
            details.setCharsetName("_~@£$");
            fail("Should have thrown an IllegalCharsetNameException as charsetName is illegal.");
        }
        catch(IllegalCharsetNameException icne) {
            // Expected...
        }
        
        // Set the charsetName to an unsupported charset and check....
        try {
            details.setCharsetName("wibble");
            fail("Should have thrown an UnsupportedCharsetException as charsetName is unsupported.");
        }
        catch(UnsupportedCharsetException uce) {
            // Expected...
        }
    }
    
    @Test
    public void testEqualsMethod() {
        // Create an instance...
        final ServerDetails details1 = new ServerDetails();
        details1.setHost("host1.example.com");
        details1.setPort(5790);
        details1.setCharsetName("UTF-8");
        
        // Create another instance...
        final ServerDetails details2 = new ServerDetails();
        details2.setHost("host2.example.com");
        details2.setPort(5790);
        details2.setCharsetName("UTF-8");
        
        // Compare to itself and the other details...
        assertThat("Details should be equal to itself", details1.equals(details1), is(true));
        assertThat("Details should not be equal", details1.equals(details2), is(false));
        
        // Change details2 to have the same name so tecxhnically they'return the same...
        details2.setHost("host1.example.com");
        assertThat("Details should be equal", details1.equals(details2), is(true));
        
        // Compare it to some random object, it should be false...
        assertThat("Parameters should be equal", details1.equals(new Object()), is(false));
        
        // Create yet another instance...
        final ServerDetails details3 = new ServerDetails();
        details3.setHost("host1.example.com");
        details3.setPort(5790);
        details3.setCharsetName("UTF-8");

        // Should be the same as details1...
        assertThat(details3.equals(details1), is(true));
    }
    
    @Test
    public void testHashCodeMethod() {
        // Create an instance...
        final ServerDetails details1 = new ServerDetails();
        details1.setHost("host1.example.com");
        details1.setPort(5790);
        details1.setCharsetName("UTF-8");
        
        // Create an instance...
        final ServerDetails details2 = new ServerDetails();
        details2.setHost("host1.example.com");
        details2.setPort(5790);
        details2.setCharsetName("UTF-8");
        
        // Create yet another instance...
        final ServerDetails details3 = new ServerDetails();
        details3.setHost("host2.example.com");
        details3.setPort(5790);
        details3.setCharsetName("UTF-8");
        
        // Assert that 1 & 2 are the same and 1 & 3 and 2 & 3 are different...
        assertThat("Hash codes should be equal", details1.hashCode() == details2.hashCode(), is(true));
        assertThat("Hash codes should not be equal", details1.hashCode() == details3.hashCode(), is(false));
        assertThat("Hash codes should not be equal", details2.hashCode() == details3.hashCode(), is(false));
    }

}
