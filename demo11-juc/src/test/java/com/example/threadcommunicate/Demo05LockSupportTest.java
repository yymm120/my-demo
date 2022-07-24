package com.example.threadcommunicate;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

public class Demo05LockSupportTest {


    /**
     * 方法描述: 线程A启动后一会儿后, 通知线程B开始执行
     * 2. wait()/notify()
     * Note: 灵活的通信方式, 但是需要知道线程的名字才能唤醒
     */
    @Test
    void test01() throws InterruptedException {

        List<String> list = new ArrayList<>();
        Thread threadB = new Thread(() -> {
            if (list.size() != 5) {
                LockSupport.park();
            }
            System.out.println("线程B收到通知,开始执行业务...");
        });
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
                    LockSupport.unpark(threadB);
                }
            }
        });
        threadA.start();
        threadB.start();
        Thread.sleep(10000);

    }
}
