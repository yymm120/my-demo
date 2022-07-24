package com.example.mylist;

import com.example.mylist.controller.MyListItemAction;
import com.google.common.collect.ImmutableMap;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Method;


@SpringBootTest
public class Demo03ReflectTest {


    @Test
    void test03_reflect_spend_time(){
        ImmutableMap<String, String> map = ImmutableMap.of("/mylist/update", "com/example/mylist/controller/MyListItemAction.updateQty");
        // package
        String packagePath = "com.example.mylist.handler";
        String actionKey = "/mylist/update";

        // get a class name.
        String className = map.get(actionKey).split("\\.")[0].trim();
        // get a handler method
        // if (has tow element)
        String handlerName = map.get(actionKey).split("\\.")[1].trim();

        try{
            StopWatch started = StopWatch.createStarted();
            for (int i = 0; i < 1000000; i++) {
                Class<?> clazz = Class.forName("com.example.mylist.controller.MyListItemAction");
                Method method = clazz.getDeclaredMethod(handlerName, String.class);
                method.invoke(clazz.newInstance(), "test reflect1");
            }
            started.reset();
            System.out.println(started.getTime() + "ms");
            started.start();
            for (int i = 0; i < 1000000; i++) {
                MyListItemAction myListItemAction = new MyListItemAction();
                myListItemAction.updateQty("test reflect2");
            }
            System.out.println(started.getTime() + "ms");
            started.stop();

        }catch (Exception e){
            System.out.println("exception");
        }
    }
}
