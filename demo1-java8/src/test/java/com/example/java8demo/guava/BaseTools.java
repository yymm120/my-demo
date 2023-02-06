package com.example.java8demo.guava;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.google.common.base.Joiner;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.xmlunit.util.Mapper;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

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


	@Data
	@AllArgsConstructor
	class BizListItemData{
		private String catalogId;
		private String productId;
		private String quantity;
		private String giftListId;
		private String ok;
	}

	@Test
	void testJoiner() throws JsonProcessingException {
		ArrayList<BizListItemData> bizListItemData = new ArrayList<>();
		bizListItemData.add(new BizListItemData("5124324", "Per-c9d", "9", "gi12000", null));
		bizListItemData.add(new BizListItemData("5124324", "Per-c9d", "9", "gi12000", null));
		bizListItemData.add(new BizListItemData("5124324", "Per-c9d", "9", "gi12000", null));
		ObjectMapper objectMapper = new ObjectMapper();
		// 1.
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		// 2.
		getStringParametersFromInput(bizListItemData);
	}

	public String getStringParametersFromInput(List<BizListItemData> list) {
		List<Map<String, Object>> maps = new ObjectMapper().convertValue(list, new TypeReference<List<Map<String, Object>>>() {});
		// StringBuilder appendAble = new StringBuilder("[");
		String collect = maps.stream()
				.map(a -> a.entrySet().removeIf(entry -> Objects.isNull(entry.getValue()))? a: Collections.EMPTY_MAP)
				.filter(a -> a.get("catalogId") != null)
				.filter(a -> a.get("productId") != null)
				.filter(a -> a.get("quantity") != null)
				.filter(a -> a.get("giftListId") != null)
				.map(a -> Joiner.on(",").withKeyValueSeparator(":").appendTo(new StringBuilder("{"), a).append("}"))
				.collect(Collectors.joining(",", "[", "]"));
		System.out.println(collect.toString());
		return collect.toString();
	}
}
