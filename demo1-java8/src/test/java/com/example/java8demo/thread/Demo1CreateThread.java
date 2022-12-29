package com.example.java8demo.thread;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Demo1CreateThread {

    @Test
    void test1() throws InterruptedException {
        class MyThread extends Thread{
            @Override
            public void run() {
                System.out.println("hello");
            }
        }
        Thread.sleep(1000);
        new MyThread().start();
        Thread.sleep(5000);
        new MyThread().start();
    }

    @Test
    void test2(){
        Runnable hello = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };

    }
}
