package com.zixue.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zixue.bean.Person;

//使用@PropertySource读取配置文件中的k/v保存到运行环境的变量中;加载完外部的配置文件以后使用${}取出配置文件的值
@PropertySource(value={"classpath:/person.properties"})
@Configuration
public class MainConfigOfPropertyValues {

	@Bean
	public Person person(){
		return new Person();
	}
}
