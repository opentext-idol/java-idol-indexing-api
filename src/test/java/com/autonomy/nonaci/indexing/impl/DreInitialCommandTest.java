/*
 * Copyright 2008-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */
package com.autonomy.nonaci.indexing.impl;

import com.autonomy.nonaci.indexing.IndexCommand;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class DreInitialCommandTest {

    @Test
    public void testGetQueryString() {
        final DreInitialCommand command = new DreInitialCommand();
        assertThat(command.getQueryString(), is(equalTo("")));

        command.setPriority(10);
        assertThat(command.getQueryString(), is(equalTo(IndexCommand.PARAM_PRIORITY + "=10")));

        command.setPath("test");
        assertThat(command.getQueryString(), is(equalTo("test&" + IndexCommand.PARAM_PRIORITY + "=10")));

        command.setParameters(new HashMap<String, String>());
        assertThat(command.getQueryString(), is(equalTo("test")));
    }

}
