package com.example.mylist;

import com.example.mylist.controller.MyListItemAction;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Demo02AnnotationTest {

    @Test
    void test01(){
        SimpleMyListDispatcher dispatcher = new SimpleMyListDispatcher();
        SimpleMyListDispatcher.processAnnotations(new MyListItemAction());
    }

}
