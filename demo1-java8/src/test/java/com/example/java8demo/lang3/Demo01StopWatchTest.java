package com.example.java8demo.lang3;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class Demo01StopWatchTest {

    @Test
    void test01(){
        // StopWatch watch = StopWatch.createStarted(); //创建后立即start，常用
        // //StopWatch watch = new StopWatch();
        // //watch.start();
        //
        // // Thread.sleep(1000);
        // System.out.println("统计从开始到现在运行时间：" + watch.getTime() + "ms"); //1000ms
        //
        // // Thread.sleep(1000);
        // watch.split();
        // System.out.println("从start到此刻为止的时间：" + watch.getTime());
        // System.out.println("从开始到第一个切入点运行时间：" + watch.getSplitTime()); //2245
        //
        // // Thread.sleep(1000);
        // watch.split();
        // System.out.println("从开始到第二个切入点运行时间：" + watch.getSplitTime());
        //
        // watch.reset(); //重置后必须使用start方法
        // watch.start();
        // // Thread.sleep(1000);
        // System.out.println("重新开始后到当前运行时间是：" + watch.getTime()); //1000
        //
        // watch.suspend(); //暂停
        // // Thread.sleep(6000); //模拟暂停6秒钟
        //
        // watch.resume(); //上面suspend，这里要想重新统计，需要恢复一下
        // System.out.println("恢复后执行的时间是：" + watch.getTime()); //1000  注意此时这个值还是1000
        //
        // watch.stop();
        // System.out.println("花费的时间》》" + watch.getTime() + "ms"); //1002ms
        // System.out.println("花费的时间》》" + watch.getTime(TimeUnit.SECONDS) + "s"); //1s 可以直接转成s
    }
}
