package com.example.threadcommunicate;

import org.junit.jupiter.api.Test;

import javax.sound.midi.SoundbankResource;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Demo02WaitAndNotifyTest {



    /**
     * 方法描述: 线程A启动后一会儿后, 通知线程B开始执行
     * 2. wait()/notify()
     * Note: 必须配合synchronized, wait方法释放锁, notify方法不释放锁
     * 现象: A线程即使使用了notify方法唤醒了线程B,但线程B拿不到锁,A线程执行完之后,线程B开始执行.
     */
    @Test
    void test01(){
        Object lock = new Object();
        List<String> list = new ArrayList<>();
        Thread threadA = new Thread(() -> {
            synchronized(lock){
                for (int i = 0; i < 10; i++) {
                    list.add("abc");
                    System.out.println("A thread append a element, list size is " + list.size());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if (list.size() == 5){
                        lock.notify();
                    }
                }
            }
        });
        Thread threadB = new Thread(() -> {
            while (true){
                synchronized (lock){
                    if (list.size() != 5){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("线程B收到通知,开始执行业务");
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
