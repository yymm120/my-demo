package com.example.threadpool;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.*;

@SpringBootTest
public class Demo01CreatePool {

    @Test
    void test1(){
        // Step1:
        ExecutorService pool = new ThreadPoolComponent().getMirrorIOExecutorService(24, 30L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(128), new ThreadPoolExecutor.DiscardOldestPolicy());
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            return "";
        }, pool);
    }
}
