package com.zixue.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import com.alibaba.druid.pool.DruidDataSource;
import com.zixue.bean.Yellow;

/*
 * Profile:
 *       Spring为我们提供的可以根据当前环境，动态的激活和切换一系列bean（组件）的功能
 * 比如：
 * 开发环境、测试环境、生产环境；
 * 数据源：（/A）（/B）（/C）；   
 * 
 * @Profile：指定组件在哪个环境的情况下才能被注册到容器中,不指定:在任何环境下都能注册这个组件
 * 
 * 1）、加了环境表示的bean，只有这个环境被激活的时候才能注册到容器中,默认是default
 * 2）、写在配置类上，只有是指定的环境的时候（applicationContext.getEnvironment().setActiveProfiles("dev");），整个配置类里面的所有配置才能开始生效;(见IOCTest_Profile类)
 * 3）、没有标注环境表示的bean，在任何环境下都是加载的；
 */
@Profile("test")
@PropertySource("classpath:/dbconfig.properties")
@Configuration
public class MainConfigOfProfile implements EmbeddedValueResolverAware{

	@Value("${db.user}")
	private String user;
	
	private String driverClass;
	
//	@Profile("test")
	@Bean
	public Yellow yellow(){
		return new Yellow();
	}
	
	@Profile("test")
	@Bean("testDataSource")
	public DataSource dataSourceTest(@Value("${db.password}")String pwd) throws Exception{
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUsername(user);
		dataSource.setPassword(pwd);
		dataSource.setUrl("jdbc://mysql://localhost:3306/test");
		dataSource.setDriverClassName(driverClass);
		return dataSource;
	}
	@Profile("dev")
	@Bean("devDataSource")
	public DataSource dataSourceDev(@Value("${db.password}")String pwd) throws Exception{
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUsername(user);
		dataSource.setPassword(pwd);
		dataSource.setUrl("jdbc://mysql://localhost:3306/book");
		dataSource.setDriverClassName(driverClass);
		return dataSource;
	}
	@Profile("prod")
	@Bean("prodDataSource")
	public DataSource dataSourceProd(@Value("${db.password}")String pwd) throws Exception{
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUsername(user);
		dataSource.setPassword(pwd);
		dataSource.setUrl("jdbc://mysql://localhost:3306/books");
		dataSource.setDriverClassName(driverClass);
		return dataSource;
	}
	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		this.driverClass = resolver.resolveStringValue("${db.driverClass}");
	}
}
