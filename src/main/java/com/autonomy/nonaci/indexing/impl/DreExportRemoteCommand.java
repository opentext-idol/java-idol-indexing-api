/*
 * Copyright 2008-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */
package com.autonomy.nonaci.indexing.impl;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * Allows you to export IDX or XML documents from one or more IDOL databases on a source IDOL server (local or remote 
 * machine) and add them to a database on a target IDOL server (local or remote machine).
 * <p />
 * <strong>Note:</strong> Multisection documents are not split across chunks, so the <strong>BatchSize</strong> 
 * specified in the configuration parameter is not used exactly if it would require a document section to be split.

 *
 * @author boba
 * @version $Revision$ $Date$
 */
public class DreExportRemoteCommand extends IndexCommandImpl {

    /** Creates a new instance of DreExportRemoteCommand */
    public DreExportRemoteCommand() {
        super(CMD_DREEXPORTREMOTE);
    }
    
    public int getBatchSize() {
        return NumberUtils.toInt(get(PARAM_BATCH_SIZE));
    }

    /**
     * The number of document sections that you want to export to one IDX file.
     * 
     * @param batchSize The number of document sections to be exported to one IDX file.
     */
    public void setBatchSize(final int batchSize) {
        put(PARAM_BATCH_SIZE, String.valueOf(batchSize));
    }

    public String getDatabaseMatch() {
        return get(PARAM_DATABASE_MATCH);
    }

    /**
     * If you don’t want to export documents from all IDOL server databases, enter one or more databases to which you 
     * want to restrict the export. If you want to specify multiple databases, you must separate them with plus symbols,
     * commas or spaces (there must be no space before or after plus symbols or commas).
     * 
     * @param databaseMatch The databases to export documents from.  	 
     */
    public void setDatabaseMatch(final String databaseMatch) {
        put(PARAM_DATABASE_MATCH, databaseMatch);
    }

    public boolean getDelete() {
        return BooleanUtils.toBoolean(get(PARAM_DELETE));
    }

    /**
     * Enter <strong>true</strong> if you want to delete the documents from IDOL server after exporting them. (Documents
     * are deleted only if the export is successful.) Enter <strong>false</strong> if you don’t want to delete the 
     * documents.
     * 
     * @param delete Specifies whether the exported documents are to be deleted.
     */
    public void setDelete(final boolean delete) {
        put(PARAM_DELETE, BooleanUtils.toStringTrueFalse(delete));
    }

    public String getMaxDate() {
        return get(PARAM_MAX_DATE);
    }

    /**
     * The latest creation date or time that a document can have in order to be exported.
     * <p />
     * <strong>To specify a date use:</strong>
     * <ul>
     *   <li>DD/MM/YYYY or DD/MM/YY<br />Note that you can specify the date using three numbers that are separated by 
     *       slashes. The first of these numbers determines the day, the second the time and the third the year. If the 
     *       year is a number less than 40, it is read as a year in the 2000s. If the year is a number between 40 and 
     *       99, it is read as a year in the 1900s. For example, <strong>1/02/1</strong> is read as February 1st 2001, 
     *       while <strong>01/3/40</strong> is read as March 1st 1940.</li>
     *   <li>a positive or negative number in order to specify a number of days from today (for example, <strong>3
     *       </strong> or <strong>-3</strong> to specify today's date plus <strong>3</strong> days or today's date minus
     *       <strong>3</strong> days).</li>
     * </ul>
     * <strong>To specify a time use:</strong>
     * <ul>
     *   <li>a positive or negative number postfixed with an <strong>s</strong> in order to specify a number of seconds 
     *       from now (for example, <strong>100s</strong> or <strong>-100s</strong> to specify the current time plus 
     *       <strong>100</strong> seconds or the current time minus <strong>100</strong> seconds).</li>
     *   <li>a positive number postfixed with an <strong>e</strong> in order to specify epoch seconds (for example, 
     *       <strong>1023782400e</strong> to specify 11th June 2002, 9 am).</li>
     * </ul>
     * 
     * @param maxDate The latest creation date of documents to be exported.
     */
    public void setMaxDate(final String maxDate) {
        put(PARAM_MAX_DATE, maxDate);
    }

