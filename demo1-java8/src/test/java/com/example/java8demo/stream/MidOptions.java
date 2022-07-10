package com.example.java8demo.stream;

import com.example.java8demo.lambda.compare.UserCompare;
import com.example.java8demo.pojo.User;
import com.google.common.base.Stopwatch;
import lombok.SneakyThrows;
import lombok.var;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import com.google.common.collect.Comparators;

/**
 * 中间操作
 */
@SpringBootTest
public class MidOptions {

	static List<User> list = new ArrayList<>();
	static Map<String, User> map;
	static Random random = new Random();

	/**
	 * Stream的中间操作是不会执行的，我们可以写一系列的中间操作，它只作标记，它会在终端操作时执行。
	 */
	@BeforeAll
	static void beforeAll() {
		for (int i = 0; i < random.nextInt(5000); i++) {
			User user = new User(random.nextInt(90), String.valueOf(random.nextInt(999999)));
			list.add(user);
		}
		map = list.stream()
				.collect(Collectors.toMap(User::getName, x -> x));
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
		List<User> temp = new ArrayList<User>();
		for (int i = 0; i < new Random().nextInt(20); i++) {
			temp.add(new User(i, "" + i));
		}
		list.get(0).setUsers(temp);
		List<User> users = list.stream()
				.flatMap(x -> x.getUsers().stream())
				.collect(Collectors.toList());
		users.forEach(System.out::println);
	}

	/**
	 * method: reduce
	 */
	@SneakyThrows
	@Test
	void test7Reduce1(){
		Stopwatch timer = Stopwatch.createStarted();
		HashMap<String, User> userMap3 = new HashMap<>();
		list.forEach(x -> {
			userMap3.put(x.getName(), x);
		});
		timer.stop();
		long n1 = timer.elapsed(TimeUnit.MICROSECONDS);
		System.out.printf("forEach -> %d %n", n1);


		// reduce1
		timer.start();
		Map<String, User> userMap = list
				.stream()
				.map(kv -> {
					Map<String, User> map1 = new HashMap<String, User>() {{
						put(kv.getName(), kv);
					}};
					return map1;
				})
				.reduce(new HashMap<>(), (acc, next) -> {
					acc.putAll(next);
					return acc;
				});
		timer.stop();
		long n2 = timer.elapsed(TimeUnit.MICROSECONDS) - n1;
		System.out.printf("stream -> %d %n", n2);


		// reduce2
		timer.start();
		Map<String, User> userMap1 = list
				.stream()
				.map(kv -> Collections.singletonMap(kv.getName(), kv))
				.reduce(new HashMap<>(), (acc, next) -> {
					acc.putAll(next);
					return acc;
				});
		timer.stop();
		long n3 = timer.elapsed(TimeUnit.MICROSECONDS) - n2;
		System.out.printf("stream2 -> %d %n", n3);
	}


	@Test
	void testA8_parallel(){
		List<User> users = list.stream()
				.parallel()
				.sorted(new Comparator<User>() {
					@Override
					public int compare(User o1, User o2) {
						return o1.getName().compareTo(o2.getName());
					}
				})
				.collect(Collectors.toList());

		List<User> users1 = list.stream()
				.parallel()
				.sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
				.collect(Collectors.toList());


		List<User> users2 = list.stream()
				.parallel()
				.sorted(Comparator.comparing(User::getName))
				.collect(Collectors.toList());
		users.forEach(System.out::println);
		System.out.println();
		users1.forEach(System.out::println);
		System.out.println();
		users2.forEach(System.out::println);
	}
}
