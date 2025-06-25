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

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class DreDeleteRefCommandTest {
    private static final Map<String, String> nullDocs = new HashMap<>() {{
        put("Docs", null);
    }};
    private final DreDeleteRefCommand command = new DreDeleteRefCommand();

    @Test
    public void testEmpty() {
        assertThat(command.getParameters(), equalTo(Map.of()));
        assertThat(command.getQueryString(), equalTo(""));
    }

    @Test
    public void testBasicSetters() {
        command.setDreDbName("test db");
        command.setField("the-field");
        assertThat(command.getParameters(), equalTo(Map.of(
                "DREDbName", "test db",
                "Field", "the-field"
        )));
        assertThat(command.getQueryString(), equalTo("DREDbName=test+db&Field=the-field"));
    }

    @Test
    public void testSetDocsCollection() {
        command.setDocs(List.of("doc 1", "doc+2"));
        assertThat(command.getParameters(), equalTo(nullDocs));
        assertThat(command.getQueryString(), equalTo("Docs=doc%201+doc%2B2"));
    }

    @Test
    public void testSetEncodedDocs() {
        command.setEncodedDocs("doc%201+doc%2B2");
        assertThat(command.getParameters(), equalTo(nullDocs));
        assertThat(command.getQueryString(), equalTo("Docs=doc%201+doc%2B2"));
    }

    @Test
    public void testSetDocsString() {
        command.setDocs("doc1 doc2");
        assertThat(command.getParameters(), equalTo(Map.of("Docs", "doc1 doc2")));
        assertThat(command.getQueryString(), equalTo("Docs=doc1+doc2"));
    }

    // note: this test exemplifies unfixable buggy behaviour
    @Test
    public void testSetDocsString_escaping() {
        command.setDocs("doc 1 doc+2 doc%3");
        assertThat(command.getParameters(), equalTo(Map.of("Docs", "doc 1 doc+2 doc%3")));
        assertThat(command.getQueryString(), equalTo("Docs=doc+1+doc%2B2+doc%253"));
    }

}
