/*
 * Copyright 2008-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */
package com.autonomy.nonaci.indexing.impl;

import com.autonomy.nonaci.indexing.IndexingException;
import org.apache.commons.codec.net.URLCodec;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;

/**
 * Allows you to index IDX or XML files located on the same machine as IDOL server directly into an IDOL server. 
 * Parameters you use with <strong>DREADD</strong> override any equivalent settings in IDOL server's configuration file.
 * <p />
 * If you have set DelayedSync to <strong>true</strong> or you have set a high MaxSyncDelay in the configuration file, 
 * some time may elapse before a file is indexed.
 * <p />
 * <strong>Note:</strong> You must specify <tt>dreDbName</tt> or <tt>databaseFields</tt> if the IDOL server 
 * configuration file does not contain a field process that allows it to read documents' destination databases from 
 * fields they contain.
 *
 * @author boba
 * @version $Revision$ $Date$
 */
public class DreAddCommand extends AbstractAddCommand {

    private String indexFile;
    
    private final URLCodec urlCodec = new URLCodec();
    
    /** Creates a new instance of <tt>DreAddCommand</tt>. */
    public DreAddCommand() {
        super(CMD_DREADD);
    }
    
    @Override
    public String getQueryString() {
        try {
            // Get the query string comprising of all the other parameters...
            final String queryString = super.getQueryString();

            return StringUtils.isNotBlank(queryString)
                    ? urlCodec.encode(indexFile, "UTF-8") + '&' + queryString
                    : urlCodec.encode(indexFile, "UTF-8");
        }
        catch(final UnsupportedEncodingException uee) {
            throw new IndexingException(uee);
        }
    }
    
    public String getIndexFile() {
        return indexFile;
    }

    /**
     * Enter the full path to the IDX or XML file you want to index. Note: The DREADD command also accepts IDX or XML 
     * files that are compressed by gzip.
     * 
     * @param indexFile The full path to the IDX or XML file to be indexed.
     */
    public void setIndexFile(final String indexFile) {
        this.indexFile = indexFile;
    }

    public boolean isDelete() {
        return BooleanUtils.toBoolean(get(PARAM_DELETE));
    }

    /**
     * When set to <tt>true</tt>, IDOL server deletes the file you are indexing after it is indexed.
     * 
     * @param delete <tt>true</tt> to delete the IDX or XML file after indexing.
     */
    public void setDelete(final boolean delete) {
        put(PARAM_DELETE, BooleanUtils.toStringTrueFalse(delete));
    }
    
}  // End of class DreAddCommand...
