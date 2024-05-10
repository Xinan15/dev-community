package com.xinan.community.community;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

// @SpringBootApplication 注解是 Spring Boot 项目的核心注解，主要目的是开启自动配置。
// 它会自动扫描当前包及其子包下的所有类
// 自动扫描查找包内的所有 @Component 注解（@Component、@Service、@Repository、@Controller）
// 这些被 @Component 注解的类会被注册为 Bean

public class CommunityApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommunityApplication.class, args);
	}

}
