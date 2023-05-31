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
 * Abstract base class for {@link DreAddCommand} and {@link DreAddDataCommand} that contains accessor methods for all 
 * their shared parameters.
 *
 * @author boba
 */
public abstract class AbstractAddCommand extends IndexCommandImpl {

    /** Holds the allowed values for setting the document format. */
    public enum DocumentFormat {IDX, XML}
    
    /**
     * Creates a new instance of AbstractAddCommand
     * 
     * @param command The command to be executed.
     */
    public AbstractAddCommand(final String command) {
        super(command);
    }

    public String getAclFields() {
        return get(PARAM_ACL_FIELDS);
    }

    /**
     * Allows you to specify the fields from which you want IDOL server to read ACLs (Access Control Lists).
     * <p />
     * If you want to specify multiple fields you must separate them with commas (there must be no space before or after
     * a comma). You can use wildcards.
     * <p />
     * When identifying fields you should use the format <strong>/FieldName</strong> to match root-level fields, 
     * <strong>&#42;/FieldName</strong> to match all fields except root-level or <strong>/Path/FieldName</strong> to match 
     * fields that the specified path points to. If you just specify the field name, IDOL server automatically adds a 
     * <strong>&#42;/</strong> to it.
     *
     * @param aclFields Fields that contain ACLs (Access Control Lists).
     */
    public void setAclFields(final String aclFields) {
        put(PARAM_ACL_FIELDS, aclFields);
    }

    public String getCantHaveFields() {
        return get(PARAM_CANT_HAVE_FIELDS);
    }

    /**
     * Allows you to specify the fields that are discarded before the documents is indexed. By default, all fields are 
     * stored in IDOL server.
     * <p />
     * If you want to specify multiple fields you must separate them with commas (there must be no space before or after
     * a comma). You can use wildcards.
     * <p />
     * When identifying fields you should use the format <strong>/FieldName</strong> to match root-level fields, 
     * <strong>&#42;/FieldName</strong> to match all fields except root-level or <strong>/Path/FieldName</strong> to match 
     * fields that the specified path points to. If you just specify the field name, IDOL server automatically adds a 
     * <strong>&#42;/</strong> to it.
     *            
     * @param cantHaveFields Fields to be discarded.
     */
    public void setCantHaveFields(final String cantHaveFields) {
        put(PARAM_CANT_HAVE_FIELDS, cantHaveFields);
    }

    public String getDatabaseFields() {
        return get(PARAM_DATABASE_FIELDS);
    }

    /**
     * Allows you to specify the fields that contain the name of the database in which you want the document to be 
     * stored.
     * <p />
     * If you want to specify multiple fields you must separate them with commas (there must be no space before or after
     * a comma). You can use wildcards.
     * <p />
     * When identifying fields you should use the format <strong>/FieldName</strong> to match root-level fields, 
     * <strong>&#42;/FieldName</strong> to match all fields except root-level or <strong>/Path/FieldName</strong> to match 
     * fields that the specified path points to. If you just specify the field name, IDOL server automatically adds a 
     * <strong>&#42;/</strong> to it.
     * <p />
     * If IDOL server's configuration file contains a field process that identifies a field from which IDOL server can 
     * read the file's destination database, the specified <tt>databaseFields</tt> fields override this.
     * <p />
     * If IDOL server's configuration file doesn't contain a field process that identifies the document's destination 
     * database, you must specify either <tt>dreDbName</tt> or <tt>databaseFields</tt>.
     *            
     * @param databaseFields Fields that identify the database in which to store a document.
     */
    public void setDatabaseFields(final String databaseFields) {
        put(PARAM_DATABASE_FIELDS, databaseFields);
    }

    public String getDateFields() {
        return get(PARAM_DATE_FIELDS);
    }

