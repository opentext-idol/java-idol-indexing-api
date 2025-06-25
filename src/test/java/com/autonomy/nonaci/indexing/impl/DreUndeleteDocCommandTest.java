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

public class DreUndeleteDocCommandTest {
    private static final Map<String, String> nullDocs = new HashMap<>() {{
        put("Docs", null);
    }};
    private final DreUndeleteDocCommand command = new DreUndeleteDocCommand();

    @Test
    public void testEmpty() {
        assertThat(command.getParameters(), equalTo(Map.of()));
        assertThat(command.getQueryString(), equalTo(""));
    }

    @Test
    public void testSetDocsCollection() {
        command.setDocs(List.of(1L, 23L, 456L));
        assertThat(command.getParameters(), equalTo(nullDocs));
        assertThat(command.getQueryString(), equalTo("Docs=1+23+456"));
    }

    @Test
    public void testSetDocsString() {
        command.setDocs("1 23 range[45,67]");
        assertThat(command.getParameters(), equalTo(Map.of("Docs", "1 23 range[45,67]")));
        assertThat(command.getQueryString(), equalTo("Docs=1+23+range%5B45%2C67%5D"));
    }

}
