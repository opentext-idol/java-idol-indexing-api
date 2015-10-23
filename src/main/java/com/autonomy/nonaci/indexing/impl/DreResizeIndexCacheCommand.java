/*
 * Copyright 2008-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */
package com.autonomy.nonaci.indexing.impl;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * Allows you to resize the IDOL server indexing cache without restarting the server.
 * The default size of the index cache at IDOL server startup is determined by the value of the <strong>
 * IndexCacheMaxSize</strong> configuration parameter in the <strong>[IndexCache]</strong> section of the IDOL server 
 * configuration file. Using the <strong>DRERESIZEINDEXCACHE</strong> command allows you to change the cache size 
 * dynamically -- for example, to decrease it after performing a large bulk indexing job.
 * <p />
 * <strong>Note:</strong> Because the cache must be flushed before it is resized, invoking this command more often than 
 * necessary can degrade indexing performance.
 *
 * @author boba
 * @version $Revision$ $Date$
 */
public class DreResizeIndexCacheCommand extends IndexCommandImpl {

    /** Creates a new instance of <tt>DreResizeIndexCacheCommand</tt>. */
    public DreResizeIndexCacheCommand() {
        super(CMD_DRERESIZEINDEXCACHE);
    }

    /**
     * @return If the return value is <tt>-1</tt> this indicates that the property hasn't been set.
     */
    public int getIndexCacheMaxSize() {
        return NumberUtils.toInt(get(PARAM_INDEX_CACHE_MAX_SIZE), -1);
    }

    /**
     * Specify the desired size (in Kb) for the cache index. If the full requested amount is not available, the system 
     * will attempt to allocate as much of it as possible.
     * 
     * @param indexCacheMaxSize The new cache size.
     * @throws java.lang.IllegalArgumentException If the specified value is out of range (10240 < <tt>indexCacheMaxSize
     * </tt> < 2048000).
     */
    public void setIndexCacheMaxSize(final int indexCacheMaxSize) {
        if((indexCacheMaxSize < 10240) || (indexCacheMaxSize > 2048000)) {
            throw new IllegalArgumentException("The specified indexCacheMaxSize is out of range. The allowed range is 10240 < indexCacheMaxSize < 2048000.");
        }
        
        put(PARAM_INDEX_CACHE_MAX_SIZE, String.valueOf(indexCacheMaxSize));
    }

} // End of class DreResizeIndexCacheCommand...
