package com.example.threadcommunicate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class Demo01VolatileTest {

    // 1. volatile关键字,
    static volatile boolean notice = false;


    /**
     * 方法描述:线程A启动一会儿后,通知线程B开始执行.
     */
    @Test
    void test01(){
        List<String> list = new ArrayList<>();
        Thread threadA = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                list.add("abc");
                System.out.println("A thread append a element, list size is " + list.size());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                // 通知线程B开始执行
                if (list.size() == 5) {
                    notice = true;
                }
            }
        });
        Thread threadB = new Thread(() -> {
            while (true) {
                if (notice) {
                    System.out.println("线程B收到通知,开始执行业务...");
                    break;
                }
            }
        });
        threadB.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        threadA.start();
    }
}
