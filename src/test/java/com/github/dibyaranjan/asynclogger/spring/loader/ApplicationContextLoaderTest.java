package com.github.dibyaranjan.asynclogger.spring.loader;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;

import com.sun.net.httpserver.HttpServer;

public class ApplicationContextLoaderTest {
    private ApplicationContextLoader contextLoader;
    {
        contextLoader = new ApplicationContextLoader();
        contextLoader.loadApplicationContext();
    }
    
    @After
    public void tearDown() {
        contextLoader.shutDown();
    }

    public void testPackageScanning() {
        HttpServer bean = (HttpServer) contextLoader.getBean(HttpServer.class);

        if (bean == null) {
            Assert.fail("Could not create bean");
        }
    }

    @Test(expected = NoSuchBeanDefinitionException.class)
    public void testWithInvalidBean() {
        contextLoader.getBean(String.class);

        Assert.fail("Above line should have thrown an exception");
    }
}
