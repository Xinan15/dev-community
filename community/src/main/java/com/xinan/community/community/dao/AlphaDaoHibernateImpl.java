package com.xinan.community.community.dao;

import org.springframework.stereotype.Repository;

@Repository("alphaHibernate")
// @Repository 注解是 Spring 提供的用于标识 DAO 组件的注解
// 用于标识一个 DAO 组件，表示它是一个数据访问层组件
// 即，标记用于访问数据库的组件，增加注解后，Spring 会自动实例化这个类

public class AlphaDaoHibernateImpl implements AlphaDao {
    // AlphaDao 是一个接口
    // AlphaDaoHibernateImpl 是 AlphaDao 的实现类
    // 通过 Hibernate 框架实现 AlphaDao 接口

    @Override
    public String select() {
        return "Hibernate";
    }
}
