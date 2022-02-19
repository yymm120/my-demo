package com.example.java8demo.stream;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 1.创建Stream
 */
@SpringBootTest
public class CreateStream {

	int[] intArray = {1,2,3};

	/**
	 * Java8 中的 Collection 接口被扩展，提供了两个获取流的方法,这两个方法是default方法,
	 * ① default Stream stream() : 返回一个顺序流。
	 * ② default Stream parallelStream() : 返回一个并行流。
	 * test:4ms
	 */
	@Test
	void test1CollectionToStream(){
		List<Integer> integerList = new ArrayList<>();
		integerList.add(1);
		integerList.add(2);
		// ① 顺序流
		Stream<Integer> stream = integerList.stream();
		// ② 并行流
		Stream<Integer> stream1 = integerList.parallelStream();
	}


	/**
	 * Java8中的Array数组提供了一个stream()方法，应用于基本类型的数组。
	 * test: 100ms
	 */
	@Test
	void test2ArrayToStream(){
		IntStream stream = Arrays.stream(intArray);
	}


	/**
	 * Java8的Stream提供了三个静态方法of()、iterate()、generate()
	 * ① of()方法，它可以接收任意个参数。
	 * ② iterate()方法，它用于创建无限流。
	 * ③generate()方法，它用于创建无限流。
	 * 注意：使用无限流，必须和limit配合截断，否则会无限创建下去。
	 * test:7ms
	 */
	@Test
	void test3ValuesToStream(){
		// ① of()
		Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8);
		// ② generate()
		Stream<Double> stream = Stream.generate(Math::random).limit(5);
		// ③ iterate()
		List<Integer> collect = Stream.iterate(0,i -> i + 1).limit(5).collect(Collectors.toList());
	}

}
