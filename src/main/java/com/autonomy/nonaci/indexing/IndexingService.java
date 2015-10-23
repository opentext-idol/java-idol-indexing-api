/*
 * Copyright 2008-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */
package com.autonomy.nonaci.indexing;

import com.autonomy.nonaci.ServerDetails;

/**
 * Defines methods required to execute an index command.
 *
 * @author boba
 * @version $Revision$ $Date$
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
