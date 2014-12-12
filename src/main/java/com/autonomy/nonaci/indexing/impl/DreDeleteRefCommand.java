/*
 * $Id$
 *
 * Copyright (c) 2008 - 2009, Autonomy Systems Ltd.
 *
 * DreDeleteRefCommand.java
 * Created on 03-Jul-2008, 15:15:08
 * Last modified by $Author$ on $Date$
 */
package com.autonomy.nonaci.indexing.impl;

/**
 * Allows you to delete one or more documents by their reference.
 *
 * @author boba
 * @version $Revision$ $Date$
 */
public class DreDeleteRefCommand extends IndexCommandImpl {

    /** Creates a new instance of DreDeleteRefCommand */
    public DreDeleteRefCommand() {
        super(CMD_DREDELETEREF);
    }
    
    public String getDocs() {
        return get(PARAM_DOCS);
    }

    /**
     * Enter the escaped references of the documents that you want to delete. If you want to specify multiple 
     * references, you must separate them with plus symbols (there must be no space before or after a plus symbol).
     * 
     * @param docs The references of the documents to be deleted.
     */
    public void setDocs(final String docs) {
        put(PARAM_DOCS, docs);
    }

    public String getDreDbName() {
        return get(PARAM_DRE_DBNAME);
    }

    /**
     * Allows you to specify the name of the database which contains the documents that you want to delete. If you don't
     * specify a database and the specified document is contained in several databases, it is deleted from all of them.
     * 
     * @param dreDbName The database from which to delete the documents.
     */
    public void setDreDbName(final String dreDbName) {
        put(PARAM_DRE_DBNAME, dreDbName);
    }

    public String getField() {
        return get(PARAM_FIELD);
    }

    /**
     * The field containing the reference specified by <strong>Docs</strong> when a document has more than one 
     * reference.
     * <p />
     * You can specify multiple fields by separating them with commas or spaces (there must be no space before or after
     * a comma).
     * 
     * @param field The field containing the reference specified by Docs.
     */
    public void setField(final String field) {
        put(PARAM_FIELD, field);
    }

} // End of class DreDeleteRefCommand...
