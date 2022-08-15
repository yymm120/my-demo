package com.example.threadcommunicate;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Demo04ReentrantLockTest {

    /**
     * 方法描述: 线程A启动后一会儿后, 通知线程B开始执行
     * 2. ReentrantLock配合Condition.signal()
     * Note: 和wait/notify一样,线程B无法获取锁,仍然需要等线程A执行完之后,线程B才开始执行. (有锁的情况)
     */
    @Test
    void test01() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        List<String> list = new ArrayList<>();
        Thread threadA = new Thread(() -> {
            lock.lock();
            for (int i = 0; i < 10; i++) {
                list.add("abc");
                System.out.println("A thread append a element, list size is " + list.size());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (list.size() == 5){
                    condition.signal();
                }
            }
            lock.unlock();
        });
        Thread threadB = new Thread(() -> {
            lock.lock();
            if (list.size() != 5){
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("线程B收到通知,开始执行业务...");
            lock.unlock();
        });
        threadB.start();
        Thread.sleep(1000);
        threadA.start();
        Thread.sleep(10000);

    }
}
