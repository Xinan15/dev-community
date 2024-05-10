package com.xinan.community.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
// @Configuration 注解是 Spring 提供的用于配置类的注解
// 配置类可以是第三方创建的 bean
public class AlphaConfig {

    @Bean
    // @Bean 注解是 Spring 提供的用于配置 bean 的注解
    // 含义是 下面的方法的返回值会被装配到 Spring 容器中

    public SimpleDateFormat simpleDateFormat(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
}
