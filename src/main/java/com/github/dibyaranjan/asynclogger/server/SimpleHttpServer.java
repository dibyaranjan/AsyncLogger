package com.github.dibyaranjan.asynclogger.server;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sun.net.httpserver.HttpServer;

public class SimpleHttpServer {
	private final static Logger logger = LogManager.getLogger(SimpleHttpServer.class);

	private int port;
	private int numberOfClients;

	public void setPort(int port) {
		this.port = port;
	}

	public void setNumberOfClients(int numberOfClients) {
		this.numberOfClients = numberOfClients;
	}

	public void start() {
		try {
			HttpServer server = HttpServer.create(new InetSocketAddress(port), numberOfClients);
			server.createContext("/log", new SimpleRequestHandler());
			server.setExecutor(null);
			server.start();
		} catch (IOException e) {
			logger.error(e);
		}
	}

}