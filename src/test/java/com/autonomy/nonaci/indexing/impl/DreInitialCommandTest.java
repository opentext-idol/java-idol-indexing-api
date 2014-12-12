/*
 * $Id$
 *
 * Copyright (c) 2010, Autonomy Systems Ltd.
 *
 * DreInitialCommandTest.java
 * Created on 17-Sep-2010
 * Last modified by $Author$ on $Date$
 */
package com.autonomy.nonaci.indexing.impl;

import java.util.HashMap;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import com.autonomy.nonaci.indexing.IndexCommand;

/**
 * .
 *
 * @author boba
 * @version $Revision$ $Date$
 */
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
