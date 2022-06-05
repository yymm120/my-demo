package com.demospring;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smbms.pojo.TestEntity;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Demo5: IOC注入不同的数据类型
 * @see TestEntity
 */
public class Demo5 {
    public static void main(String[] args) throws JsonProcessingException {
        ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
        TestEntity entity = (TestEntity) application.getBean("entity");
        String entityJsonString = new ObjectMapper().writeValueAsString(entity);
        System.out.println(entityJsonString);
        application.close();
    }
}
