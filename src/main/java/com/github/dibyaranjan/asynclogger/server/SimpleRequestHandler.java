package com.github.dibyaranjan.asynclogger.server;

import java.io.IOException;
import java.io.OutputStream;
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
    private static final String SUCCESS = "{\"success\" : \"1\"}";
    private static final String FAILURE = "{\"success\" : \"0\"}";

    public void handle(HttpExchange exchange) throws IOException {
        OutputStream os = exchange.getResponseBody();
        try {
            GetParameterParser parser = new GetParameterParser();
            Map<UrlParameterKey, String> logMap = parser.parseQueryString(exchange.getRequestURI().getQuery());
            logToFile(logMap);
            exchange.sendResponseHeaders(200, SUCCESS.length());
            os.write(SUCCESS.getBytes());
        } catch (IllegalArgumentException e) {
            logger.error(e);
            exchange.sendResponseHeaders(200, FAILURE.length());
            os.write(FAILURE.getBytes());
        } finally {
            os.close();
        }

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
