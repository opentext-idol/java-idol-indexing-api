/*
 * Copyright 2008-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */
package com.autonomy.nonaci.indexing.impl;

/**
 * Allows you to identify individual documents and/or document ranges by their references or IDs (note that ranges can
 * only be identified using IDs), and change the value of their importance rating, database, index date, and expire
 * date.
 *
 * @author boba
 */
public class DreChangeMetaCommand extends IndexCommandImpl {

    /**
     * Enter one of the following to specify which field type you want to set to the specified <strong>NewValue</strong>
     */
    public enum Type {

        /**
         * Sets the AutnRankType field of the specified Docs to the specified NewValue. The value in a document's
         * AutnRankType field represents the document's importance. Note that the value you specify must be between 0
         * and 4000. IDOL server uses the autnrank value of a document when it calculates the relevance the document is
         * given when it is returned as a result. For example, if two documents match a query equally well, the one that
         * has the higher autnrank value is returned with a higher relevance rating.
         */
        AUTNRANK("autnrank"),

        /**
         * Sets the DatabaseType field of the specified Docs to the specified NewValue. A document's DatabaseType field
         * contains the IDOL server database the document is stored in.
         */
        DATABASE("database"),

        /**
         * Sets the DateType field of the specified Docs to the specified NewValue. A document's DateType field contains
         * the date the document was indexed into IDOL server. Note the date you specify must be in a format that you
         * have set for DateFormatCSVs in IDOL server’s configuration file.
         */
        DATE("date"),

        /**
         * Sets the ExpireDateType field of the specified Docs to the specified NewValue. A document's ExpireDateType
         * field contains the date that the document is becomes ready to be processed by an Expire operation. Note the
         * date you specify must be in a format that you have set for DateFormatCSVs in IDOL server’s configuration file.
         */
        EXPIREDATE("expiredate");

        private final String actual;

        Type(final String actual) {
            this.actual = actual;
        }

        @Override
        public String toString() {
            return actual;
        }
        
    }

    /**
     * Creates a new instance of DreChangeMetaCommand
     */
    public DreChangeMetaCommand() {
        super(CMD_DRECHANGEMETA);
    }

    public String getDocs() {
        return get(PARAM_DOCS);
    }

    public void setDocs(final String docs) {
        put(PARAM_DOCS, docs);
    }

    public String getNewValue() {
        return get(PARAM_NEW_VALUE);
    }

    public void setNewValue(final String newValue) {
        put(PARAM_NEW_VALUE, newValue);
    }

    public String getRefs() {
        return get(PARAM_REFS);
    }

    public void setRefs(final String refs) {
        put(PARAM_REFS, refs);
    }

    public String getStateId() {
        return get(PARAM_STATE_ID);
    }

    public void setStateId(final String stateId) {
        put(PARAM_STATE_ID, stateId);
    }

    public Type getType() {
        return Type.valueOf(get(PARAM_TYPE));
    }

    public void setType(final Type type) {
        put(PARAM_TYPE, type.toString());
    }
    
}  // End of class DreChangeMetaCommand...
