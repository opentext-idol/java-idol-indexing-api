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
package com.autonomy.nonaci.indexing;

import com.autonomy.nonaci.ServerDetails;

/**
 * Defines methods required to execute an index command.
 *
 * @author boba
 */
public interface IndexingService {

    /**
     * Executes an index command
     *
     * @param command The index command to execute
     * @return the index queue id for the command
     * @throws com.autonomy.nonaci.indexing.IndexingException if an error response was detected, or if something went 
     *         wrong while executing the command
     */
    int executeCommand(IndexCommand command) throws IndexingException;

    //----------------------------------------------------------------------------------------------------------------\\

    /**
     * Executes an index command
     *
     * @param serverDetails The connection details of the indexing server.
     * @param command The index command to execute
     * @return the index queue id for the command
     * @throws com.autonomy.nonaci.indexing.IndexingException if an error response was detected, or if something went
     *         wrong while executing the command
     */
    int executeCommand(ServerDetails serverDetails, IndexCommand command) throws IndexingException;

}
