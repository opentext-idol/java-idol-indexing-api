package com.autonomy.nonaci.indexing.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static com.autonomy.nonaci.indexing.IndexCommand.PARAM_DOCS;

/**
 * Helper for implementing commands with a Docs parameter.
 *
 * @param <T> Type of input document
 */
public class DocsHelper<T> {
    private Collection<T> docs = null;
    private String encodedDocs = null;

    /**
     * @param cmd
     * @param docs Docs as a collection
     */
    public void setDocs(final IndexCommandImpl cmd, final Collection<T> docs) {
        this.docs = docs;
        encodedDocs = null;
        cmd.put(PARAM_DOCS, null);
    }

    /**
     * @param cmd
     * @param encodedDocs Docs already in the querystring format expected by IDOL
     */
    public void setEncodedDocs(final IndexCommandImpl cmd, final String encodedDocs) {
        docs = null;
        this.encodedDocs = encodedDocs;
        cmd.put(PARAM_DOCS, null);
    }

    /**
     * @param cmd
     * @param docs Docs unencoded, joined by space
     */
    @Deprecated
    public void setDocs(final IndexCommandImpl cmd, final String docs) {
        this.docs = null;
        encodedDocs = null;
        cmd.put(PARAM_DOCS, docs);
    }

    /**
     * @param baseQueryString Querystring for other parameters
     * @return Querystring including Docs parameter
     */
    public String getQueryString(final String baseQueryString) {
        final List<String> queryStrings = new ArrayList<>();
        queryStrings.add(baseQueryString);
        if (docs != null) {
            queryStrings.add(IndexCmdUtil.encodeQueryParams(Map.of(PARAM_DOCS, docs)));
        }
        if (encodedDocs != null) {
            queryStrings.add(IndexCmdUtil.encodeQueryParamPart(PARAM_DOCS, true) + '=' + encodedDocs);
        }
        return IndexCmdUtil.combineQueryStrings(queryStrings);
    }

}
