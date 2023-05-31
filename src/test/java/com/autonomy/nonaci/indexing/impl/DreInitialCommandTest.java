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

        command.setParameters(new HashMap<>());
        assertThat(command.getQueryString(), is(equalTo("test")));
    }

}