    /**
     * Allows you to specify the fields from which you want IDOL server to read the document's date.
     * <p />
     * If you want to specify multiple fields you must separate them with commas (there must be no space before or after
     * a comma). You can use wildcards.
     * <p />
     * When identifying fields you should use the format <strong>/FieldName</strong> to match root-level fields, 
     * <strong>&#42;/FieldName</strong> to match all fields except root-level or <strong>/Path/FieldName</strong> to match 
     * fields that the specified path points to. If you just specify the field name, IDOL server automatically adds a 
     * <strong>&#42;/</strong> to it.
     *
     * @param dateFields Fields from which to read a document's date.
     */
    public void setDateFields(final String dateFields) {
        put(PARAM_DATE_FIELDS, dateFields);
    }

    public String getDocumentDelimiters() {
        return get(PARAM_DOCUMENT_DELIMITERS);
    }

    /**
     * Allows you to specify fields in an XML file that indicate the beginning and end of a document, so the documents
     * are indexed individually. Ensure document delimiters are not nested.
     * <p />
     * If you want to specify multiple fields you must separate them with commas (there must be no space before or after
     * a comma). You can use wildcards.
     * <p />
     * When identifying fields you should use the format <strong>/FieldName</strong> to match root-level fields, 
     * <strong>&#42;/FieldName</strong> to match all fields except root-level or <strong>/Path/FieldName</strong> to match 
     * fields that the specified path points to. If you just specify the field name, IDOL server automatically adds a 
     * <strong>&#42;/</strong> to it.
     * 
     * @param documentDelimiters Fields that indicate the beginning and end of a document.
     */
    public void setDocumentDelimiters(final String documentDelimiters) {
        put(PARAM_DOCUMENT_DELIMITERS, documentDelimiters);
    }

    public DocumentFormat getDocumentFormat() {
        return DocumentFormat.valueOf(get(PARAM_DOCUMENT_FORMAT));
    }

    /**
     * If a file you are indexing has an ambiguous format that IDOL server cannot easily identify as XML or IDX, 
     * <strong>DocumentFormat</strong> allows you to specify the format of the file. Enter <tt>DocumentFormat.XML</tt> 
     * or <tt>DocumentFormat.IDX</tt>.
     * 
     * @param documentFormat The format of the file to be indexed.
     */
    public void setDocumentFormat(final DocumentFormat documentFormat) {
        put(PARAM_DOCUMENT_FORMAT, documentFormat.toString());
    }

    public String getDreDbName() {
        return get(PARAM_DRE_DBNAME);
    }

    /**
     * The IDOL server database into which you want to index the IDX or XML file.
     * <p />
     * If IDOL server's configuration file contains a field process that identifies a field in the document from which 
     * IDOL server can read the file's destination database, the specified <tt>dreDbName</tt> database overrides
     * this.
     * <p />
     * If IDOL server's configuration file doesn't contain a field process that identifies the document's destination 
     * database, you must specify either <tt>dreDbName</tt> or <tt>databaseFields</tt>.
     * 
     * @param dreDbName The database in which to store a document.
     */
    public void setDreDbName(final String dreDbName) {
        put(PARAM_DRE_DBNAME, dreDbName);
    }

    public String getExpiryDateFields() {
        return get(PARAM_EXPIRE_DATE_FIELDS);
    }

    /**
     * Allows you to specify fields that contain the expiry date of the document (that is, the date when the document is
     * deleted, unless you have set <strong>ExpireIntoDatabase</strong> in IDOL server's configuration file to move the 
     * data into another database).
     * <p />
     * If you want to specify multiple fields you must separate them with commas (there must be no space before or after
     * a comma). You can use wildcards.
     * <p />
     * When identifying fields you should use the format <strong>/FieldName</strong> to match root-level fields, 
     * <strong>&#42;/FieldName</strong> to match all fields except root-level or <strong>/Path/FieldName</strong> to match 
     * fields that the specified path points to. If you just specify the field name, IDOL server automatically adds a 
     * <strong>&#42;/</strong> to it.
     *            
     * @param expiryDateFields Fields that contain a document's expiry date.
     */
    public void setExpiryDateFields(final String expiryDateFields) {
        put(PARAM_EXPIRE_DATE_FIELDS, expiryDateFields);
    }

