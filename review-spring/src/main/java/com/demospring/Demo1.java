package com.demospring;


import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Demo1: IOC(DI) 控制反转(依赖注入)
 * 依赖注入和控制反转指的都是一个东西, 将bean的生命交给容器管理
 *   - javaBean的创建不是我们手动new出来的
 *   - javaBean的属性也不在代码中set进去的
 */
public class Demo1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("applicationContext-IOC(DI).xml");
        application.getBean("user"); // singleton单例
        application.getBean("role"); // prototype原型
        application.close();
    }
}
