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

/**
 * Allows you to delete all documents from an IDOL server database.
 *
 * @author boba
 */
public class DreDelDBaseCommand extends IndexCommandImpl {

    /** Creates a new instance of <tt>DreDelDBaseCommand</tt>. */
    public DreDelDBaseCommand() {
        super(CMD_DREDELDBASE);
    }

    public String getDreDbName() {
        return get(PARAM_DRE_DBNAME);
    }

    /**
     * Allows you to specify the name of the database which contains the documents that you want to delete. 
     * 
     * @param dreDbName The database from which to delete the documents.
     */
    public void setDreDbName(final String dreDbName) {
        put(PARAM_DRE_DBNAME, dreDbName);
    }

}  // End of class DreDelDBaseCommand...
