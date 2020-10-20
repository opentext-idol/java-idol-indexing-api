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
 * Allows you to reduce the space left when documents in IDOL server's data index are deleted. The <strong>DRECOMPACT
 * </strong> command fills the space created through the document deletion with new documents. (This is similar to the
 * defragmentation process). Once the compact is complete, the command recalculates the <strong>SortField</strong>
 * information.
 * <p />
 * By default, the <strong>DRECOMPACT</strong> command automatically copies the data index to the <strong>internalbackup
 * </strong> directory in the IDOL server's data directory. To change this directory, set the <em>
 * PreCompactionBackupPath</em> configuration parameter.
 *
 * @author boba
 */
public class DreCompactCommand extends IndexCommandImpl {

    /** Creates a new instance of DreCompactCommand */
    public DreCompactCommand() {
        super(CMD_DRECOMPACT);
    }

} // End of class DreCompactCommand...
