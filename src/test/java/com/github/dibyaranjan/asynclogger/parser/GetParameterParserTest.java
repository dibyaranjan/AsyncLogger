package com.github.dibyaranjan.asynclogger.parser;

import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.github.dibyaranjan.asynclogger.constant.UrlParameterKey;

public class GetParameterParserTest {
    private GetParameterParser parser;

    @Before
    public void setUp() {
        parser = new GetParameterParser();
    }

    @After
    public void tearDown() {
        parser = null;
    }

    @Test
    public void testEmptyQueryString() {
        Map<UrlParameterKey, String> logMap = parser.parseQueryString("");
        Assert.assertTrue("Object should be empty", logMap.isEmpty());
    }

    @Test
    public void testWithOnlyMessage() {
        Map<UrlParameterKey, String> logMap = parser.parseQueryString("message=This is message");
        String data = logMap.get(UrlParameterKey.MESSAGE);
        Assert.assertEquals("Data should be matching", "This is message", data);
    }

    @Test
    public void testWithMessageAndId() {
        Map<UrlParameterKey, String> logMap = parser.parseQueryString("message=This is message&messageId=acefd998k");
        
        String messageData = logMap.get(UrlParameterKey.MESSAGE);
        Assert.assertEquals("Data should be matching", "This is message", messageData);
        
        String idData = logMap.get(UrlParameterKey.ID);
        Assert.assertEquals("Data should be matching", "acefd998k", idData);
    }
    
    @Test
    public void testWithSingleCharacterMessageAndId() {
        Map<UrlParameterKey, String> logMap = parser.parseQueryString("message=A&messageId=B");
        
        String messageData = logMap.get(UrlParameterKey.MESSAGE);
        Assert.assertEquals("Data should be matching", "A", messageData);
        
        String idData = logMap.get(UrlParameterKey.ID);
        Assert.assertEquals("Data should be matching", "B", idData);
    }
    
    @Test
    public void testWithAllValues() {
        Map<UrlParameterKey, String> logMap = parser.parseQueryString("message=This is message&messageId=acefd998k&methodName=getDummy&sourceName=server.php");
        
        String messageData = logMap.get(UrlParameterKey.MESSAGE);
        Assert.assertEquals("Data should be matching", "This is message", messageData);
        
        String idData = logMap.get(UrlParameterKey.ID);
        Assert.assertEquals("Data should be matching", "acefd998k", idData);
        
        String sourceData = logMap.get(UrlParameterKey.SOURCE_NAME);
        Assert.assertEquals("Data should be matching", "server.php", sourceData);
        
        String methodData = logMap.get(UrlParameterKey.METHOD_NAME);
        Assert.assertEquals("Data should be matching", "getDummy", methodData);
    }
    
    @Test
    public void testWithAllSingleCharacterValues() {
        Map<UrlParameterKey, String> logMap = parser.parseQueryString("message=A&messageId=B&methodName=C&sourceName=D");
        
        String messageData = logMap.get(UrlParameterKey.MESSAGE);
        Assert.assertEquals("Data should be matching", "A", messageData);
        
        String idData = logMap.get(UrlParameterKey.ID);
        Assert.assertEquals("Data should be matching", "B", idData);
        
        String sourceData = logMap.get(UrlParameterKey.SOURCE_NAME);
        Assert.assertEquals("Data should be matching", "D", sourceData);
        
        String methodData = logMap.get(UrlParameterKey.METHOD_NAME);
        Assert.assertEquals("Data should be matching", "C", methodData);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testWithInvalidParameter() {
        parser.parseQueryString("data=A");
        
        Assert.fail("Should have thrown exception");
    }
}
