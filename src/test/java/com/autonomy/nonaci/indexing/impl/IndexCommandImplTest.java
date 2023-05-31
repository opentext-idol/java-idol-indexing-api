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
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.sameInstance;

public class IndexCommandImplTest {

    private IndexCommandImpl command; 

    @Before
    public void createIndexCommand() {
        // The actual command doesn't really matter...
        command = new IndexCommandImpl(IndexCommand.CMD_DREDELETEDOC);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testNewCommand() {
        // The command should be the same as that set in the method above...
        assertThat("command", command.getCommand(), is(equalTo(IndexCommand.CMD_DREDELETEDOC)));

        // Check the query string, it should be blank, as there should be no parameters...
        assertThat("parameters", command.getParameters().isEmpty(), is(true));
        assertThat("queryString", command.getQueryString(), is(equalTo("")));

        // Get the PostData, it should be null...
        assertThat("postData", command.getPostData(), is(nullValue()));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testSetPriority() {
        // Set the priority...
        command.setPriority(10);

        // Check the query string and parameters...
        assertThat("parameters", command.getParameters().size(), is(1));
        assertThat("queryString", command.getQueryString(), is(equalTo(IndexCommand.PARAM_PRIORITY + "=10")));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testSetPostData() throws IOException {
        // Test PostData interface...
        final PostDataImpl postData = new PostDataImpl("This is a test...");
        command.setPostData(postData);
        assertThat("postData", (PostDataImpl) command.getPostData(), is(sameInstance(postData)));
        assertThat("postData", IOUtils.toString(command.getPostData().getContent()), is(equalTo("This is a test...")));

        // Test string method...
        command.setPostData("This is a test...");
        assertThat("postData", IOUtils.toString(command.getPostData().getContent()), is(equalTo("This is a test...")));

        // Test file method...
//        command.setPostData(new File());
//        assertThat("postData", IOUtils.toString(command.getPostData().getContent()), (Matcher<String>) is(equalTo("This is a test...")));

        // Test input stream method...
        command.setPostData(new ByteArrayInputStream("This is a test...".getBytes("UTF-8")));
        assertThat("postData", IOUtils.toString(command.getPostData().getContent()), is(equalTo("This is a test...")));
    }

    @Test
    public void testParametersProperty() {
        assertThat(command.getParameters(), is(notNullValue()));
        assertThat(command.getParameters().size(), is(0));

        final Map<String, String> parameters = new HashMap<>();
        parameters.put("wibble", "wobble");
        command.setParameters(parameters);

        assertThat(command.getParameters(), is(not(sameInstance(parameters))));
        assertThat(command.getParameters().size(), is(1));

        command.setParameters(null);
        assertThat(command.getParameters(), is(notNullValue()));
        assertThat(command.getParameters().size(), is(0));
    }

}
