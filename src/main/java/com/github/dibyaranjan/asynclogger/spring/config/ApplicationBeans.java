package com.github.dibyaranjan.asynclogger.spring.config;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.dibyaranjan.asynclogger.AppRunner;
import com.github.dibyaranjan.asynclogger.server.SimpleRequestHandler;
import com.sun.net.httpserver.HttpServer;

@Configuration
public class ApplicationBeans {
	private static final Logger logger = LogManager.getLogger(ApplicationBeans.class);
	
	@Bean
	public HttpServer getHttpServer() {
		//TODO - Fetch from properties file
		int portNumber = 3177;
		try {
			HttpServer server = HttpServer.create(new InetSocketAddress(portNumber), 100);
			server.createContext("/log", new SimpleRequestHandler());
			server.setExecutor(null);
			return server;
		} catch (IOException e) {
			logger.error(e);
			throw new BeanCreationException("Could not create HttpServer with port : " + portNumber);
		}
	}

	@Bean
	public AppRunner getAppRunner() {
	    return new AppRunner();
	}
}
