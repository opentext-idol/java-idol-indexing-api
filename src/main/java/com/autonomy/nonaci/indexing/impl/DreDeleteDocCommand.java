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
 * Allows you to identify individual documents and/or ranges of documents by their ID, and delete them from IDOL server.
 * <p />
 * To restore a document that was deleted using <strong>DREDELETEDOC</strong>, use the <strong>DREUNDELETEDOC</strong> 
 * command. 
 *
 * @author boba
 */
public class DreDeleteDocCommand extends IndexCommandImpl {
    private final DocsHelper<Long> docsHelper = new DocsHelper<>();

    /** Creates a new instance of DreDeleteDocCommand */
    public DreDeleteDocCommand() {
        super(CMD_DREDELETEDOC);
    }

    @Override
    public String getQueryString() {
        return docsHelper.getQueryString(super.getQueryString());
    }

    public String getDocs() {
        return get(PARAM_DOCS);
    }

    /**
     * @param docIds The IDs of the documents to be deleted.
     */
    public void setDocs(final Collection<Long> docIds) {
        docsHelper.setDocs(this, docIds);
    }

    /**
     * Specify one or more individual documents and / or a range of documents that you want to delete. You can use the
     * following formats to do this (if you want to combine the two formats you must separate them with plus symbols
     * with no spaces before or after a plus symbol):
     * <dl>
     *   <dt>doc IDs</dt>
     *   <dd>Specify the IDs of one or more documents. If you want to specify multiple document IDs, you must separate
     *       them with plus symbols (there must be no space before or after a plus symbol).</dd>
     *   <dt>range=[&lt;first doc&gt;,&lt;last doc&gt;]</dt>
     *   <dd>Enter the document ID of the first and last document in a range of documents that you want to delete. You
     *       can delete up to 5000 documents at a time.</dd>
     * </dl>
     *
     * @param docs The IDs of the documents to be deleted.
     */
    public void setDocs(final String docs) {
        docsHelper.setDocs(this, docs);
    }

    /**
     * Enter the name of a state token (created earlier with the <strong>StoreState</strong> parameter of the <strong>
     * Query</strong>, <strong>Suggest</strong>, or <strong>SuggestOnText</strong> action) that lists the documents do 
     * be deleted.
     * <p />
     * If you specify the token name only, all documents listed in the token are deleted. If you add a (zero-based) 
     * index range -- or individual numbers separated by plus signs -- in square brackets after the token name, only 
     * that range or set of documents is deleted. (Note that you must list the entries in increasing numerical order.)
     * 
     * @param stateId The name of a state token that specifies the documents to be deleted.
     */
    public void setStateId(final String stateId) {
        put(PARAM_STATE_ID, stateId);
    }

} // End of class DreDeleteDocCommand...
