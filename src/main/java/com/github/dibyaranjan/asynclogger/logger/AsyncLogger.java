package com.github.dibyaranjan.asynclogger.logger;

import java.util.Map;

import com.github.dibyaranjan.asynclogger.constant.UrlParameterKey;

public interface AsyncLogger {
    void log(Map<UrlParameterKey, String> logMap);
}
