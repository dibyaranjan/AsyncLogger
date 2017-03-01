package com.github.dibyaranjan.asynclogger.constant;

import org.apache.commons.lang.StringUtils;

public enum UrlParameterKey {
    ID("messageId"),
    LOG_LEVEL("logLevel"),
    SOURCE_NAME("sourceName"),
    METHOD_NAME("methodName"),
    MESSAGE("message");

    private String parameterName;

    private UrlParameterKey(String parameterName) {
        this.parameterName = parameterName;
    }

    public static UrlParameterKey getKeyByValue(String parameterName) {
        if (StringUtils.isEmpty(parameterName)) {
            throw new NullPointerException("parameterName must be not null");
        }

        if (StringUtils.equalsIgnoreCase(parameterName, ID.parameterName)) {
            return ID;
        } else if (StringUtils.equalsIgnoreCase(parameterName, LOG_LEVEL.parameterName)) {
            return LOG_LEVEL;
        } else if (StringUtils.equalsIgnoreCase(parameterName, SOURCE_NAME.parameterName)) {
            return SOURCE_NAME;
        } else if (StringUtils.equalsIgnoreCase(parameterName, METHOD_NAME.parameterName)) {
            return METHOD_NAME;
        } else if (StringUtils.equalsIgnoreCase(parameterName, MESSAGE.parameterName)) {
            return MESSAGE;
        } 
        
        throw new IllegalArgumentException("Invalid parameter name passed");
    }
}
