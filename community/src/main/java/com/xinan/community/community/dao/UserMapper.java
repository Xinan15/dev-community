package com.xinan.community.community.dao;

// DAO - Data Access Object - 数据访问对象 --> 数据访问层
// 这里需要创建数据访问组件，对应数据库表，用于直接操作数据库
// 注意，这里只需要定义 Mapper 作为接口，是一个数据访问组件
// 这个接口不需要实现，MyBatis 会根据这个接口自动生成实现类
// 定义时，字段的首字母要答谢，后面加上 Mapper

// 在实现时，我们需要定义一个配置文件，定义每个操作对应的 SQL 语句
// 此处创建在 resources/mapper/user-mapper.xml 文件中

import com.xinan.community.community.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
// @Mapper 注解表示这是一个 MyBatis 的 Mapper 接口
// 我们需要在这里定义 CRUD 方法，MyBatis 会根据这个接口自动生成实现类
public interface UserMapper {

    // CRUD - Create, Read, Update, Delete - 增删改查

    // 查询
    User selectById(int id);                            // 根据 id 查询用户

    User selectByName(String username);                 // 根据用户名查询用户

    User selectByEmail(String email);                   // 根据邮箱查询用户

    // 插入
    int insertUser(User user);                          // 插入用户 --> 插入 User 对象

    // 更新/更改
    int updateStatus(int id, int status);               // 更新用户状态 --> '0-未激活; 1-已激活;'

    int updateHeader(int id, String headerUrl);         // 更新用户头像

    int updatePassword(int id, String password);        // 更新用户密码

}
