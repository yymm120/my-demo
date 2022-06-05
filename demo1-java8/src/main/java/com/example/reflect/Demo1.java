package com.example.reflect;


import com.pojo.User;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Deme1: java反射
 */
public class Demo1 {

    /**
     * 获取Class的方式
     * 1.Class.forName(全限定名)
     */
    @Test
    public void test1() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        //获取Class
        Class<?> aClass = Class.forName("com.smbms.reflect.User");

        //实例化对象
        Object obj = aClass.newInstance();
        User user = (User) obj;
        user.show();
    }

    /**
     * 获取Class的方式
     * 2.类名.class
     */
    @Test
    public void test2() throws InstantiationException, IllegalAccessException {
        //获取Class
        Class<?> aClass = User.class;

        //实例化对象
        Object obj = aClass.newInstance();
        User user = (User) obj;
        user.show();
    }

    /**
     * 获取Class的方式
     * 3.对象名.getClass()
     */
    @Test
    public void test3() throws InstantiationException, IllegalAccessException {
        User user = new User();
        //获取Class
        Class<?> aClass = user.getClass();

        //实例化对象
        Object obj = aClass.newInstance();
        User u = (User) obj;
        u.show();
    }

    /**
     * 获取所有的属性
     */
    @Test
    public void test4() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //获取Class
        Class<?> aClass = Class.forName("com.smbms.reflect.User");

        //获取所有包含父类的public属性
        Field[] fields = aClass.getFields();
        System.out.println("获取所有包含父类的public属性：");
        for (Field field : fields) {
            System.out.println(field);
        }

        //获取自身的所有属性，包含private
        Field[] declaredFields = aClass.getDeclaredFields();
        System.out.println("获取自身的所有属性：");
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        //获取自身指定的属性
        Field username = aClass.getDeclaredField("username");
        System.out.println("获取指定的属性：" + username);

        //获取父类
        Class<?> declaringClass = aClass.getSuperclass();
        System.out.println("父类：" + declaringClass);
        Field[] declaredFields1 = declaringClass.getDeclaredFields();
        System.out.println("父类中的所有方法：");
        for (Field field : declaredFields1) {
            System.out.println(field);
        }
    }

    /**
     * 获取所有方法
     */
    @Test
    public void test5() throws ClassNotFoundException, NoSuchMethodException {
        //获取Class
        Class<?> aClass = Class.forName("com.smbms.reflect.User");

        //获取所有包含父类的public方法
        Method[] methods = aClass.getMethods();
        System.out.println("获取所有包含父类的public方法：");
        for (Method method : methods) {
            System.out.println(method);
        }

        //获取自身的所有方法，包含private
        Method[] declaredMethods = aClass.getDeclaredMethods();
        System.out.println("获取自身的所有方法，包含private：");
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }

        //获取自身指定的方法
        Method play = aClass.getDeclaredMethod("play");
        System.out.println("获取自身指定的方法：" + play);
    }

    /**
     * 获取所有方法
     */
    @Test
    public void test6() throws ClassNotFoundException, NoSuchMethodException {
        //获取Class
        Class<?> aClass = Class.forName("com.smbms.reflect.User");

        //获取所有public构造方法
        Constructor<?>[] constructors = aClass.getConstructors();
        System.out.println("获取所有public构造方法：");
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        //获取所有构造方法，包含private
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        System.out.println("获取所有构造方法，包含private：");
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }

        //获取自身指定的构造方法
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class, int.class);
        System.out.println("获取自身指定的构造方法：" + declaredConstructor);
    }

    /**
     * 通过反射执行方法
     */
    @Test
    public void test7() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //获取Class
        Class<?> aClass = Class.forName("com.smbms.reflect.User");
        Object obj = aClass.newInstance();

        //获取公共方法-无参
        Method show = aClass.getDeclaredMethod("show");
        //执行方法
        show.invoke(obj);

        //获取封装方法-无参
        Method play = aClass.getDeclaredMethod("play");
        //解除障碍
        play.setAccessible(true);
        //执行方法
        play.invoke(obj);

        //获取封装方法-带参,返回值
        Method play2 = aClass.getDeclaredMethod("play", String.class);
        Object invoke = play2.invoke(obj, "哈哈哈哈");
        System.out.println("返回值：" + invoke);
    }
}

