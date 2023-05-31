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

import org.apache.commons.lang3.BooleanUtils;

/**
 * <strong>Note:</strong> This command requires a POST request method.
 * <p />
 * Use the <strong>DREREPLACE</strong> command to change the field values or delete fields from documents.
 *
 * @author boba
 */
public class DreReplaceCommand extends IndexCommandImpl {

    /** Creates a new instance of <tt>DreReplaceCommand</tt>. */
    public DreReplaceCommand() {
        super(CMD_DREREPLACE);
    }

    public String getDatabaseMatch() {
        return get(PARAM_DATABASE_MATCH);
    }

    /**
     * Enter the databases in which you want to replace the specified data. If you want to specify multiple databases,
     * you must separate them with plus symbols (there must be no space before or after a plus symbol).
     *
     * @param databaseMatch The databases in which data is to be replaced.
     */
    public void setDatabaseMatch(final String databaseMatch) {
        put(PARAM_DATABASE_MATCH, databaseMatch);
    }

    public boolean isInsertValue() {
        return BooleanUtils.toBoolean(get(PARAM_INSERT_VALUE));
    }

    /**
     * If you specify <strong>true</strong>, the specified field and value are simply added to the specified document.
     * If there are existing instances of the field, the data is added as a new instance. If you specify <strong>false
     * </strong>, all fields whose name matches the specified field are removed from the document before the specified
     * field and value are written into it. The specified data replaces any pre-existing data for that field.
     *
     * @param insertValue Whether to add new instances of a specified field, or just replace values in existing
     *         instances.
     */
    public void setInsertValue(final boolean insertValue) {
        put(PARAM_INSERT_VALUE, BooleanUtils.toStringTrueFalse(insertValue));
    }

    public String getField() {
        return get(PARAM_FIELD);
    }

    /**
     * The field containing the reference specified by #DREDOCREF when a document has more than one reference.
     * <p />
     * You can specify multiple fields by separating them with commas or spaces (there must be no space before or after 
     * a comma).
     * 
     * @param field The field containing the reference specified by #DREDOCREF.  	
     */
    public void setField(final String field) {
        put(PARAM_FIELD, field);
    }

    public boolean isMultipleValues() {
        return BooleanUtils.toBoolean(get(PARAM_MULTIPLE_VALUES));
    }

    /**
     * Specify <strong>true</strong> to allow the data to contain multiple #DREFIELDNAME/#DREFIELDVALUE pairs in which
     * #DREFIELDNAME has the same value. This allows you to create multiple instances of the same field with different
     * values. Specify <strong>false</strong> to require that the data contain only one #DREFIELDNAME/#DREFIELDVALUE
     * pair for each field name.
     *
     * @param multipleValues Whether to allow multiple #DREFIELDNAME/#DREFIELDVALUE pairs for the same field name.
     */
    public void setMultipleValues(final boolean multipleValues) {
        put(PARAM_MULTIPLE_VALUES, BooleanUtils.toStringTrueFalse(multipleValues));
    }

    public boolean isReplaceAllRefs() {
        return BooleanUtils.toBoolean(get(PARAM_REPLACE_ALL_REFS));
    }

    /**
     * If you specify <strong>true</strong>, and if you use #DREDOCREF in the replacement data to identify documents,
     * the <strong>DREREPLACE</strong> command will affect all documents with a reference field whose value matches the
     * value supplied in #DREDOCREF.
     * <p />
     * If you specify <strong>false</strong>, the command will affect only the <em>first</em> matching document.
     *
     * @param replaceAllRefs Whether to replace values in all matching documents, or just the first one.
     */
    public void setReplaceAllRefs(final boolean replaceAllRefs) {
        put(PARAM_REPLACE_ALL_REFS, BooleanUtils.toStringTrueFalse(replaceAllRefs));
    }

}  // End of class DreReplaceCommand...