    public String getFlattenIndexFields() {
        return get(PARAM_FLATTEN_INDEX_FIELDS);
    }

    /**
     * Allows you to specify the fields in a hierarchically structured document whose content you want to index as one 
     * level.
     * <p />
     * If you want to specify multiple fields you must separate them with commas (there must be no space before or after
     * a comma). You can use wildcards.
     * <p />
     * When identifying fields you should use the format <strong>/FieldName</strong> to match root-level fields, 
     * <strong>&#42;/FieldName</strong> to match all fields except root-level or <strong>/Path/FieldName</strong> to match 
     * fields that the specified path points to. If you just specify the field name, IDOL server automatically adds a 
     * <strong>&#42;/</strong> to it.
     * 
     * @param flattenIndexFields Fields in an XML document whose content is to be indexed as one level.
     */
    public void setFlattenIndexFields(final String flattenIndexFields) {
        put(PARAM_FLATTEN_INDEX_FIELDS, flattenIndexFields);
    }

    public String getIdxFieldPrefix() {
        return get(PARAM_IDX_FIELD_PREFIX);
    }

    /**
     * When you index an IDX file it is transformed into XML by placing it under the <strong>Document</strong> subtree 
     * (each of the IDX file's fields is prefixed with <strong>Document</strong>, so that a simple XML hierarchy is 
     * constructed). If you do not want this subtree to be called <strong>Document</strong>, <strong>IDXFieldPrefix
     * </strong> allows you to specify an alternative name.
     * 
     * @param idxFieldPrefix An alternative name for the <strong>Document</strong> subtree.
     */
    public void setIdxFieldPrefix(final String idxFieldPrefix) {
        put(PARAM_IDX_FIELD_PREFIX, idxFieldPrefix);
    }

    public String getIndexFields() {
        return get(PARAM_INDEX_FIELDS);
    }

    /**
     * Allows you to specify the fields you want to store as Index fields in IDOL server. You should only store fields 
     * that contain text which you want to query frequently with conceptual queries as Index fields.
     * <p />
     * Index fields are processed linguistically when they are stored in IDOL server. This means that stemming and 
     * stoplists are applied to text in Index field before they are stored, which allows IDOL server to process queries
     * for these fields more quickly (typically <strong>DRETITLE</strong> and <strong>DRECONTENT</strong> are fields 
     * that should be set up as Index fields).
     * <p />
     * You should not store URLs or content that you are unlikely to use in Index fields. You should also not store 
     * fields as Index fields that will be queried frequently but whose value is only ever going to be queried in its 
     * entirety. Indexing all fields in documents could potentially slow down the indexing process, increase disk usage 
     * and requirements.
     * <p />
     * If you want to specify multiple fields you must separate them with commas (there must be no space before or after
     * a comma). You can use wildcards.
     * <p />
     * When identifying fields you should use the format <strong>/FieldName</strong> to match root-level fields, 
     * <strong>&#42;/FieldName</strong> to match all fields except root-level or <strong>/Path/FieldName</strong> to match 
     * fields that the specified path points to. If you just specify the field name, IDOL server automatically adds a 
     * <strong>&#42;/</strong> to it.
     * 
     * @param indexFields Fields to be stored as Index fields.
     */
    public void setIndexFields(final String indexFields) {
        put(PARAM_INDEX_FIELDS, indexFields);
    }

    public boolean isKeepExisting() {
        return BooleanUtils.toBoolean(get(PARAM_KEEP_EXISTING));
    }

