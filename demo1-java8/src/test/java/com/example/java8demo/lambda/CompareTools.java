package com.example.java8demo.lambda;

import com.example.java8demo.lambda.compare.UserCompare;
import com.example.java8demo.pojo.User;
import org.assertj.core.util.Strings;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.function.Function;


/**
 * 参数必须是一个比较器
 * @apiNote
 *   1. {@code sort(new Comparator(){})} {@link Comparator}<br/>
 *   2. {@code sort(String::compareTo)}  {@link Comparable#compareTo(java.lang.Object)}<br/>
 *   3. {@code sort(Comparator.comparing(Comparable))} {@link Comparator#comparing(Function)}<br/>
 * @see CompareTools#testA3_object_compare()
 */
@SpringBootTest
public class CompareTools {
	private static User user;
	private static final Random random = new Random();
	private static final List<User> users = new ArrayList<>();
	private static final Map<String, User> userMap = new HashMap<>();

	@BeforeAll
	static void initData(){
		int count = random.nextInt(100);
		for (int i = 0; i < count; i++) {
			User user = new User(random.nextInt(90), String.valueOf(random.nextInt(9000)));
			users.add(user);
			userMap.put(user.getName(),user);
		}
	}

	/**
	 * 1. BooleanCompare
	 */
	@Test
	void testA1_boolean_compare(){

	}

	/**
	 * 2. IntegerCompare
	 */
	@Test
	void testA2_integer_compare(){

	}

	/**
	 * 3. ObjectCompare
	 */
	@Test
	void testA3_object_compare(){
		List<String> lists = Arrays.asList("1", "c", "q", "a", "b");
		// ①
		lists.sort(String::compareTo);
		System.out.println("lists.sort(String::compareTo) -> ");
		lists.forEach(System.out::println);
		// ②
		lists.sort(new UserCompare().stringComparator());
		lists.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		System.out.println("lists.sort(String::compareTo) -> ");
		lists.forEach(System.out::println);
		// ③
		lists.sort((o1, o2) -> o1.compareTo(o2));
		System.out.println("lists.sort(String::compareTo) -> ");
		lists.forEach(System.out::println);
		// ④
		lists.sort(Comparator.naturalOrder());
		System.out.println("lists.sort(String::compareTo) -> ");
		lists.forEach(System.out::println);
		// ⑤
		lists.sort(Comparator.comparing(String::toString));
	}
}
