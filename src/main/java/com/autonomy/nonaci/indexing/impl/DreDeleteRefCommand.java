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

import java.util.Collection;

/**
 * Allows you to delete one or more documents by their reference.
 *
 * @author boba
 */
public class DreDeleteRefCommand extends IndexCommandImpl {
    private final DocsHelper<String> docsHelper = new DocsHelper<>();

    /** Creates a new instance of DreDeleteRefCommand */
    public DreDeleteRefCommand() {
        super(CMD_DREDELETEREF);
    }

    @Override
    public String getQueryString() {
        return docsHelper.getQueryString(super.getQueryString());
    }
    
    public String getDocs() {
        return get(PARAM_DOCS);
    }

    /**
     * @param docRefs The references of the documents to be deleted.
     */
    public void setDocs(final Collection<String> docRefs) {
        docsHelper.setDocs(this, docRefs);
    }

    /**
     * @param docs The references of the documents to be deleted, already encoded in the format expected by IDOL.
     */
    public void setEncodedDocs(final String docs) {
        docsHelper.setEncodedDocs(this, docs);
    }

    /**
     * Enter the unescaped references of the documents that you want to delete. If you want to specify multiple
     * references, you must separate them with spaces. Warning: if references contain plus symbols or spaces, the query
     * sent to IDOL will be incorrectly encoded.
     * 
     * @param docs The references of the documents to be deleted.
     */
    @Deprecated
    public void setDocs(final String docs) {
        docsHelper.setDocs(this, docs);
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
