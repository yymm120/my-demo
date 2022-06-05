package com.demospring;


import com.demospring.service.UserService;
import com.demospring.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 *
 * Demo2: AOP 切面编程<br/>
 * 切面编程
 */
public class Demo2 {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

    /** Demo2 - Sprint, test1方法在applicationContext.xml中配置了AOP*/
    @Test
    void test1() {
        UserService userService = (UserService) applicationContext.getBean("userService");
        int addCount = userService.addUser("罗", 1);
        int delCount = userService.delUser(16);
    }

    /** Demo2 - Spring, test2方法直接new一个对象, 没有用到AOP*/
    @Test
    void test2() {
        UserServiceImpl userService = new UserServiceImpl();
        int addCount = userService.addUser("罗", 1);
        int delCount = userService.delUser(16);
    }
}
