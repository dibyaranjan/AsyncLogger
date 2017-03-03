package com.github.dibyaranjan.asynclogger;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.net.httpserver.HttpServer;

/**
 * 
 * 
 * @author Dibya
 */
public class AppRunner {
    @Autowired
    private HttpServer httpServer;
    
    public void start() {
        httpServer.start();
    }
}
