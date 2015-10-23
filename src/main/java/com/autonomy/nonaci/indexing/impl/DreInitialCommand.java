/*
 * Copyright 2008-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */
package com.autonomy.nonaci.indexing.impl;

import com.autonomy.nonaci.indexing.IndexingException;
import org.apache.commons.codec.net.URLCodec;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;

/**
 * Allows you to delete all data from your IDOL server's data index, and to reset the data index. Your configuration 
 * file is not reset, so none of your changes are lost.
 * <p />
 * You can also use the <strong>DREINITIAL</strong> command to restore backed up files to an IDOL server. 
 *
 * @author boba
 * @version $Revision$ $Date$
 */
public class DreInitialCommand extends IndexCommandImpl {

    /** The full path to the data backup. */
    private String path;
    
    private final URLCodec urlCodec = new URLCodec();

    /**
     * Default constructor...
     */
    public DreInitialCommand() {
        super(CMD_DREINITIAL);
    }
    
    @Override
    public String getQueryString() {
        // Get the query string comprising of all the other parameters...
        final String queryString = super.getQueryString();

        try {
            return (StringUtils.isBlank(path))
                    ? queryString
                    : StringUtils.isBlank(queryString)
                            ? urlCodec.encode(path, "UTF-8")
                            : urlCodec.encode(path, "UTF-8") + '&' + queryString;
        }
        catch(final UnsupportedEncodingException uee) {
            throw new IndexingException(uee);
        }
    }
    
    public String getInitialId() {
        return get(PARAM_INITIAL_ID);
    }

    /**
     * Enter the ID of the <strong>DREINITIAL</strong> command that should be processed when multiple commands are sent.
     * <p />
     * In a system with an array of DIHs, a <strong>DREINITIAL</strong> command could be sent to an engine multiple 
     * times; and if there was a delay in sending a subsequent command, documents could be deleted that in fact arrived 
     * after the original <strong>DREINITIAL</strong>. The <strong>InitialID</strong> parameter ensures that when a 
     * <strong>DREINITIAL</strong> command is received by an engine multiple times, only the first command (identified 
     * by the <strong>InitialID</strong>) is processed, and the rest are ignored.
     * 
     * @param initialId The ID of the <strong>DREINITIAL</strong> command that should be processed when multiple 
     *         commands are sent.
     */
    public void setInitialId(final String initialId) {
        put(PARAM_INITIAL_ID, initialId);
    }

    public String getHostDetails() {
        return get(PARAM_INITIAL_ID);
    }

    /**
     * Specifies that the restoration should use a backup directory based on a specific host/port combination.
     * <p />
     * When using <strong>DREBACKUP</strong> you can set <strong>HostDetails</strong> to <strong>true</strong>, so that
     * the backup will be written to a subdirectory named with the host and ACI port of the engine. You can then restore
     * these backups using a <strong>DREINITIAL</strong> action with <strong>HostDetails</strong> set to <strong>true
     * <strong>.This allows you to restore a series of engines under a Distributed Index Handler (DIH) from their own
     * backup.
     *
     * @param hostDetails Specifies that the restoration should use a backup directory based on a specific host/port
     * combination.
     */
    public void setHostDetails(final boolean hostDetails) {
        put(PARAM_HOST_DETAILS, BooleanUtils.toStringTrueFalse(hostDetails));
    }

    public String getPath() {
        return path;
    }

    /**
     * Enter the full path to where IDOL server's backups are stored.
     * 
     * @param path The full path to the data backup.
     */
    public void setPath(final String path) {
        this.path = path;
    }
    
} // End of class DreInitialCommand...
