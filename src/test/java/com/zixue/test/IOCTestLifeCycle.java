package com.zixue.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zixue.config.MainConfigOfLifeCycle;

public class IOCTestLifeCycle {

	@Test
	public void test01(){
		//1. 创建ioc容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
		System.out.println("容器创建完成。。。。。");
//		applicationContext.getBean("car");
		//容器销毁
		applicationContext.close();
	}
}
