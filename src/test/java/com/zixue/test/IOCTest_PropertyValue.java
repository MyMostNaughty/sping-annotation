package com.zixue.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.zixue.bean.Person;
import com.zixue.config.MainConfigOfPropertyValues;

public class IOCTest_PropertyValue {
	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);
	
	@Test
	public void test01(){
		printBeans(applicationContext);
		System.out.println("================================");
		
		Person person = (Person) applicationContext.getBean("person");
		System.out.println(person);
		System.out.println("==============================================");
		
		// 配置文件中的值，默认都加载到了环境变量中
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		String property = environment.getProperty("person.nickName");
		System.out.println(property);
		
		applicationContext.close();
	}

	private void printBeans(AnnotationConfigApplicationContext applicationContext1){
		// 获取ioc容器中所有bean对象
		String[] definitionNames = applicationContext1.getBeanDefinitionNames();
		for (String string : definitionNames) {
			System.out.println(string);
		}
	}
}
