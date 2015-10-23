/*
 * Copyright 2008-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */
package com.autonomy.nonaci.indexing.impl;

/**
 * Allows you to index documents that use <strong>ReferenceMemoryMappedType</strong> fields out of order. For example,
 * a child in the hierarchy may be indexed before its parent. 
 *
 * @author boba
 * @version $Revision$ $Date$
 */
public class DreRegenerateCommand extends IndexCommandImpl {

    public enum Type {
        REFERENCE_MEMORY_MAPPED("ReferenceMemoryMapped");

        private final String actual;

        Type(final String actual) {
            this.actual = actual;
        }

        @Override
        public String toString() {
            return actual;
        }
    }

    /** Creates a new instance of <tt>DreRegenerateCommand</tt>. */
    public DreRegenerateCommand() {
        super(CMD_DREREGENERATE);
    }

    public Type getType() {
        return Type.valueOf(get(PARAM_TYPE));
    }

    /**
     * The type of field that is to be fixed.
     *
     * @param type The type of field that is to be fixed
     */
    public void setType(final Type type) {
        put(PARAM_TYPE, type.toString());
    }

}  // End of class DreRegenerateCommand...
