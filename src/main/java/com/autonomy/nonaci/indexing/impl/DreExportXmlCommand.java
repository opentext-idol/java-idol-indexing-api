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

/**
 * Allows you to export XML documents from one or more IDOL databases (use <strong>DREEXPORTIDX</strong> to export IDX 
 * documents).
 * <p />
 * <strong>Note:</strong>
 * <ul>
 *   <li>Multisection documents are not split across chunks, so the <strong>BatchSize</strong> specified  in the 
 *       configuration file is not used exactly if this would require a document section to be split.</li>
 *   <li>You do not need to uncompress compressed XML files before indexing them. For example, the command <strong>
 *       DREADD?output-0.xml.gz</strong> indexes the <strong>output-0.xml.gz</strong> file correctly without you 
 *       uncompressing the file first.</li>
 *  </ul>
 *
 * @author boba
 */
public class DreExportXmlCommand extends AbstractExportCommand {
    
    /** Creates a new instance of DreExportXmlCommand */
    public DreExportXmlCommand() {
        super(CMD_DREEXPORTXML);
    }
    
} // End of class DreExportXmlCommand...
