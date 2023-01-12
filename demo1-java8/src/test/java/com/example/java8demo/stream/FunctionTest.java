package com.example.java8demo.stream;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.Function;

@SpringBootTest
public class FunctionTest {


    @Test
    void identityFunctionTest() {
        Function<String, String> identity = Function.identity();
        String result = identity.apply("abc");
        System.out.println(result);
    }


}
