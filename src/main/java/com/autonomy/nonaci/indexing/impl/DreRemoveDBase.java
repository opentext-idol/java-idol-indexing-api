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
 * Allows you to delete an IDOL server database and all the documents it contains.
 *
 * @author boba
 */
public class DreRemoveDBase extends IndexCommandImpl {

    /**
     * Creates a new instance of <tt>DreRemoveDBase</tt>.
     */
    public DreRemoveDBase() {
        super(CMD_DREREMOVEDBASE);
    }

    public String getDreDbName() {
        return get(PARAM_DRE_DBNAME);
    }

    /**
     * The name of the database that you want to delete from IDOL server. Once the command has been executed, the
     * database is removed from the IDOL server configuration file.
     * 
     * @param dreDbName The database to be deleted.
     */
    public void setDreDbName(final String dreDbName) {
        put(PARAM_DRE_DBNAME, dreDbName);
    }

}  // End of class DreRemoveDBase...
