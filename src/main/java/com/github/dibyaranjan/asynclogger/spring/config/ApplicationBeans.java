package com.github.dibyaranjan.asynclogger.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.dibyaranjan.asynclogger.server.SimpleHttpServer;

@Configuration
public class ApplicationBeans {
	@Bean
	public SimpleHttpServer getSimpleHttpServer() {
		return new SimpleHttpServer();
	}
}
