package com.zixue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zixue.bean.Person;
import com.zixue.config.MainConfig;

public class MainTest {

	public static void main(String[] args) {
		//使用配置的方式获取 spring容器中的bean
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
//		Person bean = (Person) applicationContext.getBean("person");
//		System.out.println(bean);
		
		// 使用注解方法获取 spring容器中的bean
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		// 1.使用类型获取bean
		Person bean = applicationContext.getBean(Person.class);
		System.out.println(bean);  //person [name=李四, age=20]
		// 找到Person类在IOC容器中的名字
		String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
		for (String string : namesForType) {
			System.out.println(string);  // 输出person, 可以证明 方法名作为id
		}
	}
}
