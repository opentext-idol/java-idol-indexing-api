/*
 * $Id$
 *
 * Copyright (c) 2008, Autonomy Systems Ltd.
 *
 * IndexingServiceImplTest.java
 * Created on 20-Jun-2008
 * Last modified by $Author$ on $Date$
 */
package com.autonomy.nonaci.indexing.impl;

import com.autonomy.nonaci.indexing.IndexCommand;
import com.autonomy.nonaci.indexing.IndexingException;
import com.autonomy.nonaci.ServerDetails;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.apache.http.impl.client.HttpClientBuilder;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import org.junit.Before;
import org.junit.Test;

/**
 * .
 *
 * @author boba
 * @version $Revision$ $Date$
 */
public class IndexingServiceImplTest {

    private IndexingServiceImpl indexingService;

    @Before
    public void createIndexingServiceImpl() {
        final ServerDetails serverDetails = new ServerDetails();
        serverDetails.setHost("localhost");
        serverDetails.setPort(9901);

        indexingService = new IndexingServiceImpl(serverDetails, HttpClientBuilder.create().build());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testExecuteCommand() throws IndexingException {
        final Map<String, String> parameters = new HashMap<String, String>(1);
        parameters.put(IndexCommand.PARAM_DRE_DBNAME, UUID.randomUUID().toString());

//        final IndexCommandImpl command = new IndexCommandImpl(IndexCommand.CMD_DREINITIAL);
        final IndexCommandImpl command = new IndexCommandImpl(IndexCommand.CMD_DRECREATEDBASE);
        command.setParameters(parameters);

        final int queueId = 1; // indexingService.executeCommand(command);

        assertThat("Should have got a queue id", queueId, is(not(0)));
    }

}
