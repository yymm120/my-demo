package com.example.java8demo.lambda;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.function.BiConsumer;

@SpringBootTest
public class Demo01FunctionTest {


    private static void buildA(String so, BiConsumer<String, Integer> bo){
        bo.accept("a", 1);
    }


    @Test
    void test(){
        buildA("a", (a, b) -> {

        });
    }
}
