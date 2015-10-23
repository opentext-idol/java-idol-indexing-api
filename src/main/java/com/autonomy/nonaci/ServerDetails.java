/*
 * Copyright 2008-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */
package com.autonomy.nonaci;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

/**
 * Holds the protocol, host and port details of a non-ACI Server.
 *
 * @author boba
 * @version $Revision$ $Date$
 */
public class ServerDetails {

    /** Holds the different types of transport protocol that can be used by ACI servers. */
    public enum TransportProtocol {HTTP, HTTPS}

    /** Holds value of property protocol. Defaults to <tt>TransportProtocol.HTTP</tt>. */
    private TransportProtocol protocol = TransportProtocol.HTTP;

    /** Holds value of property host. */
    private String host;

    /** Holds value of property port. */
    private int port;

    /** Holds value of property charsetName. Defaults to UTF-8. */
    private String charsetName = "UTF-8";

    /**
     * Default constructor
     */
    public ServerDetails() {
        super();
    }

    /**
     * Creates connection details for a server, with the specified {@code host} and {@code port} details and
     * with the default {@code protocol} and {@code charsetName} values.
     *
     * @param host The host of the server
     * @param port The port of the server
     */
    public ServerDetails(final String host, final int port) {
        Validate.notNull(host, "host must not be null, it must be set to a value");
        Validate.isTrue((port >= 0) && (port <= 65536), "port is out of range, it should be between 0 and 65536.");

        this.host = host;
        this.port = port;
    }

    /**
     * Creates connection details for a server, with the specified {@code protocol}, {@code host} and {@code port}
     * details and with the default {@code charsetName} value.
     *
     * @param protocol The protocol to use when communicating with the ACI server
     * @param host The host of the ACI server
     * @param port The port of the ACI server
     */
    public ServerDetails(final TransportProtocol protocol, final String host, final int port) {
        Validate.notNull(protocol, "protocol must not be null, it must be set to a value");
        Validate.notNull(host, "host must not be null, it must be set to a value");
        Validate.isTrue((port >= 0) && (port <= 65536), "port is out of range, it should be between 0 and 65536.");

        this.protocol = protocol;
        this.host = host;
        this.port = port;
    }

    /**
     * Copy constructor.
     *
     * @param that The {@link ServerDetails} to copy details from.
     */
    public ServerDetails(final ServerDetails that) {
        this.protocol = that.protocol;
        this.host = that.host;
        this.port = that.port;
        this.charsetName = that.charsetName;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    /**
     * Indicates whether some other object is <em>equal to</em> this one.
     *
     * @param obj the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise.
     */
    @Override
    public boolean equals(final Object obj) {
        boolean returnValue = false;

        if(this == obj) {
            returnValue = true;
        }
        else if(obj instanceof ServerDetails) {
            final ServerDetails that = (ServerDetails) obj;

            // Build the comparison...
            returnValue = new EqualsBuilder()
                    .append(this.protocol, that.protocol)
                    .append(this.host, that.host)
                    .append(this.port, that.port)
                    .append(this.charsetName, that.charsetName)
                    .isEquals();
        }

        return returnValue;
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder(3, 27)
                .append(protocol)
                .append(host)
                .append(port)
                .append(charsetName)
                .toHashCode();
    }

    /**
     * Getter for property protocol.
     * @return Value of property protocol.
     */
    public TransportProtocol getProtocol() {
        return protocol;
    }

    /**
     * Setter for property protocol.
     *
     * @param protocol New value of property protocol.
     * @throws java.lang.IllegalArgumentException if <tt>protocol</tt> is null.
     */
    public void setProtocol(final TransportProtocol protocol) {
        Validate.notNull(protocol, "protocol must not be null, it must be set to a value");
        this.protocol = protocol;
    }

    /**
     * Getter for property host.
     * @return Value of property host.
     */
    public String getHost() {
        return this.host;
    }

    /**
     * Setter for property host.
     * @param host New value of property host.
     */
    public void setHost(final String host) {
        Validate.notNull(host, "host must not be null, it must be set to a value");
        this.host = host;
    }

    /**
     * Getter for property port.
     * @return Value of property port.
     */
    public int getPort() {
        return this.port;
    }

    /**
     * Setter for property port. The port number must be in the range <tt>0 &lt;= port &lt;= 65536</tt> or an
     * <tt>IllegalArgumentException</tt> will be thrown.
     *
     * @param port New value of property port.
     * @throws IllegalArgumentException if the <tt>port</tt> is outside the range <tt>0 &lt;= port &lt;= 65536</tt>.
     */
    public void setPort(final int port) {
        Validate.isTrue((port >= 0) && (port <= 65536), "port is out of range, it should be between 0 and 65536.");
        this.port = port;
    }

    /**
     * Getter for property charsetName.
     * @return Value of property charsetName.
     */
    public String getCharsetName() {
        return this.charsetName;
    }

    /**
     * Setter for property charsetName.
     *
     * @param charsetName The name of the requested charset; may be either a canonical name or an alias
     * @throws java.lang.IllegalArgumentException If <tt>charsetName</tt> is null
     * @throws java.nio.charset.IllegalCharsetNameException If the given charset name is illegal
     * @throws java.nio.charset.UnsupportedCharsetException If no support for the named charset is available in this
     *         instance of the Java virtual machine
     */
    public void setCharsetName(final String charsetName) {
        if(Charset.isSupported(charsetName)) {
            this.charsetName = charsetName;
        }
        else {
            throw new UnsupportedCharsetException("No support for, " + charsetName + ", is available in this instance of the JVM");
        }
    }

}
