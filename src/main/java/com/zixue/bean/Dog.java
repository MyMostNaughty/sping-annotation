package com.zixue.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class Dog {

	public Dog(){
		System.out.println("Dog......constructor........");
	}
	
	// 对象创建并赋值以后调用
	@PostConstruct
	public void init(){
		System.out.println("Dog.....@PostConstruct............");
	}
	
	// 容器关闭先会将bean移除，移除bean时调用的销毁方法
	@PreDestroy
	public void destory(){
		System.out.println("Dog.....@PreDestroy.......");
	}
}
