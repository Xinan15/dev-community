package com.xinan.community.community;

import com.xinan.community.community.dao.AlphaDao;
import com.xinan.community.community.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
// @SpringBootTest 注解是 Spring Boot 提供的用于测试的注解
@ContextConfiguration(classes = CommunityApplication.class)
// @ContextConfiguration 注解是 Spring 提供的用于测试的注解
// 以 CommunityApplication 为配置类

public class CommunityApplicationTests implements ApplicationContextAware{

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// 此处为一个 set 方法，传入了一个类型为 ApplicationContext 的参数，名字是 applicationContext
		// 此时会传入 Spring 容器的上下文	
		this.applicationContext = applicationContext;
	}

	@Test
	public void testApplicationContext() {
		System.out.println(applicationContext);
		// 打印出 Spring 容器的上下文
		AlphaDao alphaDao = applicationContext.getBean(AlphaDao.class);
		// getBean 通过类型获取 Bean
		System.out.println(alphaDao.select());
		alphaDao = applicationContext.getBean("alphaHibernate", AlphaDao.class);
		// getBean 通过名字和类型获取 Bean
		System.out.println(alphaDao.select());
	}

	@Test
	public void testBeanManagement() {
		// 测试 bean 的管理
		AlphaService alphaService = applicationContext.getBean(AlphaService.class);
		System.out.println(alphaService);

		alphaService = applicationContext.getBean(AlphaService.class);
		System.out.println(alphaService);
	}

	@Test
	public void testBeanConfig() {
		// 测试 bean 的配置
		SimpleDateFormat simpleDateFormat = applicationContext.getBean(SimpleDateFormat.class);
		System.out.println(simpleDateFormat.format(new Date()));
	}

	// 以上的测试方式，是直接通过 applicationContext.getBean() 方法获取 Bean
	// 但是，Spring 提供了另一种方式，也就是 Spring 框架的关键特性：依赖注入（DI）
	// 依赖注入是 Spring 框架的核心，是 Spring 容器管理 Bean 的方式

	// 例如，上面我们想要获取 AlphaDao，是通过 alphaDao = applicationContext.getBean("alphaHibernate", AlphaDao.class); 来获取的
	// 使用依赖注入，我们可以直接在属性上添加 @Autowired 注解，Spring 会自动注入 Bean
	@Autowired
	@Qualifier("alphaHibernate")
	// 因为此时有两个 AlphaDao 类型的 Bean
	// 我们通过 @Qualifier 注解指定了要注入的 Bean 的名字
	public AlphaDao alphaDao;

	// 通过 @Autowired 注解，将 AlphaDao 注入到 alphaDao 属性中
	@Autowired
	public AlphaService alphaService;
	@Autowired SimpleDateFormat simpleDateFormat;

	@Test
	public void testDI() {
		// 测试依赖注入 - Dependency Injection
		System.out.println(alphaDao);
		System.out.println(alphaService);
		System.out.println(simpleDateFormat);
	}
}
