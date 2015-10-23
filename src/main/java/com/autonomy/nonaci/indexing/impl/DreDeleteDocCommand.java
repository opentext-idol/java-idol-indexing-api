/*
 * Copyright 2008-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */
package com.autonomy.nonaci.indexing.impl;

/**
 * Allows you to identify individual documents and/or ranges of documents by their ID, and delete them from IDOL server.
 * <p />
 * To restore a document that was deleted using <strong>DREDELETEDOC</strong>, use the <strong>DREUNDELETEDOC</strong> 
 * command. 
 *
 * @author boba
 * @version $Revision$ $Date$
 */
public class DreDeleteDocCommand extends IndexCommandImpl {

    /** Creates a new instance of DreDeleteDocCommand */
    public DreDeleteDocCommand() {
        super(CMD_DREDELETEDOC);
    }

    public String getDocs() {
        return get(PARAM_DOCS);
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
        put(PARAM_DOCS, docs);
    }

    public String getStateId() {
        return get(PARAM_STATE_ID);
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
