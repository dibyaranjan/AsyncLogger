package com.github.dibyaranjan.asynclogger;

import java.io.IOException;

import com.github.dibyaranjan.asynclogger.spring.loader.ApplicationContextLoader;

public class App {
    public static void main(String[] args) throws IOException {
        ApplicationContextLoader contextLoader = new ApplicationContextLoader();
        contextLoader.loadApplicationContext();
        AppRunner runner = (AppRunner) contextLoader.getBean(AppRunner.class);
        runner.start();
    }
}