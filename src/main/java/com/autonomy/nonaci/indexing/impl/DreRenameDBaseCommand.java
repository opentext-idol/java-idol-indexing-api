/*
 * Copyright 2008-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */
package com.autonomy.nonaci.indexing.impl;

/**
 * Allows you to rename an IDOL server database.
 *
 * @author boba
 * @version $Revision$ $Date$
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
