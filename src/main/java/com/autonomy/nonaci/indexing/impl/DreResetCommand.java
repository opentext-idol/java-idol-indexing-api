/*
 * $Id$
 *
 * Copyright (c) 2008, Autonomy Systems Ltd.
 *
 * DreResetCommand.java
 * Created on 04-Jul-2008, 10:17:58
 * Last modified by $Author$ on $Date$
 */
package com.autonomy.nonaci.indexing.impl;

/**
 * If you made changes to your IDOL server configuration file, you can issue the <strong>DRERESET</strong> command to
 * force the IDOL server to read in the changes. No data is altered by this command.
 *
 * @author boba
 * @version $Revision$ $Date$
 */
public class DreResetCommand extends IndexCommandImpl {

    /** Creates a new instance of DreResetCommand */
    public DreResetCommand() {
        super(CMD_DRERESET);
    }

} // End of class DreResetCommand...
