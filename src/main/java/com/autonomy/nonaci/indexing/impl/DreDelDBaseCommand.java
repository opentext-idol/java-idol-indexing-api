/*
 * $Id$
 *
 * Copyright (c) 2008 - 2009, Autonomy Systems Ltd.
 *
 * DreDelDBaseCommand.java
 * Created on 25-Jun-2008
 * Last modified by $Author$ on $Date$
 */
package com.autonomy.nonaci.indexing.impl;

/**
 * Allows you to delete all documents from an IDOL server database.
 *
 * @author boba
 * @version $Revision$ $Date$
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
