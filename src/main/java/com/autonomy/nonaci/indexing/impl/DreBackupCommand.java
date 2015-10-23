/*
 * Copyright 2008-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */
package com.autonomy.nonaci.indexing.impl;

import com.autonomy.nonaci.indexing.IndexingException;
import org.apache.commons.codec.net.URLCodec;

import java.io.UnsupportedEncodingException;

/**
 * Allows you to back up IDOL server's data index. This command copies all the IDOL server data index's *.DB files to a 
 * specified location.
 * <p />
 * To restore backed up files, use the <strong>DREINITIAL</strong> command.
 *
 * @author boba
 */
public class DreBackupCommand extends IndexCommandImpl {

    /** The full path to the location where the backup is created. */
    private String path;
    
    private final URLCodec urlCodec = new URLCodec();
    
    /** Creates a new instance of DreBackupCommand */
    public DreBackupCommand() {
        super(CMD_DREBACKUP);
    }

    @Override
    public String getQueryString() {
        try {
            return urlCodec.encode(path, "UTF-8");
        }
        catch(final UnsupportedEncodingException uee) {
            throw new IndexingException(uee);
        }
    }
    
    public String getPath() {
        return path;
    }

    /**
     * Enter the full path to the location you want to create IDOL server's backup. In Windows, a unicode path can be 
     * used.
     * 
     * @param path The full path to the location where the backup is created.
     */
    public void setPath(final String path) {
        this.path = path;
    }

} // End of class DreBackupCommand...
