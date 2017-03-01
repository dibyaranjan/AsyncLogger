package com.github.dibyaranjan.asynclogger;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.dibyaranjan.asynclogger.server.SimpleHttpServer;

/**
 * 
 * 
 * @author Dibya
 */
public class AppRunner {
    @Autowired
    private SimpleHttpServer server;
    
    public void start() {
        server.listenHttpRequests();
    }
}
