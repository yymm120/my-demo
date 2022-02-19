package com.example.java8demo.stream;

import com.example.java8demo.pojo.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 中间操作
 */
@SpringBootTest
public class MidOptions {

	static List<User> list = new ArrayList<>();

	/**
	 * Stream的中间操作是不会执行的，我们可以写一系列的中间操作，它只作标记，它会在终端操作时执行。
	 */
	@BeforeAll
	static void beforeAll() {
		list.add(new User(1, "A"));
		list.add(new User(1, "A"));
		list.add(new User(2, "B"));
		list.add(new User(3, "C"));
		list.add(new User(4, "D"));
	}



	/**
	 * distinct()去重，stream会自动帮我们生成hashcode和equal方法。
	 * 实体类的属性都已经实现了这两个方法，比如int、String等。
	 */
	@Test
	void test1Distinct(){
		// distinct()去重
		list.stream()
				.distinct()
				.forEach(x-> System.out.println(x.getAge()));
	}


	/**
	 * filter()
	 */
	@Test
	void test2Filter(){
		// filter()过滤
		list.stream()
				.filter(user -> user.getAge() > 3)
				.forEach(x -> System.out.println(x.getName()));
	}


	/**
	 * sorted()
	 */
	@Test
	void test3Sorted(){
		// sorted()排序
		list.stream()
				.sorted(Comparator.comparing(User::getAge))
				.forEach(x -> System.out.println(x.getName()));
	}

	/**
	 * limit()
	 */
	@Test
	void test4Limit(){
		// limit()截断
		list.stream()
				.sorted(Comparator.comparing(User::getAge).reversed())
				.limit(1)
				.forEach(x -> System.out.println(x.getName()));
	}


	/**
	 * skip()
	 */
	@Test
	void test5Skip(){
		// skip()跳过
		list.stream()
				.sorted(Comparator.comparing(User::getAge).reversed())
				.skip(list.size() - 1)
				.forEach(x -> System.out.println(x.getName()));

	}


	/**
	 * map()
	 */
	@Test
	void test6Map(){
		// map()映射
		list.stream()
				.map(user -> "欢迎" + user.getName())
				.forEach(x -> System.out.println(x.getClass()+ "\t" + x));
	}


	/**
	 * flatMap()
	 */
	@Test
	void test7FlatMap(){

	}

	/**
	 *
	 */
	@Test
	void test7Reduce(){

	}
}