    /**
     * If you have set <strong>KillDuplicates</strong> to <strong>Reference</strong>, <strong>ReferenceMatch<i>N</i>
     * </strong> or <strong><i>FieldName</i></strong>, you can set <strong>KeepExisting</strong> to <strong>true
     * </strong> if you want IDOL server to discard the document it has received for indexing and keep the matching 
     * document that it already contains instead.
     * 
     * @param keepExisting Modifies the <strong>KillDuplicates</strong> operation.
     */
    public void setKeepExisting(final boolean keepExisting) {
        put(PARAM_KEEP_EXISTING, BooleanUtils.toStringTrueFalse(keepExisting));
    }

    public String getKillDuplicates() {
        return get(PARAM_KILL_DUPLICATES);
    }

    /**
     * You can enter one of the following options to determine how IDOL server handles duplicate text. If you postfix 
     * any of these options with <strong>=2</strong>, the KillDuplicates process is applied to all IDOL server databases
     * (rather than just the database into which the current IDX or XML file is being indexed):
     * <p />
     * <dl>
     *   <dt><strong>NONE</strong></dt>
     *   <dd>Documents in IDOL server are never replaced with new documents.</dd>
     *   <dt><strong>REFERENCE</strong></dt>
     *   <dd>If the document being indexed has the same <strong>DREREFERENCE</strong> field value as a document that 
     *       already exists in IDOL server, IDOL server deletes the existing document and replaces it with the new 
     *       document.</dd>
     *   <dt><strong>REFERENCEMATCH<i>N</i></strong></dt>
     *   <dd>If the content of the document being indexed is more than <strong><i>N</i></strong> percent similar to the 
     *       content of a document that already exists in the IDOL server database, IDOL server deletes the existing 
     *       document and replaces it with the new document.</dd>
     *   <dt><strong><i>FieldName</i></strong></dt>
     *   <dd>If the document being indexed contains a <strong><i>FieldName</i></strong> Reference field with the same 
     *       value as the <strong><i>FieldName</i></strong> Reference field in a document that already exists in IDOL 
     *       server, IDOL server deletes the existing document and replaces it with the new document.
     *       <p />
     *       To specify multiple Reference fields, separate the fields with a plus sign, a space, or an underscore. IDOL
     *       server deletes documents containing any of the specified fields with identical content. To apply the 
     *       KillDuplicates process to multiple fields containing underscores, add <strong>&v4</strong> to the command.
     *       This restricts the separators to a plus sign, a space, and a comma only.
     *       <p />
     *       <strong>Note:</strong> Fields are identified as Reference fields through field processes in the IDOL server
     *       configuration file (see <strong>Reference fields</strong> in the IDOL server manual). If you use a <strong>
     *       <i>FieldName</i></strong> Reference field to eliminate duplicate documents, IDOL server automatically reads
     *       any fields that are listed alongside this field for the <strong>PropertyFieldCSVs</strong> parameter in the
     *       field process, and also uses these fields to eliminate duplicate documents. If you want to define multiple
     *       reference fields but don't want them all to be used for document elimination, you need to set up multiple 
     *       field processes (see <strong>Using Reference fields to eliminate duplicate copies of documents during 
     *       indexing</strong> in the IDOL server manual).</dd>
     * </dl>
     * If you do not set <strong>KillDuplicates</strong>, it defaults to the option specified for <strong>KillDuplicates
     * </strong> in the IDOL server configuration file's <strong>[Server]</strong> section.
     * 
     * @param killDuplicates Determines how IDOL server handles duplicate content.
     */
    public void setKillDuplicates(final String killDuplicates) {
        put(PARAM_KILL_DUPLICATES, killDuplicates);
    }

    public String getKillDuplicatesDB() {
        return get(PARAM_KILL_DUPLICATES_DB);
    }

    /**
     * The database to which duplicate documents are moved. 
     * 
     * @param killDuplicatesDB The database to which duplicate documents are moved. 
     */
    public void setKillDuplicatesDB(final String killDuplicatesDB) {
        put(PARAM_KILL_DUPLICATES_DB, killDuplicatesDB);
    }    

