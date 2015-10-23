/*
 * Copyright 2008-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */
package com.autonomy.nonaci.indexing.impl;

import com.autonomy.nonaci.indexing.IndexCommand;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;

/**
 * This test class is just to check that a sub class of IndexCommandImpl works if changes to that class have taken
 * place...
 *
 * @author boba
 */
public class DreReplaceCommandTest {

    private static String queryString;

    private DreReplaceCommand command;

    @BeforeClass
    public static void createQueryString() {
        queryString = IndexCommand.PARAM_DATABASE_MATCH + "=test&"
            + IndexCommand.PARAM_MULTIPLE_VALUES + "=true&"
            + IndexCommand.PARAM_REPLACE_ALL_REFS + "=true";
    }


    @Before
    public void createCommand() {
        // The actual command doesn't really matter...
        command = new DreReplaceCommand();
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testParameterMapMethods() {
        // Parameters should be empty...
        assertThat("parameters", command.getParameters().isEmpty(), is(true));

        // Set some parameters...
        final Map<String, String> parameters = new LinkedHashMap<String, String>();
        parameters.put(IndexCommand.PARAM_DATABASE_MATCH, "test");
        parameters.put(IndexCommand.PARAM_MULTIPLE_VALUES, "true");
        parameters.put(IndexCommand.PARAM_REPLACE_ALL_REFS, "true");
        command.setParameters(parameters);

        // Parameters should no longer be empty and the returned map should be a different instance...
        assertThat("parameters", command.getParameters().size(), is(3));
        assertThat("parameters", command.getParameters(), is(not(sameInstance(parameters))));
        assertThat("queryString", command.getQueryString(), is(equalTo(queryString)));

        // I should be able to modify our copy of the map and the command's copy shouldn't change...
        parameters.put(IndexCommand.PARAM_BLOCKING, "true");
        assertThat("parameters", command.getParameters().size(), is(3));
        assertThat("queryString", command.getQueryString(), is(equalTo(queryString)));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testParameterMethods() {
        // Parameters should be empty...
        assertThat("parameters", command.getParameters().isEmpty(), is(true));

        // Set some parameters...
        command.setDatabaseMatch("test");
        command.setMultipleValues(true);
        command.setReplaceAllRefs(true);

        // Parameters should no longer be empty...
        assertThat("parameters", command.getParameters().size(), is(3));
        assertThat("queryString", command.getQueryString(), is(equalTo(queryString)));
    }

}
