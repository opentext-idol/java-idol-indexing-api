/*
 * (c) Copyright 2008-2015 Micro Focus or one of its affiliates.
 *
 * Licensed under the MIT License (the "License"); you may not use this file
 * except in compliance with the License.
 *
 * The only warranties for products and services of Micro Focus and its affiliates
 * and licensors ("Micro Focus") are as may be set forth in the express warranty
 * statements accompanying such products and services. Nothing herein should be
 * construed as constituting an additional warranty. Micro Focus shall not be
 * liable for technical or editorial errors or omissions contained herein. The
 * information contained herein is subject to change without notice.
 */
package com.autonomy.nonaci.indexing.impl;

public class DreValidateCommand extends IndexCommandImpl {

    public enum Type {
        DISK_INDEX("DiskIndex"), NODE_TABLE("NodeTable");

        private final String actual;

        Type(final String actual) {
            this.actual = actual;
        }

        @Override
        public String toString() {
            return actual;
        }
    }

    /** Creates a new instance of <tt>DreValidateCommand</tt>. */
    public DreValidateCommand() {
        super(CMD_DREVALIDATE);
    }

    public Type getType() {
        return Type.valueOf(get(PARAM_TYPE));
    }

    public void setType(final Type type) {
        put(PARAM_TYPE, type.toString());
    }

}  // End of class DreValidateCommand...
