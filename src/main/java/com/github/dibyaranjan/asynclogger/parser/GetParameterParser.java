package com.github.dibyaranjan.asynclogger.parser;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.dibyaranjan.asynclogger.constant.UrlParameterKey;

public class GetParameterParser {
    private static final Logger logger = LogManager.getLogger(GetParameterParser.class);

    public Map<UrlParameterKey, String> parseQueryString(String query) {
        logger.debug("The query string is " + query);
        if (StringUtils.isEmpty(query)) {
            return Collections.emptyMap();
        }

        List<String> paramValuePairs = new LinkedList<String>();

        int startIndex = 0;
        int endIndex = query.indexOf('&');
        while (endIndex != -1) {
            paramValuePairs.add(query.substring(startIndex, endIndex));
            startIndex = endIndex + 1;
            endIndex = query.indexOf('&', startIndex);
        }
        paramValuePairs.add(query.substring(startIndex, query.length()));

        Map<UrlParameterKey, String> logMap = new LinkedHashMap<UrlParameterKey, String>();
        for (String paramValuePair : paramValuePairs) {
            int splitIndex = paramValuePair.indexOf('=');
            String paramName = paramValuePair.substring(0, splitIndex);
            String data = paramValuePair.substring(splitIndex + 1);

            UrlParameterKey keyByValue = UrlParameterKey.getKeyByValue(paramName);
            logMap.put(keyByValue, data);
        }

        return logMap;
    }
}