    public String getMatchId() {
        return get(PARAM_MATCH_ID);
    }

    /**
     * If you don't want to export all IDX documents, enter the IDs of the documents that you want to export. If you 
     * specify multiple IDs, you must separate them with spaces or plus symbols (there must be no space before or after
     * a plus symbol).
     * <p />
     * You can also specify a range of IDs, using a hyphen (for example, <strong>1000-1100</strong>).
     * 
     * @param matchId The IDs of documents to be exported.
     */
    public void setMatchId(final String matchId) {
        put(PARAM_MATCH_ID, matchId);
    }

    public String getMatchReference() {
        return get(PARAM_MATCH_REFERENCE);
    }

    /**
     * If you don't want to export all IDX documents, enter the references of the documents that you want to export. If
     * you specify multiple references, you must separate them with spaces or plus symbols (there must be no space 
     * before or after a plus symbol).
     * 
     * @param matchReference The references of documents to be exported.
     */
    public void setMatchReference(final String matchReference) {
        put(PARAM_MATCH_REFERENCE, matchReference);
    }

    public String getMinDate() {
        return get(PARAM_MIN_DATE);
    }

    /**
     * The earliest creation date or time that a document can have in order to be exported.
     * <p />
     * <strong>To specify a date use:</strong>
     * <ul>
     *   <li>DD/MM/YYYY or DD/MM/YY<br />Note that you can specify the date using three numbers that are separated by 
     *       slashes. The first of these numbers determines the day, the second the time and the third the year. If the 
     *       year is a number less than 40, it is read as a year in the 2000s. If the year is a number between 40 and 
     *       99, it is read as a year in the 1900s. For example, <strong>1/02/1</strong> is read as February 1st 2001, 
     *       while <strong>01/3/40</strong> is read as March 1st 1940.</li>
     *   <li>a positive or negative number in order to specify a number of days from today (for example, <strong>3
     *       </strong> or <strong>-3</strong> to specify today's date plus <strong>3</strong> days or today's date minus
     *       <strong>3</strong> days).</li>
     * </ul>
     * <strong>To specify a time use:</strong>
     * <ul>
     *   <li>a positive or negative number postfixed with an <strong>s</strong> in order to specify a number of seconds 
     *       from now (for example, <strong>100s</strong> or <strong>-100s</strong> to specify the current time plus 
     *       <strong>100</strong> seconds or the current time minus <strong>100</strong> seconds).</li>
     *   <li>a positive number postfixed with an <strong>e</strong> in order to specify epoch seconds (for example, 
     *       <strong>1023782400e</strong> to specify 11th June 2002, 9 am).</li>
     * </ul>
     * 
     * @param minDate The earliest creation date of documents to be exported.
     */
    public void setMinDate(final String minDate) {
        put(PARAM_MIN_DATE, minDate);
    }

    public String getStateMatchId() {
        return get(PARAM_STATE_MATCH_ID);
    }

    /**
     * Allows you to restrict the documents to be exported to those listed in the specified state token (created earlier
     * with the <strong>StoreState</strong> parameter of the <strong>Query</strong>, <strong>Suggest</strong>, or 
     * <strong>SuggestOnText</strong> actions).
     * <p />
		 * If you specify the token name only, all documents listed in the token can be exported. If you add a (zero-based)
     * index range -- or individual numbers separated by plus signs -- in square brackets after the token name, only 
     * that range or set of documents can be exported. (Note that you must list the entries in increasing numerical 
     * order.)
     * 
     * @param stateMatchId Export only documents listed in the specified state token.
     */
    public void setStateMatchId(final String stateMatchId) {
        put(PARAM_STATE_MATCH_ID, stateMatchId);
    }

    public boolean isBlocking() {
        return BooleanUtils.toBoolean(get(PARAM_BLOCKING));
    }

    /**
     * Specify <strong>true</strong> if you want each DREADD command on the target IDOL server to complete before 
     * another indexing command starts. Specify <strong>false</strong> if you don’t want <strong>DREEXPORTREMOTE
     * </strong>to wait for each indexing command to complete before executing the next.
     * 
     * @param blocking Specifies whether each indexing command on target IDOL server should finish before next one 
     *         starts.
     */
    public void setBlocking(final boolean blocking) {
        put(PARAM_BLOCKING, BooleanUtils.toStringTrueFalse(blocking));
    }

