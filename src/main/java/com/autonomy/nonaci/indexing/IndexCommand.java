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
package com.autonomy.nonaci.indexing;

/**
 * Defines methods that an index command should provide for the {@link IndexingService} to execute the command. Also
 * includes constants for all the index commands and their parameters.
 *
 * @author boba
 */
public interface IndexCommand {

    //---------- Index command names...
    String CMD_DREADD = "DREADD";
    String CMD_DREADDDATA = "DREADDDATA";
    String CMD_DREBACKUP = "DREBACKUP";
    String CMD_DRECHANGEMETA = "DRECHANGEMETA";
    String CMD_DRECOMPACT = "DRECOMPACT";
    String CMD_DRECREATEDBASE = "DRECREATEDBASE";
    String CMD_DREDELDBASE = "DREDELDBASE";
    String CMD_DREDELETEDOC = "DREDELETEDOC";
    String CMD_DREDELETEREF = "DREDELETEREF";
    String CMD_DREDUPLICATE = "DREDUPLICATE";
    String CMD_DREEXPIRE = "DREEXPIRE";
    String CMD_DREEXPORTIDX = "DREEXPORTIDX";
    String CMD_DREEXPORTXML = "DREEXPORTXML";
    String CMD_DREEXPORTREMOTE = "DREEXPORTREMOTE";
    String CMD_DREFLUSHANDPAUSE = "DREFLUSHANDPAUSE";
    String CMD_DREINITIAL = "DREINITIAL";
    String CMD_DREREGENERATE = "DREREGENERATE";
    String CMD_DREREMOVEDBASE = "DREREMOVEDBASE";
    String CMD_DRERENAMEDBASE = "DRERENAMEDBASE";
    String CMD_DREREPLACE = "DREREPLACE";
    String CMD_DRERESET = "DRERESET";
    String CMD_DRERESIZEINDEXCACHE = "DRERESIZEINDEXCACHE";
    String CMD_DRESYNC = "DRESYNC";
    String CMD_DRETAGDOCCLUSTERS = "DRETAGDOCCLUSTERS";
    String CMD_DREUNDELETEDOC = "DREUNDELETEDOC";
    String CMD_DREVALIDATE = "DREVALIDATE";

    //---------- Index command parameter names...
    String PARAM_ACL_FIELDS = "ACLFields";
    String PARAM_BATCH_SIZE = "BatchSize";
    String PARAM_BLOCKING = "Blocking";
    String PARAM_CANT_HAVE_FIELDS = "CantHaveFields";
    String PARAM_CHECK_SUM_DBS = "CheckSumDBs";
    String PARAM_CHECK_SUM_FIELD = "CheckSumField";
    String PARAM_CLUSTER_DBS = "ClusterDBs";
    String PARAM_COMPRESS = "Compress";
    String PARAM_DATABASE = "Database";
    String PARAM_DATABASE_FIELDS = "DatabaseFields";
    String PARAM_DATABASE_MATCH = "DatabaseMatch";
    String PARAM_DATE_FIELDS = "DateFields";
    String PARAM_DB_NUM = "DBNum";
    String PARAM_DELETE = "Delete";
    String PARAM_DOCUMENT_DELIMITERS = "DocumentDelimiters";
    String PARAM_DOCUMENT_FORMAT = "DocumentFormat";
    String PARAM_DOCS = "Docs";
    String PARAM_DRE_DBNAME = "DREDbName";
    String PARAM_DUPLICATE_ACTION = "DuplicateAction";
    String PARAM_EXPIRE_DATE_FIELDS = "ExpiryDateFields";
    String PARAM_FIELD = "Field";
    String PARAM_FILE_NAME = "FileName";
    String PARAM_FLATTEN_INDEX_FIELDS = "FlattenIndexFields";
    String PARAM_HOST_DETAILS = "HostDetails";
    String PARAM_IDX_FIELD_PREFIX = "IDXFieldPrefix";
    String PARAM_INITIAL_ID = "InitialID";
    String PARAM_INDEX_CACHE_MAX_SIZE = "IndexCacheMaxSize";
    String PARAM_INDEX_FIELDS = "IndexFields";
    String PARAM_INSERT_VALUE = "InsertValue";
    String PARAM_INTERNAL = "Internal";
    String PARAM_KEEP_EXISTING = "KeepExisting";
    String PARAM_KILL_DUPLICATES = "KillDuplicates";
    String PARAM_KILL_DUPLICATES_DB = "KillDuplicatesDB";
    String PARAM_KILL_DUPLICATES_DB_FIELDS = "KillDuplicatesDBField";
    String PARAM_KILL_DUPLICATES_MATCH_DBS = "KillDuplicatesMatchDBs";
    String PARAM_KILL_DUPLICATES_MATCH_TARGET_DB = "KillDuplicatesMatchTargetDB";
    String PARAM_LANGUAGE_FIELDS = "LanguageFields";
    String PARAM_LANGUAGE_TYPE = "LanguageType";
    String PARAM_MATCH_ID = "MatchID";
    String PARAM_MATCH_REFERENCE = "MatchReference";
    String PARAM_MAX_DATE = "MaxDate";
    String PARAM_MAX_ID = "MaxId";
    String PARAM_MAX_SYNC_DELAY = "MaxSyncDelay";
    String PARAM_MIN_DATE = "MinDate";
    String PARAM_MIN_ID = "MinId";
    String PARAM_MIN_SCORE = "MinScore";
    String PARAM_MULTIPLE_VALUES = "MultipleValues";
    String PARAM_MUST_HAVE_FIELDS = "MustHaveFields";
    String PARAM_NEW_NAME = "NewName";
    String PARAM_NEW_VALUE = "NewValue";
    String PARAM_PRIORITY = "Priority";
    String PARAM_READ_ONLY = "ReadOnly";
    String PARAM_REFERENCE_FIELD = "ReferenceField";
    String PARAM_REFS = "Refs";
    String PARAM_RELEVANCE_FIELD = "RelevanceField";
    String PARAM_REPLACE_ALL_REFS = "ReplaceAllRefs";
    String PARAM_SECTION_FIELDS = "SectionFields";
    String PARAM_SECURITY_FIELDS = "SecurityFields";
    String PARAM_SECURITY_TYPE = "SecurityType";
    String PARAM_STATE_ID = "StateID";
    String PARAM_STATE_MATCH_ID = "StateMatchID";
    String PARAM_TAG_FIELD = "TagField";
    String PARAM_TAG_SOURCE_FIELD = "TagSourceField";
    String PARAM_TAGGED_DB_NAME = "TaggedDBName";
    String PARAM_TAG_VALUE = "TagValue";
    String PARAM_TARGET_ENGINE_HOST = "TargetEngineHost";
    String PARAM_TARGET_ENGINE_PORT = "TargetEnginePort";
    String PARAM_THREAD_HASH_FIELD = "ThreadHashField";
    String PARAM_TITLE_FIELDS = "TitleFields";
    String PARAM_TYPE = "Type";

    /**
     * Gets the name of the command to be executed.
     *
     * @return The index command to execute
     */
    String getCommand();

    /**
     * The GET portion of any index command.
     *
     * @return The query string to be sent as part of the index command
     */
    String getQueryString();

    /**
     * Should return the POST content for any index command that requires it.
     *
     * @return The POST content to send when the command is executed.
     */
    PostData getPostData();

}
