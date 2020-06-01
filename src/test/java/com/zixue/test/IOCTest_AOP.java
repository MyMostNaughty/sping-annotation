package com.zixue.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zixue.aop.MathCalculator;
import com.zixue.config.MainConfigOfAOP;

public class IOCTest_AOP {

	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
		
		//1. 不要自己创建对象(只有调用ioc容器中的对象，切面才能起到效果。一个是自己new的对象，一个是加上@Bean注解注入ioc容器中的对象)
//		MathCalculator mathCalculator = new MathCalculator();
//		mathCalculator.div(1, 1);
		MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
		mathCalculator.div(1, 1);
		
		applicationContext.close();
		
	}
	
}
