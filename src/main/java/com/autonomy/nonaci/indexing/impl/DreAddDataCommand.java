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
 * The <strong>DREADDDATA</strong> command allows you to index data over a socket into an IDOL server. Parameters you 
 * use with <strong>DREADDDATA</strong> override any equivalent settings in IDOL server's configuration file.
 * <p />
 * If you have set <em>DelayedSync</em> to <strong>true</strong> or you have set a high <em>MaxSyncDelay</em> in the 
 * configuration file, some time may elapse before a file is indexed.
 * <p />
 * It is preferred that you use the {@link #setKillDuplicates(String)} method rather than setting the kill mode on the 
 * POST content.
 * <p />
 * You must specify <tt>dreDbName</tt> or <tt>databaseFields</tt> if the IDOL server configuration file does not contain
 * a field process that allows it to read documents' destination databases from fields they contain.
 * <p />
 * <strong>Note:</strong> This command requires a POST request method.
 * 
 * @author boba
 */
public class DreAddDataCommand extends AbstractAddCommand {

    /** Creates a new instance of <tt>DreAddDataCommand</tt>. */
    public DreAddDataCommand() {
        super(CMD_DREADDDATA);
    }
    
} // End of class DreAddDataCommand...
