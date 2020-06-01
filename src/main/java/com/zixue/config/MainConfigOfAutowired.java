package com.zixue.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zixue.bean.Car;
import com.zixue.bean.Color;
import com.zixue.dao.BookDao;

/**
 * 自动装配：
 *      Spring利用依赖注入（DI），完成对IOC容器中各个组件的依赖关系赋值
 * 
 * 1）、@Autowried：自动注入
 *       1）、默认优先按照类型去容器中找对应的组件：applicationContext.getBean(BookDao.class);
 *       2）、如果找到多个相同类型的组件，再将属性的名称(BookDao bookDao  中的bookDao就是属性名称==ioc容器中的id值)作为组件的id去ioc容器中查找
 *                             applicationContext.getBean("bookDao");
 *       3）、也可以用@Qualifier("bookDao")，使用@Qualifier指定需要装配的组件的id，而不是使用属性名
 *       4）、自动装配@Autowired默认一定要将属性赋值好，没有就会报错；
 *           可以使用@Autowired(required=false);
 *       5）、@Primary（Spring提供）：让Spring进行自动装配的时候，默认使用首选的bean,
 *                               也可以继续使用@Qualifier指定需要装配的bean的名字
 *       BookService{
 *          @Autowired
 *       	BookDao bookDao
 *       }
 *       
 * 2）、Spring还支持使用@Resource(JSR250)和@Inject(JSR330)，【这两个都是java规范注解】
 *       @Resource：
 *           可以和@Autowired一样实现自动装配功能，默认是按组件属性名称进行装配
 *           没有支持@Primary功能，也没有支持@Autowired中的(required=false)功能
 *       @Inject：
 *           需要导入javax.inject的包，和@Autowired的功能一样。
 *            可以支持@Primary功能，也没有支持@Autowired中的(required=false)功能
 * @Autowried：Spring定义的；  @Resource，@Inject：都是java规范
 * 
 * AutowiredAnnotationBeanPostProcessor：解析完成自动装配功能；
 * 
 * 3）、@Autowored：构造器、参数、方法、属性；（这些位置都能标注@Autowired）都是从ioc容器中获取组件的值
 *      1）、[标注在方法位置]：@Bean+方法参数；参数从容器中获取； 默认不写@Autowired 效果是一样的，都能自动装配 
 *      2）、[标注在构造器]：如果组件只有一个有参构造器，这个有参构造器的@Autowired可以省略，参数位置的组件还是可以自动从容器中获取
 *      3）、放在参数位置；
 * 
 * 4）、自定义组件想要使用Spring容器底层的一些组件:（ApplicationContext,BeanFactory,xxxx）;
 *     自定义组件底层xxxAware：在创建对象的时候，会调用接口规定的方法，注入相关组件。可参考：Aware
 *     把Spring底层一些组件注入到自定义的Bean中；
 *     xxxAware：功能使用xxxAwareProcessor;
 *         ApplicationContextAware---->> ApplicationContextAwareProcessor
 */
@Configuration
@ComponentScan({"com.zixue.service","com.zixue.dao","com.zixue.controller","com.zixue.bean"})
public class MainConfigOfAutowired {

	@Primary
	@Bean("bookDao2")
	public BookDao bookDao(){
		BookDao bookDao = new BookDao();
		bookDao.setLable("2");
		return bookDao;
	}
	
	/*
	 * @Bean标注的方法创建对象的时候，方法参数的值从容器中获取
	 */
	@Bean
	public Color color(Car car){
		Color color  = new Color();
		color.setCar(car);
		return color;
	}
	
}
