package com.example.mylist;


import com.example.mylist.Annotation.MyListMapping;
import com.example.mylist.controller.MyListAction;

import javax.sound.midi.SoundbankResource;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class SimpleMyListDispatcher {
    Map<String, String> actions = Map.of("myLIst", "/MyListItemAction");

    public MyListAction doDispatch(){
        String myList = actions.get("myList");
        
        return null;
    }


    public static void processAnnotations(Object obj){
        try {
            Class<?> clazz = obj.getClass();
            System.out.println(clazz);
            for (Method method : clazz.getDeclaredMethods()) {
                System.out.println(method);
                MyListMapping mapping = method.getAnnotation(MyListMapping.class);
                System.out.println(mapping);
                if (mapping != null){
                    Field declaredField = clazz.getDeclaredField(mapping.value());
                    declaredField.setAccessible(true);
                }
            }
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 根据注解, 把action类注册进来
     */
    private void registryActions(){

    }

    /**
     *
     */
}
