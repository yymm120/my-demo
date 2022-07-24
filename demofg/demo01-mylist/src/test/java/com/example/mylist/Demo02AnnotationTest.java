package com.example.mylist;

import com.example.mylist.controller.MyListItemAction;
import com.example.mylist.dispatcher.SimpleMyListDispatcher;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Demo02AnnotationTest {

    @Test
    void test01(){
        SimpleMyListDispatcher dispatcher = new SimpleMyListDispatcher();
        SimpleMyListDispatcher.processAnnotations(new MyListItemAction());
    }


    @Test
    void test02(){

    }

}
