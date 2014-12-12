/*
 * $Id$
 *
 * Copyright (c) 2008 - 2009, Autonomy Systems Ltd.
 *
 * DreExportIdxCommand.java
 * Created on 03-Jul-2008, 16:36:44
 * Last modified by $Author$ on $Date$
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
 * @version $Revision$ $Date$
 */
public class DreExportIdxCommand extends AbstractExportCommand {

    /** Creates a new instance of DreExportIdxCommand */
    public DreExportIdxCommand() {
        super(CMD_DREEXPORTIDX);
    }
    
} // End of class DreExportIdxCommand...
