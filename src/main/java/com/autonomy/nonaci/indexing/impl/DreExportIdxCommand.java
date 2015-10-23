/*
 * Copyright 2008-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */
package com.autonomy.nonaci.indexing.impl;

/**
 * Allows you to export IDX documents from one or more IDOL databases (use <strong>DREEXPORTXML</strong> to export XML 
 * documents).
 * <p />
 * <strong>Note:</strong> Multisection documents are not split across chunks, so the <strong>BatchSize</strong> 
 * specified in the configuration file is not used exactly if this would require a document section to be split.
 *
 * @author boba
 */
public class DreExportIdxCommand extends AbstractExportCommand {

    /** Creates a new instance of DreExportIdxCommand */
    public DreExportIdxCommand() {
        super(CMD_DREEXPORTIDX);
    }
    
} // End of class DreExportIdxCommand...
