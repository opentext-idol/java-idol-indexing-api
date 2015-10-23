/*
 * Copyright 2008-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */
package com.autonomy.nonaci.indexing.impl;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * Abstract base class for {@link DreExportIdxCommand} and {@link DreExportXmlCommand} that contains accessor methods 
 * for all their shared parameters.
 *
 * @author boba
 */
public abstract class AbstractExportCommand extends IndexCommandImpl {

    /** 
     * Creates a new instance of AbstractExportCommand
     * 
     * @param command The command to be executed.
     */
    protected AbstractExportCommand(final String command) {
        super(command);
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

    public boolean isCompress() {
        return BooleanUtils.toBoolean(get(PARAM_COMPRESS));
    }

    /**
     * Enter <tt>true</tt> if you want to compress the exported files. Enter <tt>false</tt> if you don't want to
     * compress the files.
     * 
     * @param compress <tt>true</tt> to compress the exported files.
     */
    public void setCompress(final boolean compress) {
        put(PARAM_COMPRESS, BooleanUtils.toStringTrueFalse(compress));
    }

    public String getDatabaseMatch() {
        return get(PARAM_DATABASE_MATCH);
    }

    /**
     * If you don't want to export documents from all IDOL server databases, enter one or more databases to which you 
     * want to restrict the export. If you want to specify multiple databases, you must separate them with plus symbols,
     * commas or spaces (there must be no space before or after plus symbols or commas).
     * 
     * @param databaseMatch The databases to export documents from.
     */
    public void setDatabaseMatch(final String databaseMatch) {
        put(PARAM_DATABASE_MATCH, databaseMatch);
    }

    public boolean isDelete() {
        return BooleanUtils.toBoolean(get(PARAM_DELETE));
    }

    /**
     * Enter <strong>true</strong> if you want to delete the documents from IDOL server after exporting them. (Documents
     * are deleted only if the export is successful.)
     * <p />
	 * Enter <strong>false</strong> if you don't want to delete the documents.
     *
     * @param delete Specifies whether the exported documents are to be deleted.
     */
    public void setDelete(final boolean delete) {
        put(PARAM_DELETE, BooleanUtils.toStringTrueFalse(delete));
    }

    public String getFileName() {
        return get(PARAM_FILE_NAME);
    }

    /**
     * The path to the directory where the IDX files that are exported will be stored. The path must include a basic 
     * file name which IDOL server will postfix with incremental numbers and an appropriate extension. If you don't 
     * specify a file name the files are exported to the current working directory (<strong>IDOLserver\IDOL\content
     * </strong>), and IDOL server creates a filename in the format:<br /><br /> 
     * <strong>AUTN-IDX-EXPORT-&lt;host&gt;-&lt;port&gt;-&#60;date&#62;-&#60;time&#62;-&#60;incremental number&#62;.&#60;extension&#62;</strong>.
     * <p />
     * Use the <tt>hostDetails</tt> parameter to add host details to the file name.
     *
     * @param fileName The path to the directory where the exported files are to be stored.
     */
    public void setFileName(final String fileName) {
        put(PARAM_FILE_NAME, fileName);
    }

    public boolean isHostDetails() {
        return BooleanUtils.toBoolean(get(PARAM_HOST_DETAILS));
    }

    /**
     * Adds host details to the exported filename. For example, the following action could generate a series of files 
     * named <strong>backup-myservername.domain.com-16502-0.idx.gz</strong>:
     * <p />
     * <strong>DREEXPORTIDX&amp;filename=backup&amp;hostdetails=true</strong>
     * 
     * @param hostDetails Adds host details to the exported filename.
     */
    public void setHostDetails(final boolean hostDetails) {
        put(PARAM_HOST_DETAILS, BooleanUtils.toStringTrueFalse(hostDetails));
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

    public int getMaxId() {
        return NumberUtils.toInt(get(PARAM_MAX_ID));
    }

    /**
     * The maximum document ID number (inclusive) that should be exported. 
     * 
     * @param maxId The maximum document ID number (inclusive) that should be exported.
     */
    public void setMaxId(final int maxId) {
        put(PARAM_MAX_ID, String.valueOf(maxId));
    }

    public int getMatchId() {
        return NumberUtils.toInt(get(PARAM_MATCH_ID));
    }

    /**
     * If you don't want to export all IDX documents, enter the IDs of the documents that you want to export. If you 
     * specify multiple IDs, you must separate them with spaces or plus symbols (there must be no space before or after 
     * a plus symbol).
     * You can also specify a range of IDs, using a hyphen (for example, <strong>1000-1100</strong>). 
     *
     * @param matchId The IDs of documents to be exported.
     */
    public void setMatchId(final int matchId) {
        put(PARAM_MATCH_ID, String.valueOf(matchId));
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

    public int getMinId() {
        return NumberUtils.toInt(get(PARAM_MIN_ID));
    }

    /**
     * The minimum document ID number (inclusive) that should be exported. 
     * 
     * @param minId The minimum document ID number (inclusive) that should be exported.
     */
    public void setMinId(final int minId) {
        put(PARAM_MIN_ID, String.valueOf(minId));
    }

    public int getStateMatchId() {
        return NumberUtils.toInt(get(PARAM_STATE_MATCH_ID));
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
    public void setStateMatchId(final int stateMatchId) {
        put(PARAM_STATE_MATCH_ID, String.valueOf(stateMatchId));
    }
    
}
