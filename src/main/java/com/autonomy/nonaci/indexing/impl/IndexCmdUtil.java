package com.autonomy.nonaci.indexing.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.hc.core5.net.PercentCodec;
import org.apache.hc.core5.net.URLEncodedUtils;

import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Utilities for use in IndexCommand classes.
 */
class IndexCmdUtil {

    /**
     * @param value String to be used in a querystring name or value
     * @param blankAsPlus If true, encode ' ' as '+' rather than "%20"
     * @return Encoded value suitable for use in a querystring name or value
     */
    public static String encodeQueryParamPart(final String value, final boolean blankAsPlus) {
        // do this instead of PercentCodec.encode because we want ' ' encoded as '+' (for backwards compatibility)
        if (blankAsPlus) {
            return URLEncodedUtils.format(List.of(new BasicNameValuePair(value, null)), StandardCharsets.UTF_8);
        } else {
            return PercentCodec.encode(value, StandardCharsets.UTF_8);
        }
    }

    /**
     * @param builder Where to write encoded value
     * @param value To be encoded for use in a querystring; if this is a Collection, it will be encoded according to
     *              IDOL requirements for multi-valued parameters (e.g. Docs)
     */
    private static void encodeQueryParamValue(final StringBuilder builder, final Object value) {
        if (value instanceof Collection<?> valueList) {
            boolean empty = true;

            for (final Object valueItem : valueList) {
                if (valueItem != null) {
                    if (empty) {
                        empty = false;
                    } else {
                        builder.append('+');
                    }
                    builder.append(encodeQueryParamPart(valueItem.toString(), false));
                }
            }

        } else {
            builder.append(encodeQueryParamPart(value.toString(), true));
        }
    }

    /**
     * @param params IDOL query parameters; values may be a Collection
     * @return Parameters encoded as a querystring without leading '?'
     */
    public static String encodeQueryParams(final Map<String, ? extends Object> params) {
        final StringBuilder builder = new StringBuilder();

        for (final Map.Entry<String, ? extends Object> param : params.entrySet()) {
            final Object value = param.getValue();
            if (value != null) {
                if (!builder.isEmpty()) {
                    builder.append('&');
                }
                builder.append(encodeQueryParamPart(param.getKey(), true));
                builder.append('=');
                encodeQueryParamValue(builder, value);
            }

        }

        return builder.toString();
    }

    /**
     * @param queryStrings Possibly-null, possibly-blank querystrings to combine, without leading '?'
     * @return Combined querystrings without leading '?'
     */
    public static String combineQueryStrings(final List<String> queryStrings) {
        StringBuilder builder = null;
        for (final String queryString : queryStrings) {
            if (!StringUtils.isBlank(queryString)) {
                if (builder == null) {
                    builder = new StringBuilder(queryString);
                } else {
                    builder.append('&').append(queryString);
                }
            }
        }
        return builder == null ? "" : builder.toString();
    }

}
