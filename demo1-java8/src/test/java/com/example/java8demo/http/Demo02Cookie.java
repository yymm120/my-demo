package com.example.java8demo.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
public class Demo02Cookie {

    class ABC<T> {

    }

    @Test
    void test01() {
        ABC<String> stringABC = new ABC<>();
        System.out.println(stringABC.getClass().getComponentType());
    }

}
