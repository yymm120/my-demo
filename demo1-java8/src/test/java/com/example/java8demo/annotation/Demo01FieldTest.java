package com.example.java8demo.annotation;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@SpringBootTest
public class Demo01FieldTest {

    @Test
    void test01() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> aClass = Class.forName("com.example.java8demo.annotation.TestObject");
        // json -> type
        // TestObject
        // TestFiledAnnotation.class.


        Method test = aClass.getMethod("testFiledAnnotation", TestObject.class);
        Annotation[][] parameterAnnotations = test.getParameterAnnotations();
    }
}
