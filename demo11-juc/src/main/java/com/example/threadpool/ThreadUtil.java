// package com.example.threadpool;
//
// import java.util.concurrent.*;
//
// public class ThreadUtil {
//     //CPU 核 数
//     private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
//     //IO 处理 线程 数
//     private static final int IO_MAX = Math.max(2, CPU_COUNT * 2);
//     /**
//      * 空闲 保 活 时限， 单位 秒
//      */
//     private static final int KEEP_ALIVE_SECONDS = 30;
//     /**
//      * 有 界 队列 size
//      */
//
//     private static final int QUEUE_SIZE = 128;
//
//     //懒汉 式 单 例 创建 线程 池： 用于 IO 密集型 任务
//     private static class IoIntenseTargetThreadPoolLazyHolder {
//         //线程 池： 用于 IO 密集型 任务
//         private static final ThreadPoolExecutor EXECUTOR = new ThreadPoolExecutor(
//                 IO_MAX,
//                 //CPU 核 数* 2
//                 IO_MAX,
//                 //CPU 核 数* 2
//                 KEEP_ALIVE_SECONDS, TimeUnit.SECONDS,
//                 new LinkedBlockingQueue(QUEUE_SIZE),
//                 new CustomThreadFactory("io")
//         );
//
//         static {
//             EXECUTOR.allowCoreThreadTimeOut(true);//JVM 关闭 时 的 钩子 函数
//             Runtime.getRuntime().addShutdownHook(
//                     new ShutdownHookThread("IO 密集型 任务 线程 池", new Callable<Void>() {
//                         @Override
//                         public Void call() throws Exception {
//                             //优雅 地 关闭 线程 池
//                             shutdownThreadPoolGracefully(EXECUTOR);
//                             return null;
//                         }
//                     })
//             );
//         }
//     }
//     // 省略 不相干 代码
// }
