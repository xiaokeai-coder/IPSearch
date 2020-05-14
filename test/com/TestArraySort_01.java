package com;

import java.util.Arrays;

public class TestArraySort_01 {

	public static void main(String[] args) {
		/**
		 * int类型
		 * 
		 * Integer String Date 都能排序 因为 都实现了 Comparable接口
		 * 
		 * 数字 从小到大
		 * 
		 * String 每位的ASCII码
		 * 
		 * 日期 : 自然日期 (昨天,今天,明天)
		 */
		int[] intArray = { 10, 9, 100, 99, 201 };

		Arrays.sort(intArray);

		for (int i : intArray) {
			System.out.println(i);
		}

		/**
		 * 对象排序
		 */

		User u1 = new User(19, "张三1");
		User u2 = new User(12, "张三2");
		User u3 = new User(29, "张三3");
		User u4 = new User(14, "张三4");

		User[] userArray = { u1, u2, u3, u4 };
		Arrays.sort(userArray);
		for (User user : userArray) {
			System.out.println(user);
		}
	}
}

class User implements Comparable<User> {
	private int age;
	private String name;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [age=" + age + ", name=" + name + "]";
	}

	@Override
	public int compareTo(User o) {
		return this.age - o.age;
	}

	
}
