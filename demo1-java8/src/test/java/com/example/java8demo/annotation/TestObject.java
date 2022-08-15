package com.example.java8demo.annotation;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestObject {
    final Logger logger = LoggerFactory.getLogger(TestObject.class.getName());

    public String testFiledAnnotation(@TestFiledAnnotation TestObject obj){
        logger.info("test ");
        return null;
    }
}
