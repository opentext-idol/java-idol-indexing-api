/*
 * Copyright 2008-2015 Open Text.
 *
 * Licensed under the MIT License (the "License"); you may not use this file
 * except in compliance with the License.
 *
 * The only warranties for products and services of Open Text and its affiliates
 * and licensors ("Open Text") are as may be set forth in the express warranty
 * statements accompanying such products and services. Nothing herein should be
 * construed as constituting an additional warranty. Open Text shall not be
 * liable for technical or editorial errors or omissions contained herein. The
 * information contained herein is subject to change without notice.
 */
package com.autonomy.nonaci.indexing.impl;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

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

    /** Creates a new instance of DreBackupCommand */
    public DreBackupCommand() {
        super(CMD_DREBACKUP);
    }

    @Override
    public String getQueryString() {
        return URLEncoder.encode(path, StandardCharsets.UTF_8);
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
