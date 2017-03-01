package com.github.dibyaranjan.asynclogger.server;

import java.io.IOException;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.dibyaranjan.asynclogger.constant.UrlParameterKey;
import com.github.dibyaranjan.asynclogger.parser.GetParameterParser;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

/**
 * 
 * @author Dibya
 */
public class SimpleRequestHandler implements HttpHandler {
    private static final Logger logger = LogManager.getLogger();

    public void handle(HttpExchange exchange) throws IOException {
        GetParameterParser parser = new GetParameterParser();
        Map<UrlParameterKey, String> logMap = parser.parseQueryString(exchange.getRequestURI().getQuery());
        logToFile(logMap);
        exchange.sendResponseHeaders(200, 2);
        exchange.getResponseBody().write("as".getBytes());
        exchange.getResponseBody().flush();
        exchange.getResponseBody().close();
    }

    private void logToFile(Map<UrlParameterKey, String> logMap) {
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
