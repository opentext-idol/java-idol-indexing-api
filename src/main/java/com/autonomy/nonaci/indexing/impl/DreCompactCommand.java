/*
 * $Id$
 *
 * Copyright (c) 2008, Autonomy Systems Ltd.
 *
 * DreCompactCommand.java
 * Created on 03-Jul-2008, 14:54:38
 * Last modified by $Author$ on $Date$
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
 * @version $Revision$ $Date$
 */
public class DreCompactCommand extends IndexCommandImpl {

    /** Creates a new instance of DreCompactCommand */
    public DreCompactCommand() {
        super(CMD_DRECOMPACT);
    }

} // End of class DreCompactCommand...