    public String getKillDuplicatesDBField() {
        return get(PARAM_KILL_DUPLICATES_DB_FIELDS);
    }

    /**
     * The name of a field in duplicate documents containing the name of the database to which duplicate documents are 
     * moved. If the field does not exist in the document, the value of <strong>KillDuplicatesDB</strong> is used.
     * 
     * @param killDuplicatesDBField The name of a field in duplicate documents containing the name of the database to 
     *         which duplicate documents are moved.  	 
     */
    public void setKillDuplicatesDBField(final String killDuplicatesDBField) {
        put(PARAM_KILL_DUPLICATES_DB_FIELDS, killDuplicatesDBField);
    }    

    public String getKillDuplicatesMatchDBs() {
        return get(PARAM_KILL_DUPLICATES_MATCH_DBS);
    }

    /**
     * Lists the databases that are searched for duplicate matches separated by plus signs (+).
     * 
     * @param killDuplicatesMatchDBs Lists the databases that are searched for duplicate matches.
     */
    public void setKillDuplicatesMatchDBs(final String killDuplicatesMatchDBs) {
        put(PARAM_KILL_DUPLICATES_MATCH_DBS, killDuplicatesMatchDBs);
    }

    public boolean isKillDuplicatesMatchTargetDB() {
        return BooleanUtils.toBoolean(get(PARAM_KILL_DUPLICATES_MATCH_TARGET_DB));
    }

    /**
     * If set to <tt>true</tt>, the database into which the document is to be indexed is searched for duplicate matches.
     * 
     * @param killDuplicatesMatchTargetDB If set to <tt>true</tt>, the database into which the document is to be indexed
     *         is searched for duplicate matches.
     */
    public void setKillDuplicatesMatchTargetDB(final boolean killDuplicatesMatchTargetDB) {
        put(PARAM_KILL_DUPLICATES_MATCH_TARGET_DB, BooleanUtils.toStringTrueFalse(killDuplicatesMatchTargetDB));
    }
    
    public String getLanguageFields() {
        return get(PARAM_LANGUAGE_FIELDS);
    }

    /**
     * Allows you to specify fields that contain the language type of the document.
     * <p />
     * If you want to specify multiple fields you must separate them with commas (there must be no space before or after
     * a comma). You can use wildcards.
     * <p />
     * When identifying fields you should use the format <strong>/FieldName</strong> to match root-level fields, 
     * <strong>&#42;/FieldName</strong> to match all fields except root-level or <strong>/Path/FieldName</strong> to match 
     * fields that the specified path points to. If you just specify the field name, IDOL server automatically adds a 
     * <strong>&#42;/</strong> to it.
     *            
     * @param languageFields Fields that contain a document's language type.
     */
    public void setLanguageFields(final String languageFields) {
        put(PARAM_LANGUAGE_FIELDS, languageFields);
    }

    public String getLanguageType() {
        return get(PARAM_LANGUAGE_TYPE);
    }

    /**
     * Allows you to specify the language type of the IDX or XML file you are indexing. If IDOL server's configuration 
     * file contains a field process that identifies fields from which IDOL server can read documents' language types, 
     * the specified <strong>LanguageType</strong> overrides this.
     * 
     * @param languageType The language type of the file to be indexed.
     */
    public void setLanguageType(final String languageType) {
        put(PARAM_LANGUAGE_TYPE, languageType);
    }

    public String getMustHaveFields() {
        return get(PARAM_MUST_HAVE_FIELDS);
    }

