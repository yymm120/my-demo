package com.example.java8demo.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

	private int age;
	private String name;

	private List<User> users;

	public User(int age, String name) {
		this.age = age;
		this.name = name;
	}
}

