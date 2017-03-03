package com.github.dibyaranjan.asynclogger;

import java.io.IOException;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.dibyaranjan.asynclogger.spring.loader.ApplicationContextLoader;

public class App {
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) throws IOException {
        try {
            ApplicationContextLoader contextLoader = new ApplicationContextLoader();
            contextLoader.loadApplicationContext();
            AppRunner runner = (AppRunner) contextLoader.getBean(AppRunner.class);
            runner.start();
        } catch (Exception e) {
            logger.error(ExceptionUtils.getFullStackTrace(e));
        }
    }
}