package com.github.dibyaranjan.asynclogger.logger;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.dibyaranjan.asynclogger.constant.UrlParameterKey;

public class FileLogger implements AsyncLogger {
    private static final Logger logger = LogManager.getLogger("clientLogger");

    public void log(Map<UrlParameterKey, String> logMap) {

        StringBuilder sb = new StringBuilder();
        // [ID] [Souce.method] message
        sb.append("[");
        sb.append(logMap.get(UrlParameterKey.ID));
        sb.append("] ");
        sb.append("[");
        sb.append(logMap.get(UrlParameterKey.SOURCE_NAME));
        sb.append(".");
        sb.append(logMap.get(UrlParameterKey.METHOD_NAME));
        sb.append("] ");
        sb.append(logMap.get(UrlParameterKey.MESSAGE));

        logger.info(sb.toString());
    }
}
