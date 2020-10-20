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

import org.apache.commons.lang3.math.NumberUtils;

/**
 * Allow documents to be <em>tagged</em> into clusters of similar documents. It is recommended that
 * <strong>TagField</strong> is a parametric field (with numeric mapping enabled) or a MatchType field. <strong>
 * TagSourceField</strong> might typically be <tt>DREREFERENCE</tt>. 
 *
 * @author boba
 */
public class DreTagDocClustersCommand extends IndexCommandImpl {

    /** Creates a new instance of <tt>DreTagDocClustersCommand</tt>. */
    public DreTagDocClustersCommand() {
        super(CMD_DRETAGDOCCLUSTERS);
    }

    public String getChecksumDBs() {
        return get(PARAM_CHECK_SUM_DBS);
    }

    /**
     * List of databases that we are allowed to checksum match against. 
     */
    public void setChecksumDBs(final String checksumDBs) {
        put(PARAM_CHECK_SUM_DBS, checksumDBs);
    }

    public String getCheckSumField() {
        return get(PARAM_CHECK_SUM_FIELD);
    }

    /**
     * A reference field to use for determining if a document is an 'exact' match of another.
     */
    public void setCheckSumField(final String checkSumField) {
        put(PARAM_CHECK_SUM_FIELD, checkSumField);
    }

    public String getClusterDBs() {
        return get(PARAM_CLUSTER_DBS);
    }

    /**
     * List of databases that we can cluster against (includes taggeddbname if specified).
     */
    public void setClusterDBs(final String clusterDBs) {
        put(PARAM_CLUSTER_DBS, clusterDBs);
    }

    public String getDatabaseMatch() {
        return get(PARAM_DATABASE_MATCH);
    }

    /**
     * List of databases containing documents you want to tag. 
     */
    public void setDatabaseMatch(final String databaseMatch) {
        put(PARAM_DATABASE_MATCH, databaseMatch);
    }

    public String getMaxId() {
        return get(PARAM_MAX_ID);
    }

    /**
     * Last doc id to tag (<em>optional</em> - default is last committed node).
     */
    public void setMaxId(final String maxId) {
        put(PARAM_MAX_ID, maxId);
    }

    public String getMinId() {
        return get(PARAM_MIN_ID);
    }

    /**
     * First doc id to tag (default is id 1).
     */
    public void setMinId(final String minId) {
        put(PARAM_MIN_ID, minId);
    }

    public float getMinScore() {
        return NumberUtils.toFloat(get(PARAM_MIN_SCORE));
    }

    /**
     * Matching threshold to determine if a document belongs to a cluster.
     */
    public void setMinScore(final float minScore) {
        put(PARAM_MIN_SCORE, String.valueOf(minScore));
    }

    public String getRelevanceField() {
        return get(PARAM_RELEVANCE_FIELD);
    }

    /**
     * Fieldname that will hold the relevance score of the document to its cluster (give the full fieldname.
     */
    public void setRelevanceField(final String relevanceField) {
        put(PARAM_RELEVANCE_FIELD, relevanceField);
    }

    public String getTagField() {
        return get(PARAM_TAG_FIELD);
    }

    /**
     * Fieldname that holds document tags (give the full fieldname e.g. XML/DOCUMENT/CLUSTERTAG).
     */
    public void setTagField(final String tagField) {
        put(PARAM_TAG_FIELD, tagField);
    }

    public String getTagSourceField() {
        return get(PARAM_TAG_SOURCE_FIELD);
    }

    /**
     * Field to use as the source of the tagfield value (give the full fieldname e.g. XML/DOCUMENT/A/REFERENCE. Default
     * behaviour is to use the document id as the tag).
     */
    public void setTagSourceField(final String tagSourceField) {
        put(PARAM_TAG_SOURCE_FIELD, tagSourceField);
    }

    public String getTaggedDBName() {
        return get(PARAM_TAGGED_DB_NAME);
    }

    /**
     * Database to move tagged documents into and get tags from.
     */
    public void setTaggedDBName(final String taggedDBName) {
        put(PARAM_TAGGED_DB_NAME, taggedDBName);
    }
    
}  // End of class DreTagDocClustersCommand...
