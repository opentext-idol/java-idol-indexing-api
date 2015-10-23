/*
 * Copyright 2008-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */
package com.autonomy.nonaci.indexing.impl;

/**
 * If you made changes to your IDOL server configuration file, you can issue the <strong>DRERESET</strong> command to
 * force the IDOL server to read in the changes. No data is altered by this command.
 *
 * @author boba
 */
public class DreResetCommand extends IndexCommandImpl {

    /** Creates a new instance of DreResetCommand */
    public DreResetCommand() {
        super(CMD_DRERESET);
    }

} // End of class DreResetCommand...
