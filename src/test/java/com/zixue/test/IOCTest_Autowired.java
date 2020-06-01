package com.zixue.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zixue.Service.BookService;
import com.zixue.bean.Boss;
import com.zixue.bean.Car;
import com.zixue.bean.Color;
import com.zixue.config.MainConfigOfAutowired;
import com.zixue.dao.BookDao;

public class IOCTest_Autowired {

	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
		BookService bookService = applicationContext.getBean(BookService.class);
		System.out.println(bookService);
		
//		BookDao bookDao = applicationContext.getBean(BookDao.class);
//		System.out.println(bookDao);
		
		System.out.println("============================================");
		Boss boss = applicationContext.getBean(Boss.class);
		System.out.println(boss);
		Car car = applicationContext.getBean(Car.class);
		System.out.println(car);
		System.out.println("==================================================");
		
		Color color = applicationContext.getBean(Color.class);
		System.out.println(color);
		
		applicationContext.close();
		
	}
	
}
