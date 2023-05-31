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
 * Allows you to force an immediate flush to disk from the index cache. Sending this command to the index port instructs
 * the engine to flush to disk and any documents currently held in the index cache are committed to disk.
 * <p />
 * This is only required when <strong>DelayedSync</strong> is set to <strong>TRUE</strong> in your configuration file,
 * and you believe documents have been processed but are not yet available for search. That documents remain in the
 * index cache is evident when the number of document sections is higher than the number of committed slots in the
 * <strong>action=getstatus</strong> output.
 * <p />
 * Note these documents are flushed anyway when the <strong>MaxSyncDelay</strong> period you have configured expires. 
 *
 * @author boba
 */
public class DreSyncCommand extends IndexCommandImpl {

    /** Creates a new instance of <tt>DreSyncCommand</tt>. */
    public DreSyncCommand() {
        super(CMD_DRESYNC);
    }

}  // End of class DreSyncCommand...
