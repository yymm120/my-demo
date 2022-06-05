package com.demospring;


import com.demospring.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smbms.pojo.TestEntity;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Demo6: AOP: 最终增强和环绕增强
 * @see TestEntity
 */
public class Demo6 {
    ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("applicationContext-AOP.xml");
    @Test
    void test1() throws JsonProcessingException {
        UserService userService = (UserService) application.getBean("userService");
        userService.addUser("罗", 123);
        application.close();
    }
}