    /**
     * Allows you to specify which fields in an IDX file should be stored in IDOL server. By default, all fields are 
     * stored. Fields that are not listed are discarded, which means they cannot be queried or displayed.
     * <p />
     * If you want to specify multiple fields you must separate them with commas (there must be no space before or after
     * a comma). You can use wildcards.
     * <p />
     * When identifying fields you should use the format <strong>/FieldName</strong> to match root-level fields, 
     * <strong>&#42;/FieldName</strong> to match all fields except root-level or <strong>/Path/FieldName</strong> to match 
     * fields that the specified path points to. If you just specify the field name, IDOL server automatically adds a 
     * <strong>&#42;/</strong> to it.
     * 
     * @param mustHaveFields IDX file fields to be stored in IDOL server.
     */
    public void setMustHaveFields(final String mustHaveFields) {
        put(PARAM_MUST_HAVE_FIELDS, mustHaveFields);
    }

    public String getSectionFields() {
        return get(PARAM_SECTION_FIELDS);
    }

    /**
     * Allows you to specify fields that indicate the start of a new section in the document (if you are indexing XML, 
     * you do not need to specify section fields as IDOL server automatically sections XML data).
     * <p />
     * If you want to specify multiple fields you must separate them with commas (there must be no space before or after
     * a comma). You can use wildcards.
     * <p />
     * When identifying fields you should use the format <strong>/FieldName</strong> to match root-level fields, 
     * <strong>&#42;/FieldName</strong> to match all fields except root-level or <strong>/Path/FieldName</strong> to match 
     * fields that the specified path points to. If you just specify the field name, IDOL server automatically adds a 
     * <strong>&#42;/</strong> to it.
     * 
     * @param sectionFields Fields that indicate the start of a new document section.  	 
     */
    public void setSectionFields(final String sectionFields) {
        put(PARAM_SECTION_FIELDS, sectionFields);
    }

    public String getSecurityFields() {
        return get(PARAM_SECURITY_FIELDS);
    }

    /**
     * Allows you to specify fields that contain the security type of the document.
     * <p />
     * If you want to specify multiple fields you must separate them with commas (there must be no space before or after
     * a comma). You can use wildcards.
     * <p />
     * When identifying fields you should use the format <strong>/FieldName</strong> to match root-level fields, 
     * <strong>&#42;/FieldName</strong> to match all fields except root-level or <strong>/Path/FieldName</strong> to match 
     * fields that the specified path points to. If you just specify the field name, IDOL server automatically adds a 
     * <strong>&#42;/</strong> to it.
     * 
     * @param securityFields Fields that contain a document's security type.
     */
    public void setSecurityFields(final String securityFields) {
        put(PARAM_SECURITY_FIELDS, securityFields);
    }

    public String getSecurityType() {
        return get(PARAM_SECURITY_TYPE);
    }

    /**
     * Allows you to specify the security type of the IDX or XML file you are indexing. If IDOL server's configuration 
     * file contains a field process that identifies fields from which IDOL server can read documents' security types, 
     * the specified <strong>SecurityType</strong> overrides this.
     * 
     * @param securityType The security type of the file to be indexed.
     */
    public void setSecurityType(final String securityType) {
        put(PARAM_SECURITY_TYPE, securityType);
    }

    public String getTitleFields() {
        return get(PARAM_TITLE_FIELDS);
    }

    /**
     * Allows you to specify fields from which you want IDOL server to read a document's title.
     * <p />
     * If you want to specify multiple fields you must separate them with commas (there must be no space before or after
     * a comma). You can use wildcards.
     * <p />
     * When identifying fields you should use the format <strong>/FieldName</strong> to match root-level fields, 
     * <strong>&#42;/FieldName</strong> to match all fields except root-level or <strong>/Path/FieldName</strong> to match 
     * fields that the specified path points to. If you just specify the field name, IDOL server automatically adds a 
     * <strong>&#42;/</strong> to it.
     * 
     * @param titleFields Fields that contain a document's title.
     */
    public void setTitleFields(final String titleFields) {
        put(PARAM_TITLE_FIELDS, titleFields);
    }
    
} // End of class AbstractAddCommand...
