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
 * Allows you to delete or archive documents that have reached a specific age. By default, documents are deleted when 
 * they expire. If you want to archive them instead, specify the name of the database you want to use for archiving in 
 * the <strong>ExpireIntoDatabase</strong> parameter in each of the IDOL server configuration file's database sections.
 * <p />
 * The date that determines whether a document should be expired can be read from a field in the document or from the 
 * expiry time that is set for the database that contains the document. If IDOL server is unable to determine whether a 
 * document should be expired (because the document does not contain a field that sets its expiry date and the 
 * document's database has no expiry time set), IDOL server does not expire the document.
 *
 * @author boba
 */
public class DreExpireCommand extends IndexCommandImpl {

    /** Creates a new instance of DreExpireCommand */
    public DreExpireCommand() {
        super(CMD_DREEXPIRE);
    }

} // End of class DreExpireCommand...
