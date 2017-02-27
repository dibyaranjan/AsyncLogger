package com.github.dibyaranjan.asynclogger.spring.loader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextLoader {
	private static final String BASE_PACKAGE = "com.github.dibyaranjan.asynclogger.spring";
	private ApplicationContext applicationContext;

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public void loadApplicationContext() {
		applicationContext = new AnnotationConfigApplicationContext(BASE_PACKAGE);
	}
}
