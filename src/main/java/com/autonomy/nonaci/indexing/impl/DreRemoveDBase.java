/*
 * $Id$
 *
 * Copyright (c) 2008 - 2009, Autonomy Systems Ltd.
 *
 * DreRemoveDBase.java
 * Created on 25-Jun-2008
 * Last modified by $Author$ on $Date$
 */
package com.autonomy.nonaci.indexing.impl;

/**
 * Allows you to delete an IDOL server database and all the documents it contains.
 *
 * @author boba
 * @version $Revision$ $Date$
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