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

import com.autonomy.nonaci.ServerDetails;
import com.autonomy.nonaci.indexing.IndexCommand;
import com.autonomy.nonaci.indexing.IndexingException;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

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
        final Map<String, String> parameters = new HashMap<>(1);
        parameters.put(IndexCommand.PARAM_DRE_DBNAME, UUID.randomUUID().toString());

//        final IndexCommandImpl command = new IndexCommandImpl(IndexCommand.CMD_DREINITIAL);
        final IndexCommandImpl command = new IndexCommandImpl(IndexCommand.CMD_DRECREATEDBASE);
        command.setParameters(parameters);

        final int queueId = 1; // indexingService.executeCommand(command);

        assertThat("Should have got a queue id", queueId, is(not(0)));
    }

}
