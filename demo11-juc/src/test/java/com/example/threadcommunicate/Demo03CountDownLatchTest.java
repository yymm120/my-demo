package com.example.threadcommunicate;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Demo03CountDownLatchTest {

    /**
     * 方法描述: 线程A启动后一会儿后, 通知线程B开始执行
     * 2. CountDownLatch
     * Note:
     */
    @Test
    void test01(){
        CountDownLatch countDownLatch = new CountDownLatch(1);
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
                if (list.size() == 5){
                    countDownLatch.countDown();
                }
            }
        });
        Thread threadB = new Thread(() -> {
           while (true){
               if (list.size() != 5){
                   try {
                       countDownLatch.await();
                   } catch (InterruptedException e) {
                       throw new RuntimeException(e);
                   }
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
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
