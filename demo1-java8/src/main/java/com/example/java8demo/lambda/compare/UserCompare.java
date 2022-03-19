package com.example.java8demo.lambda.compare;

import com.example.java8demo.pojo.User;

import java.util.Comparator;

/**
 * This is a comparators.<br/>
 * comparators must be implements Comparator's compare method.<br/>
 * @see Boolean#compare(boolean, boolean)
 * @see Integer#compare(int, int)
 * @see String#compareTo(String)
 */
public class UserCompare {

	/**
	 * return -1 0 1.
	 * -1 -> <
	 *  0 -> ==
	 *  1 -> >
	 */
	public Comparator<String> stringComparator(){
		return new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		};
	}

	/**
	 * thenComparing()
	 * @return a comparator
	 */
	public Comparator<User> userComparator(){
		return new Comparator<User>(){
			@Override
			public int compare(User o1, User o2) {
				return 0;
			}
		}.thenComparing(new Comparator<User>(){
			@Override
			public int compare(User o1, User o2) {
				return 0;
			}
		}).thenComparing(new Comparator<User>(){
			@Override
			public int compare(User o1, User o2) {
				return 0;
			}
		});
	}
}
