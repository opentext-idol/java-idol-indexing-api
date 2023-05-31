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
 * Allows you to rename an IDOL server database.
 *
 * @author boba
 */
public class DreRenameDBaseCommand extends IndexCommandImpl {

    /**
     * Creates a new instance of <tt>DreRenameDBaseCommand</tt>.
     */
    public DreRenameDBaseCommand() {
        super(CMD_DRERENAMEDBASE);
    }

    public String getDreDbName() {
        return get(PARAM_DRE_DBNAME);
    }

    /**
     * The name of the database you want to rename.
     *
     * @param dreDbName The name of the database you want to rename.
     */
    public void setDreDbName(final String dreDbName) {
        put(PARAM_DRE_DBNAME, dreDbName);
    }

    public String getNewName() {
        return get(PARAM_NEW_NAME);
    }

    /**
     * The new name of the database.
     *
     * @param newName The new name of the database.
     */
    public void setNewName(final String newName) {
        put(PARAM_NEW_NAME, newName);
    }
    
}  // End of class DreRenameDBaseCommand...
