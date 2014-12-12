/*
 * $Id$
 *
 * Copyright (c) 2008 - 2009, Autonomy Systems Ltd.
 *
 * DreUndeleteDocCommand.java
 * Created on 04-Jul-2008, 11:16:46
 * Last modified by $Author$ on $Date$
 */
package com.autonomy.nonaci.indexing.impl;

/**
 * Allows you to restore documents deleted by the the <tt>DREDELETEDOC</tt> command. If you  used the <strong>
 * DREDELETEDOC</strong> command to delete documents from IDOL server’s data index, you can use the <strong>
 * DREUNDELETEDOC</strong> command to restore some or all of the individual documents; provided  you have not executed 
 * a <strong>DRECOMPACT</strong> command which removes unused documents and space from IDOL server.
 *
 * @author boba
 * @version $Revision$ $Date$
 */
public class DreUndeleteDocCommand extends IndexCommandImpl {

    /** Creates a new instance of <tt>DreUndeleteDocCommand<tt>. */
    public DreUndeleteDocCommand() {
        super(CMD_DREUNDELETEDOC);
    }
    
    public String getDocs() {
        return get(PARAM_DOCS);
    }

    /**
     * Specify one or more individual documents and / or a range of documents that you want to restore. You can use the 
     * following formats to do this (if you want to combine the two formats you must separate them with plus symbols 
     * with no spaces before or after a plus symbol):
     * <p />
     * <dl>
     *   <dt><strong>doc IDs</strong></dt>
     *   <dd>Specify the IDs of one or more documents. If you want to specify multiple document IDs, you must separate 
     *       them with plus symbols (there must be no space before or after a plus symbol).</dd>
     *   <dt><strong>range=[&#60;first doc&#62;,&#60;last doc&#62;]</strong></dt>
     *   <dd>Enter the document ID of the first and last document in a range of documents that you want to restore. You
     *       can restore up to 5000 documents at a time.</dd>
     * </dl>
     * 
     * @param docs The IDs of the documents to be restored.
     */
    public void setDocs(final String docs) {
        put(PARAM_DOCS, docs);
    }

} // End of class DreUndeleteDocCommand...
