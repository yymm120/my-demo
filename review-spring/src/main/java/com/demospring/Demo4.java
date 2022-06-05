package com.demospring;


import com.smbms.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Demo4 依赖注入的方式
 */
public class Demo4 {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

    /*
    * <!--1.设值注入，通过set方法注入-->
    * <!--2.构造注入，通过构造方法注入，可以通过index指定参数下标、或者type指定参数类型-->
    * <!--3.p命名空间注入，通过set方法注入-->
    */
    @Test
    void test1(){
        User user1 = (User) applicationContext.getBean("user1");
        User user2 = (User) applicationContext.getBean("user2");
        User user3 = (User) applicationContext.getBean("user3");
    }

}
