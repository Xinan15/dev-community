package com.xinan.community.community.service;

import com.xinan.community.community.dao.UserMapper;
import com.xinan.community.community.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    // UserService 用于处理与 User / 用户 相关的业务逻辑
    @Autowired
    // 调用 UserMapper 接口
    private UserMapper userMapper;

    // 业务方法：根据用户 id 查询用户
    // 返回 User / 用户 对象
    public User findUserById(int id) {
        return userMapper.selectById(id);
    }
}
