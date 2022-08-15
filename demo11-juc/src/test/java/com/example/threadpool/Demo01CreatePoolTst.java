package com.example.threadpool;


import com.google.common.util.concurrent.*;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.*;

@SpringBootTest
public class Demo01CreatePoolTst {

    static Logger logger = LoggerFactory.getLogger(Demo01CreatePoolTst.class.getName());

    @Test
    void test1() {
        // Step1:
        ExecutorService pool = new ThreadPoolComponent().getMirrorIOExecutorService(24, 30L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(128), new ThreadPoolExecutor.DiscardOldestPolicy());
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            return "";
        }, pool);
    }

    @Test
    void test2() {
        ThreadPoolExecutor pool_0_max_30s_lb_default_discard = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30, TimeUnit.SECONDS, new LinkedBlockingDeque<>(128), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
        ThreadPoolExecutor pool0 = pool_0_max_30s_lb_default_discard;
    }


    static class HotWaterJob implements Callable<Boolean>//①
    {
        @Override
        public Boolean call() throws Exception //②
        {
            try {
                logger.info(" 洗 好 水壶");
                logger.info(" 烧开水"); //线程 睡眠 一段时间， 代表 烧水 中
                Thread.sleep(3000);
                logger.info(" 水 开了");
            } catch (InterruptedException e) {
                logger.info(" 发生 异常 被 中断.");
                return false;
            } logger.info(" 烧水 工作， 运行 结束.");
            return true;
        }
    }


    //泡茶 喝 的 工作
    static class DrinkJob {
        boolean waterOk = false;
        boolean cupOk = false;

        //泡茶 喝， 回 调 方法
        public void drinkTea() {
            if (waterOk && cupOk) {
                logger.info(" 泡茶 喝， 茶 喝完");
                this.waterOk = false;
            }
        }
    }

    static class WashJob implements Callable<Boolean> {
        @Override
        public Boolean call() throws Exception {
            try {
                logger.info(" 洗 茶杯");
                //线程 睡眠 一段时间， 代表 清洗 中
                Thread.sleep(3000);
                logger.info(" 洗 完了");
            } catch (InterruptedException e) {
                logger.info(" 清洗 工作 发生 异常 被 中断.");
                return false;
            }
            logger.info(" 清洗 工作 运行 结束.");
            return true;
        }
    }

    @Test
    void test3() throws InterruptedException {
        Thread.currentThread().setName(" main thread.");
        //新 起 一个 线程， 作为 泡茶 主 线程
        DrinkJob drinkJob = new DrinkJob();
        //烧水 的 业务 逻辑
        Callable<Boolean> hotJob = new HotWaterJob();
        //清洗 的 业务 逻辑
        Callable<Boolean> washJob = new WashJob();
        //创建 Java 线程 池
        ExecutorService jPool = Executors.newFixedThreadPool(10);
        //包装 Java 线程 池， 构造 guava 线程 池
        ListeningExecutorService gPool = MoreExecutors.listeningDecorator(jPool);
        //烧水 的 回 调 钩子
        FutureCallback<Boolean> hotWaterHook = new FutureCallback<Boolean>() {
            public void onSuccess(Boolean r) {
                if (r) {
                    drinkJob.waterOk = true;
                    //执行 回 调 方法
                    drinkJob.drinkTea();
                }
            }

            public void onFailure(Throwable t) {
                logger.info(" 烧水 失败， 没有 茶 喝了");
            }
        };
        //启动 烧水 线程
        ListenableFuture< Boolean> hotFuture = gPool.submit( hotJob);
        //设置 烧水 任务 的 回 调 钩子
        Futures.addCallback( hotFuture, hotWaterHook);
        //启动 清洗 线程
        ListenableFuture< Boolean> washFuture = gPool. submit( washJob);
        //使用 匿名 实例， 作为 清洗 之 后的 回 调 钩子
        Futures. addCallback( washFuture, new FutureCallback< Boolean>() {
            public void onSuccess( Boolean r) {
                if (r) {
                    drinkJob. cupOk = true;
                    //执行 回 调 方法
                    drinkJob. drinkTea();
                }
            }
            public void onFailure( Throwable t) {
                logger.info(" 杯子 洗 不了， 没有 茶 喝了");
            }
        });

        logger.info(" 干 点 其他 事情...");
        Thread.sleep(1000);
        logger.info(" 执行 完成");
    }
}
