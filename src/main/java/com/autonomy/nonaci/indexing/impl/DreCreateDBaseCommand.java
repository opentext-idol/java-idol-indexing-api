/*
 * $Id$
 *
 * Copyright (c) 2008 - 2014, Autonomy Systems Ltd.
 *
 * DreCreateDBaseCommand.java
 * Created on 25-Jun-2008, 17:04:08
 * Last modified by $Author$ on $Date$
 */
package com.autonomy.nonaci.indexing.impl;

import org.apache.commons.lang3.BooleanUtils;

/**
 * Allows you to create a new database in IDOL server (for example, to store documents that related to one particular 
 * subject or to store documents that are relevant to a particular user group).
 *
 * @author boba
 * @version $Revision$ $Date$
 */
public class DreCreateDBaseCommand extends IndexCommandImpl {

    /** Creates a new instance of <tt>DreCreateDBaseCommand</tt>. */
    public DreCreateDBaseCommand() {
        super(CMD_DRECREATEDBASE);
    }
    
    public String getDreDbName() {
        return get(PARAM_DRE_DBNAME);
    }

    /**
     * The name of the database that you want to create in IDOL server. Once the command has been executed, the new 
     * database is listed in the IDOL server configuration file.
     * 
     * @param dreDbName The database to be created. <strong>Required</strong>
     */
    public void setDreDbName(final String dreDbName) {
        put(PARAM_DRE_DBNAME, dreDbName);
    }
    
    public boolean isInternal() {
        return BooleanUtils.toBoolean(get(PARAM_INTERNAL));
    }

    /**
     * Specify <tt>true</tt> to create an internal database. 
     * 
     * @param internal Specifies if the database is internal.
     */
    public void setInternal(final boolean internal) {
        put(PARAM_INTERNAL, BooleanUtils.toStringTrueFalse(internal));
    }
    
    public boolean isReadOnly() {
        return BooleanUtils.toBoolean(get(PARAM_READ_ONLY));
    }

    /**
     * Specify <tt>true</tt> to create a database that is read-only. 
     * 
     * @param readOnly Specifies if the database is read-only. 
     */
    public void setReadOnly(final boolean readOnly) {
        put(PARAM_READ_ONLY, BooleanUtils.toStringTrueFalse(readOnly));
    }

} // End of class DreCreateDBaseCommand...
