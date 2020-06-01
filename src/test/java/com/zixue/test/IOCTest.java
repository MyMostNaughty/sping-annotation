package com.zixue.test;

import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.ConfigurableEnvironment;

import com.zixue.bean.Person;
import com.zixue.config.MainConfig;
import com.zixue.config.MainConfig2;

public class IOCTest {
	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
	private void printBeans(AnnotationConfigApplicationContext applicationContext1){
		// 获取ioc容器中所有bean对象
		String[] definitionNames = applicationContext1.getBeanDefinitionNames();
		for (String string : definitionNames) {
			System.out.println(string);
		}
	}
	@Test
	public void testImport(){
		printBeans(applicationContext);
		Object bean1 = applicationContext.getBean("colorFactoryBean");
		Object bean2 = applicationContext.getBean("colorFactoryBean");
		System.out.println("bean1的类型："+bean1.getClass());
		System.out.println(bean1==bean2);
		Object bean3 = applicationContext.getBean("&colorFactoryBean");
		System.out.println("bean3的类型："+bean3.getClass());
	}

	@Test
	public void test03(){
		// 根据类型获取容器中所有该类的 id
		 String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
		 for (String string : namesForType) {
			 System.out.println(string);
		 }
		 System.out.println("==================================");
		 // 获取运行环境（ioc运行环境）
		 ConfigurableEnvironment environment = applicationContext.getEnvironment();
		 // 动态获取 环境变量的值 （ 操作系统名字）  Windows 8.1
		 String property = environment.getProperty("os.name");
		 System.out.println(property);  
		 
		 
		 // 根据类型获取容器中 所有的bean（对象）返回对象Map(id,Person对象)
		 Map<String, Person> personsMap = applicationContext.getBeansOfType(Person.class);
		 System.out.println(personsMap);
	}

	@Test
	public void test02(){
//		AnnotationConfigApplicationContext annotationConfig = new AnnotationConfigApplicationContext(MainConfig2.class);
		// 获得IOC容器中所有bean的定义的名词
//		String[] definitionNames = annotationConfig.getBeanDefinitionNames();
//		for (String string : definitionNames) {
//			System.out.println(string);
//		}
		System.out.println("ioc容器创建完成。。。。。。。");
//		//根据指定 id 获取实例对象（默认单例模式）
		Person bean = (Person) applicationContext.getBean("person");
		Person bean2 = (Person) applicationContext.getBean("person");
//		System.out.println(bean==bean2);// 默认值是true，如果给bean上加注解@Scope("prototype")则当前实例变成多例，结果返回false
	}
	
	@Test
	public void test01(){
		AnnotationConfigApplicationContext annotationConfig = new AnnotationConfigApplicationContext(MainConfig.class);
		// 获得IOC容器中所有bean的定义的名词
		String[] definitionNames = annotationConfig.getBeanDefinitionNames();
		for (String string : definitionNames) {
			System.out.println(string);
		}
	}
}
