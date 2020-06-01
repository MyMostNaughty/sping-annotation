package com.zixue.bean;

import org.springframework.beans.factory.annotation.Value;

public class Person {

	/*
	 * 使用@Value赋值：
	 * 1.基本数值
	 * 2.可以写SpEl: #{}
	 * 3.可以写${}：取出配置文件【.properties】中的值（在运行环境变量里面的值（配置文件中值都会到环境变量中存储））
	 */
	@Value("")
	private  String name;
	@Value("#{20-3}")
	private Integer age;
	@Value("${person.nickName}")
	private String nickName;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", nickName=" + nickName + "]";
	}
	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
