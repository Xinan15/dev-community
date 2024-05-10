package com.xinan.community.community.controller;

import org.springframework.stereotype.Controller;

@Controller
// 当我们把 @Controller 注解加在类上时，Spring 会自动扫描这个类，并把它注册为 Bean
// 类似 @Controller 注解，还有 @Service、@Repository、@Component 注解等
// 这几个注解都是 源于 @Component ， 只是为了更好的区分不同的 Bean 的作用
// 当我们在一个 java class 中加上这些注解时，他们就会被注册为 bean
// 进而可以被 Spring 容器管理，会被项目自动扫描到
public class AlphaController {
    
}
