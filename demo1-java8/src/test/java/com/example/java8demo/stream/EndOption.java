package com.example.java8demo.stream;

import com.example.java8demo.pojo.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * foreach()                                            内部迭代
 * collect()                                            收集
 * boolean allMatch(Predicate<? super T> predicate);    检查是否匹配所有元素。
 * boolean anyMatch(Predicate<? super T> predicate);    检查是否至少匹配一个元素。
 * boolean noneMatch(Predicate<? super T> predicate);   检查是否没有匹配所有元素。
 * Optional<T> findFirst();                             返回当前流中的第一个元素。
 * Optional<T> findAny();                               返回当前流中的任意元素。
 * long count();                                        返回流中元素总数。
 * Optional<T> max(Comparator<? super T> comparator);   返回流中最大值。
 * Optional<T> min(Comparator<? super T> comparator);   返回流中最小值。
 * T reduce(T identity, BinaryOperator<T> accumulator); 可以将流中元素反复结合起来，得到一个值。 返回 T。这是一个归约操作。
 */
@SpringBootTest
public class EndOption {

	static List<User> list = new ArrayList<>();

	@BeforeAll
	static void beforeAll() {
		list.add(new User(1, "A"));
		list.add(new User(1, "A"));
		list.add(new User(2, "B"));
		list.add(new User(3, "C"));
		list.add(new User(4, "D"));
		new Scanner(System.in).nextInt();
	}

	/**
	 * foreach
	 */
	@Test
	void test1(){
		list.forEach(user -> System.out.println(user.getName()));
	}

	/**
	 * collect
	 */
	@Test
	void test2() {
		// ① toList
		List<String> l = list.stream().map(User::getName)
				.collect(Collectors.toList());

		// ② toSet
		Set<String> s = list.stream().map(User::getName)
				.collect(Collectors.toSet());
		// ③ toMap
		Map<String, User> map = list.stream()
				.collect(Collectors.toMap(User::getName, Function.identity(), (k1, k2) -> k2));
//		Map<String, Integer> map1 = list.stream()
//				.collect(Collectors.toMap(User::getName, User::getAge));
		Map<String, User> map2 = list.stream()
				.collect(Collectors.toMap(User::getName, Function.identity(), (k1, k2) -> k1));
		System.out.println(map);
		System.out.println(map2);
	}
}
