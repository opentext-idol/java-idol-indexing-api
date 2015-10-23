/*
 * $Id$
 *
 * Copyright (c) 2008 - 2009, Autonomy Systems Ltd.
 *
 * DreValidateCommand.java
 * Created on 14-Aug-2008
 * Last modified by $Author$ on $Date$
 */
package com.autonomy.nonaci.indexing.impl;

/**
 * .
 *
 * @author boba
 * @version $Revision$ $Date$
 */
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
