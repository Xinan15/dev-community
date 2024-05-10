package com.xinan.community.community.service;

// Service 层 --> 业务逻辑层 --> 用于处理业务逻辑
// Controller 调用 Service
// Service  调用 Dao

import com.xinan.community.community.dao.AlphaDao;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
// @Scope 用于指定 bean 的作用域
// singleton 单例模式 / prototype 原型模式

public class AlphaService {

    // 因为 Service 需要调用 Dao，所以此处需要注入 Dao 到 Service
    @Autowired
    // @Autowired 注解是 Spring 提供的用于依赖注入的注解
    // @Autowired 注解告诉 Spring 要将 alphaDao 字段设置为 Spring 容器中符合 AlphaDao 类型的 Bean 实例

    private AlphaDao alphaDao;

    // 依赖注入后，可以调用 AlphaDao 的 select 方法
    public String find() {
        return alphaDao.select();
    }
}
