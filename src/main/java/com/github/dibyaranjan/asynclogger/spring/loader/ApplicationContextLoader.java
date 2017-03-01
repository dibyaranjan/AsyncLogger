package com.github.dibyaranjan.asynclogger.spring.loader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * A class which loads and wires dependencies
 * 
 * @author Dibya Ranjan
 */
public class ApplicationContextLoader {
    private static final Logger logger = LogManager.getLogger(ApplicationContextLoader.class);
    private static final String BASE_PACKAGE = "com.github.dibyaranjan.asynclogger.spring";
    private AnnotationConfigApplicationContext applicationContext;

    public void loadApplicationContext() {
        applicationContext = new AnnotationConfigApplicationContext(BASE_PACKAGE);
    }

    public Object getBean(Class<?> clazz) {
        Object bean = applicationContext.getBean(clazz);
        if (bean == null) {
            logger.error("No bean exist for the class " + clazz.getCanonicalName());
            throw new IllegalArgumentException("No beans exist!");
        }
        return bean;
    }
    
    public void shutDown() {
        applicationContext.close();
    }
}
