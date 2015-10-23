/*
 * Copyright 2008-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */
package com.autonomy.nonaci.indexing.impl;

/**
 * The index command <tt>DREDUPLICATE</tt> runs on a specified subset of the engine, finding duplicates according to a 
 * variety of methods and performing a specified action on such duplicates. 
 *
 * @author boba
 * @version $Revision$ $Date$
 */
public class DreDuplicateCommand extends IndexCommandImpl {

    /** Creates a new instance of <tt>DreDeleteRefCommand</tt> */
    public DreDuplicateCommand() {
        super(CMD_DREDUPLICATE);
    }

    /**
     * @param field a reference field used to determine whether a match is <em>exact</em> or not
     */
    public void setCheckSumField(final String field) {
        put(PARAM_CHECK_SUM_FIELD, field);
    }

    public String getCheckSumField() {
        return get(PARAM_CHECK_SUM_FIELD);
    }

    /**
     * @param database (duplicateaction=database) the database to move duplicates to
     */
    public void setDatabase(final String database) {
        put(PARAM_DATABASE, database);
    }

    public String getDatabase() {
        return get(PARAM_DATABASE);
    }

    /**
     * @param databases (plus-separated) list of databases that we wish to find duplicates within
     */
    public void setDatabaseMatch(final String databases) {
        put(PARAM_DATABASE_MATCH, databases);
    }

    public String getDatabaseMatch() {
        return get(PARAM_DATABASE_MATCH);
    }

    /**
     * @param action the action to perform on a duplicate (delete/database/tag) (required)
     */
    public void setDuplicateAction(final String action) {
        put(PARAM_DUPLICATE_ACTION, action);
    }

    public String getDuplicateAction() {
        return get(PARAM_DUPLICATE_ACTION);
    }
    
    /**
     * 
     * @param maxId the last docid that we wish to find duplicates of
     */
    public void setMaxId(final String maxId) {
        put(PARAM_MAX_ID, maxId);
    }

    public String getMaxId() {
        return get(PARAM_MAX_ID);
    }

    /**
     * @param minId the first docid that we wish to find duplicates of
     */
    public void setMinId(final String minId) {
        put(PARAM_MIN_ID, minId);
    }    
    
    public String getMinId() {
        return get(PARAM_MIN_ID);
    }

    public String getReferenceField() {
        return get(PARAM_REFERENCE_FIELD);
    }

    /**
     * @param referenceField a reference field used as the initial determination that two documents are a match (required)
     */
    public void setReferenceField(final String referenceField) {
        put(PARAM_REFERENCE_FIELD, referenceField);
    }

    public String getTagField() {
        return get(PARAM_TAG_FIELD);
    }

    /**
     * @param tagField (duplicateaction=tag) the field to tag duplicates with
     */
    public void setTagField(final String tagField) {
        put(PARAM_TAG_FIELD, tagField);
    }

    public String getTagValue() {
        return get(PARAM_TAG_VALUE);
    }

    /**
     * @param tagValue (duplicateaction=tag) the static value to tag duplicates with in tagfield (uses '1' if not given)
     */
    public void setTagValue(final String tagValue) {
        put(PARAM_TAG_VALUE, tagValue);
    }

    public String getThreadHashField() {
        return get(PARAM_THREAD_HASH_FIELD);
    }

    /**
     * @param threadHashField the field containing the "thread hash" values used in determining whether a match is a "duplicate"
     */
    public void setThreadHashField(final String threadHashField) {
        put(PARAM_THREAD_HASH_FIELD, threadHashField);
    }
    
}
