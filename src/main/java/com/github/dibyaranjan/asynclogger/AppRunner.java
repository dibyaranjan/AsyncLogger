package com.github.dibyaranjan.asynclogger;

import com.github.dibyaranjan.asynclogger.server.SimpleHttpServer;

/**
 * 
 * 
 * @author Dibya
 */
public class AppRunner {
	public void start() {
		SimpleHttpServer server = new SimpleHttpServer();
		//TODO - Fetch from properties file
		server.setPort(3177);
		server.start();
	}
}
