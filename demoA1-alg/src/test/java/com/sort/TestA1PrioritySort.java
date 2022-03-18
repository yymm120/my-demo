package com.sort;

import com.sort.data.Student;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.var;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.comparator.Comparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;


@SpringBootTest
public class TestA1PrioritySort {
	private static List<Student> list;
	private static int index;

	@BeforeAll
	static void initData(){
		Random random = new Random();
		int cont = random.nextInt(30);
		list = new ArrayList<>();
		for (int i = 0; i < cont; i++) {
			boolean isDiscontinued = random.nextBoolean();
			boolean isCallForPricing = random.nextBoolean();
			int age = random.nextInt(90);
			String name = String.valueOf(random.nextInt(10000));
			String sex = String.valueOf(random.nextInt(10000));
			list.add(new Student(isDiscontinued, isCallForPricing, name, age, sex));
		}
	}



	/**
	 * method: thenComparing()
	 * 先对discontinued排序，再对callForPricing排序
	 */
	@Test
	void test_thenComparing_sort(){
		int compare = Boolean.compare(true, false);
		System.out.println(compare);

		list.sort(((Comparator<Student>) (o1, o2) ->
				Boolean.compare(o1.isDiscontinued(), o2.isDiscontinued())).thenComparing((o1, o2) ->
				Boolean.compare(o1.isCallForPricing(), o2.isCallForPricing())));
		list.forEach(System.out::println);
	}


	/**
	 * method:
	 * compare
	 * equals
	 * reversed
	 * thenComparing
	 * thenComparingInt
	 * thenComparingLong
	 * thenComparingDouble
	 * reverseOrder
	 * naturalOrder
	 * nullsFirst
	 * nullsLast
	 * comparing
	 * comparingInt
	 * comparingLong
	 * comparingDouble
	 */

}