    public String getDreDbName() {
        return get(PARAM_DRE_DBNAME);
    }

    /**
     * Enter the name of an existing database on the target IDOL server. All exported documents from all databases on 
     * the source IDOL server will be added to the specified database on the target IDOL server.
     * <p />
     * Use this parameter if you want documents exported to the target IDOL server to be added to a different database 
     * than the one they belonged to on the source IDOL server.
     * 
     * @param dreDbName Explicitly specifies the database name for documents to be added to the target IDOL server.
     */
    public void setDreDbName(final String dreDbName) {
        put(PARAM_DRE_DBNAME, dreDbName);
    }

    public String getKillDuplicates() {
        return get(PARAM_KILL_DUPLICATES);
    }

    /**
     * This parameter is identical to the <strong>KillDuplicates</strong> parameter of the <strong>DREADD</strong> 
     * indexing command.
     * <p />
     * You can enter one of the following options to specify how IDOL server handles duplicate text when it adds 
     * documents to the target IDOL server. Note that if you postfix any of these options with <strong>=2</strong>, the 
     * KillDuplicates process is applied to all IDOL server databases (rather than just the database into which the 
     * current IDX or XML file is being indexed):
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
     *       server, IDOL server deletes the existing document and replaces it with the new document.</dd>
     * <dl>
     * To specify multiple Reference fields, separate the fields with a plus sign, a space, or an underscore. IDOL 
     * server deletes documents containing any of the specified fields with identical content. To apply the 
     * KillDuplicates process to multiple fields containing underscores, add <strong>&v4</strong> to the command. This 
     * restricts the separators to a plus sign, a space, and a comma only.
     * <p />
     * <strong>Note:</strong> fields are identified as Reference fields through field processes in the IDOL server 
     * configuration file (see <strong>Reference fields</strong> in the IDOL server manual). If you use a <strong><i>
     * FieldName</i></strong> Reference field to eliminate duplicate documents, IDOL server automatically reads any 
     * fields that are listed alongside this field for the <strong>PropertyFieldCSVs</strong> parameter in the field 
     * process, and also uses these fields to eliminate duplicate documents. If you want to define multiple reference 
     * fields but don’t want them all to be used for document elimination, you need to set up multiple field processes 
     * (see <strong>Using Reference fields to eliminate duplicate copies of documents during indexing</strong> in the 
     * IDOL server manual).
     * <p />
     * If you do not set <strong>KillDuplicates</strong>, it defaults to the option specified for <strong>KillDuplicates
     * </strong> in the IDOL server configuration file’s <strong>[Server]</strong> section.
     * 
     * @param killDuplicates How to handle duplicates when adding documents to the target IDOL server.
     */
    public void setKillDuplicates(final String killDuplicates) {
        put(PARAM_KILL_DUPLICATES, killDuplicates);
    }

    public String getTargetEngineHost() {
        return get(PARAM_TARGET_ENGINE_HOST);
    }

    /**
     * Enter the host name or the IP address of the machine containing the IDOL server to which the documents are to be
     * exported.
     * 
     * @param targetEngineHost The host name or IP address of the IDOL server to which the documents are to be exported.
     */
    public void setTargetEngineHost(final String targetEngineHost) {
        put(PARAM_TARGET_ENGINE_HOST, targetEngineHost);
    }

    /**
     * @return A value of -1 indicates the <tt>targetEnginePort</tt> parameter hasn't been set.
     */
    public int getTargetEnginePort() {
        return NumberUtils.toInt(get(PARAM_TARGET_ENGINE_PORT), -1);
    }

    /**
     * Enter the ACI (action) port number of the IDOL server to which the documents are to be exported.
     * 
     * @param targetEnginePort The ACI port number of the IDOL server to which the documents are to be exported. 
     */
    public void setTargetEnginePort(final int targetEnginePort) {
        put(PARAM_TARGET_ENGINE_PORT, String.valueOf(targetEnginePort));
    }

} // End of class DreExportRemoteCommand...
