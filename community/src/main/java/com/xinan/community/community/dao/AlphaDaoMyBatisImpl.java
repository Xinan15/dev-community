package com.xinan.community.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
// @Primary 注解是 Spring 提供的用于标识优先注入的注解
// 如果存在多个相同类型的 Bean，Spring 会优先注入标注了 @Primary 注解的 Bean
public class AlphaDaoMyBatisImpl implements AlphaDao{
    @Override
    public String select(){
        return "MyBatis";
    }
}
