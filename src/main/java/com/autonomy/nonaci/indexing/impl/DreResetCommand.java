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
