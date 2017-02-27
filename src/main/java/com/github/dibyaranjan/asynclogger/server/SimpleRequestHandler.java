package com.github.dibyaranjan.asynclogger.server;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

/**
 * Keep listening to the ServerSocket
 * 
 * @author Dibya
 */
public class SimpleRequestHandler implements HttpHandler {

	public void handle(HttpExchange exchange) throws IOException {
		System.out.println(exchange.getRequestURI().getQuery());
		String response = "DUMMY";
		exchange.sendResponseHeaders(200, response.length());
		OutputStream os = exchange.getResponseBody();
		os.write(response.getBytes());
		os.close();
	}
}
