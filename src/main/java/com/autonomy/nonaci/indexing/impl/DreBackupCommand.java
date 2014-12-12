/*
 * $Id$
 *
 * Copyright (c) 2008 - 2009, Autonomy Systems Ltd.
 *
 * DreBackupCommand.java
 * Created on 03-Jul-2008, 14:45:25
 * Last modified by $Author$ on $Date$
 */
package com.autonomy.nonaci.indexing.impl;

import com.autonomy.nonaci.indexing.IndexingException;
import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.net.URLCodec;

/**
 * Allows you to back up IDOL server's data index. This command copies all the IDOL server data index's *.DB files to a 
 * specified location.
 * <p />
 * To restore backed up files, use the <strong>DREINITIAL</strong> command.
 *
 * @author boba
 * @version $Revision$ $Date$
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
        catch(UnsupportedEncodingException uee) {
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
