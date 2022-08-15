package com.example.threadpool;

import okhttp3.*;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@SpringBootTest
public class Demo03AsyncCallBackTest {

    static Logger logger = LoggerFactory.getLogger(Demo03AsyncCallBackTest.class.getName());

    static final int SLEEP_GAP = 5000;
    static class HotWaterThread extends Thread{
        public HotWaterThread(){
            super("** HotWater-Thread");
        }
        public void run(){
            try{
                logger.info("waiting hotWater 5s");
                Thread.sleep(SLEEP_GAP);
                logger.info("after hotWater waiting.");
            }catch (InterruptedException e) {
                logger.info("发生异常");
            }
            logger.info("run end");
        }
    }

    static class WashTread extends Thread{
        public WashTread() {
            super("** Wash-Thread");
        }
        public void run(){
            try {
                logger.info("waiting wash 5s");
                Thread.sleep(SLEEP_GAP);
                logger.info("after hotWater waiting.");
            } catch (InterruptedException e) {
                logger.info("发生异常");
            }
            logger.info("run end");
        }
    }

    @Test
    void test01_Join_Demo(){
        HotWaterThread hotWaterThread = new HotWaterThread();
        WashTread washTread = new WashTread();
        hotWaterThread.start();
        washTread.start();

        try {
            logger.info("I can do other things");
            hotWaterThread.join();
            washTread.join();
            Thread.currentThread().setName("main Thread");
            logger.info("join end");
        } catch (InterruptedException e) {
            logger.info("join Exception");
        }
        logger.info(Thread.currentThread().getName() + "all end.");
    }

    // -------------------------------------------------------- //


    static class HotWaterJob implements Callable< Boolean> {
        @Override
        public Boolean call() throws Exception {
            try {
                logger.info("HotWaterJob waiting 5s"); //线程 睡眠 一段时间， 代表 烧水 中
                Thread.sleep(SLEEP_GAP);
                logger.info("HotWaterJob waiting 5s end.");
            } catch (InterruptedException e) {
                logger.info("hotWater Exception.");
                return false;
            }
            logger.info("hotWater run end");
            return true;
        }
    }
    static class WashJob implements Callable<Boolean>{

        @Override
        public Boolean call() throws Exception {
            try {
                logger.info(" WashJob waiting 5s"); //线程 睡眠 一段时间， 代表 烧水 中
                Thread.sleep(SLEEP_GAP);
                logger.info("WashJob waiting 5s end.");
            } catch (InterruptedException e) {
                logger.info("WashJob Exception.");
                return false;
            }
            logger.info("WashJob run end");
            return true;
        }
    }

    @Test
    void test02(){
        Thread.currentThread().setName("main Thread");
        Callable<Boolean> hotWaterJob = new HotWaterJob();
        FutureTask<Boolean> hotTask = new FutureTask<>(hotWaterJob);
        Thread hotThread = new Thread(hotTask, "**hotWaterThread");
        Callable<Boolean> washJob = new WashJob();
        FutureTask<Boolean> washTask = new FutureTask<>(washJob);
        Thread washThread = new Thread(washTask, "washJobThread");
        hotThread.start();
        washThread.start();
        // ...
        logger.info("I can do other things.");
        try {
            boolean hotOk = hotTask.get();
            Boolean washOk = washTask.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            logger.info(Thread.currentThread().getName() + " Exception ");
        }
        logger.info(Thread.currentThread().getName() + " run end...");
    }

    // -------------------------------------------------------------------------------- //

    /**
     * CompletableFuture
     */
    @Test
    void test3(){
        CompletableFuture<Boolean> hotJob = CompletableFuture.supplyAsync(() -> {
            try {
                logger.info(Thread.currentThread().getName() + " hotJob");
                Thread.sleep(SLEEP_GAP);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        });
        CompletableFuture<Boolean> washJob = CompletableFuture.supplyAsync(() -> {
            try {
                logger.info(Thread.currentThread().getName() + " washJob");
                Thread.sleep(SLEEP_GAP);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        });
        CompletableFuture<String> yesOrNo = hotJob.thenCombine(washJob, (hotOk, washOk) -> {
            if (hotOk && washOk) {
                logger.info("yes");
                return "yes";
            }
            return "no";
        });
        logger.info(yesOrNo.join());
    }


    @Test
    void test4(){

    }

}
