package com.appium;

import androidx.test.uiautomator.UiSelector;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Demo1 {


    @Test
    void test2(){

    }




    @Test
    void test1(){
        // new UiSelector().text("")
        new UiSelector().className("").childSelector(new UiSelector().text(""));
        // new UiSelector().className("").childSelector()
    }
}
