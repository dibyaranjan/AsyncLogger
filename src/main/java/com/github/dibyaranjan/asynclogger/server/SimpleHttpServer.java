package com.github.dibyaranjan.asynclogger.server;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.net.httpserver.HttpServer;

public class SimpleHttpServer {
    @Autowired
    private HttpServer httpServer;

    public void setHttpServer(HttpServer httpServer) {
        this.httpServer = httpServer;
    }

    public void listenHttpRequests() {
        httpServer.start();
    }

}