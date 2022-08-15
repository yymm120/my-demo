package com.example.java8demo.serialize.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Demo01ClassAnnotationTest {

    /**
     * https://blog.csdn.net/boling_cavalry/article/details/108589494
     * @throws JsonProcessingException
     */
    @Test
    void test01() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        // 美化输出
        ObjectMapper enable = mapper.enable(SerializationFeature.INDENT_OUTPUT);
        // 开启root对象特性
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        com.pojo.Test test = new com.pojo.Test();
        test.setField01("123");
        System.out.println(mapper.writeValueAsString(test));
    }
}
