package com.demospring;


import com.demospring.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;


/**
 * Demo7: IOC注解实例化对象
 */
public class Demo7 {

    ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("applicationContext-IOC(DI).xml");

    @Test
    void test1() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String name = "com.smbms.service.impl.UserServiceImpl";
        Class<?> aClass = Class.forName(name);
        Service annotation = aClass.getAnnotation(Service.class);
        if(annotation != null){
            //有@Service注解，实例化
            UserService userService = (UserService) aClass.newInstance();
            int count = userService.addUser("张三", 18);
            System.out.println("（主程序）影响行数：" + count);
        }else{
            throw new NoSuchBeanDefinitionException("No bean named 'userServiceImpl' is defined");
        }
    }
}
