/*
 * $Id$
 *
 * Copyright (c) 2008, Autonomy Systems Ltd.
 *
 * IndexingService.java
 * Created on 19-Jun-2008
 * Last modified by $Author$ on $Date$
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
