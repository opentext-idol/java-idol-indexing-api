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
 * Prepares IDOL server for a snapshot (hot backup). IDOL server flushes all files to disk and pauses indexing, so a
 * snapshot of the data can be taken. This command is most applicable if your IDOL storage is a SAN with disk-snapshot
 * capabilities.
 * <p />
 * Note the index ID returned from this command (for example, <strong>INDEXID=41</strong>) because  you will need this
 * ID to restart the paused indexing queue.
 * <p />
 * After issuing the command, poll IDOL server with the <strong>IndexerGetStatus</strong> command until the returned
 * status is <strong>-16</strong> (Indexing Paused). You can then perform the snapshot.
 * <p />
 * After the hot backup completes, restart the indexing queue, again with the <strong>IndexerGetStatus</strong> command
 * and with the index ID returned from <strong>DREFLUSHANDPAUSE</strong>. For example:
 * <p />
 * <strong>http://Hume:20000/action=IndexerGetStatus&index=41&IndexAction=restart</strong>
 *
 * @author boba
 */
public class DreFlushAndPauseCommand extends IndexCommandImpl {

    /** Creates a new instance of <tt>DreFlushAndPauseCommand</tt>. */
    public DreFlushAndPauseCommand() {
        super(CMD_DREFLUSHANDPAUSE);
    }

}  // End of class DreFlushAndPauseCommand...
