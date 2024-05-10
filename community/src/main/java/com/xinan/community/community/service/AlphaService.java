package com.xinan.community.community.service;


// Service 层 --> 业务逻辑层
// 用于处理业务逻辑

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
// @Service 注解是 Spring 提供的用于标识 Service 组件的注解
// Spring 容器，可以管理 bean 的生命周期，包括 实例化、初始化、销毁 等

@Scope("singleton")
// @Scope 注解是 Spring 提供的用于指定 bean 的作用域的注解
// singleton 单例模式，一个容器中只有一个实例，只有一个实例会被创建
// prototype 原型模式，每次从容器中获取 bean 时，都会创建一个新的实例

public class AlphaService {

    public AlphaService() {
        System.out.println("instantiated AlphaService");  // 实例化
    }

    @PostConstruct
    // @PostConstruct 注解是 Spring 提供的用于初始化的注解
    public void init() {
        System.out.println("initialised AlphaService");  // 初始化
    }

    @PostConstruct
    public void destroy() {
        System.out.println("destroyed AlphaService");  // 销毁
    }
}
