package com.example.java8demo.guava;

import com.google.common.base.Stopwatch;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

/**
 * 1. stopWatch          计时功能
 * 2. eventBus           事件总线
 */
@SpringBootTest
public class BaseTools {

	@SneakyThrows
	@Test
	void test(){
		// 创建并启动计时器
		Stopwatch stopwatch = Stopwatch.createStarted();
		// 执行时间（1s）
		Thread.sleep(1000);
		// 停止计时器
		stopwatch.stop();
		// 执行时间（单位：秒）
		System.out.printf("执行时长：%d 秒. %n", stopwatch.elapsed().getSeconds()); // %n 为换行
		// 执行时间（单位：毫秒）
		System.out.printf("执行时长：%d 豪秒.", stopwatch.elapsed(TimeUnit.MILLISECONDS));
		System.out.printf("执行时长：%d 微秒.", stopwatch.elapsed(TimeUnit.MICROSECONDS));
	}
}
