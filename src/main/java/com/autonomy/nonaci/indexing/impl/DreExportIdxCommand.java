/*
 * (c) Copyright 2008-2015 Micro Focus or one of its affiliates.
 *
 * Licensed under the MIT License (the "License"); you may not use this file
 * except in compliance with the License.
 *
 * The only warranties for products and services of Micro Focus and its affiliates
 * and licensors ("Micro Focus") are as may be set forth in the express warranty
 * statements accompanying such products and services. Nothing herein should be
 * construed as constituting an additional warranty. Micro Focus shall not be
 * liable for technical or editorial errors or omissions contained herein. The
 * information contained herein is subject to change without notice.
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
