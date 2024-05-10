package com.xinan.community.community.dao;

// DAO - Data Access Object - 数据访问对象
// 数据访问层 --> 用于访问数据库 --> 通常是一个接口
// 需要被实现类实现
// 常通过 Hibernate 或 MyBatis 框架实现

public interface AlphaDao {

        String select();    // 访问数据库，查询一个字符串
}
