package com.xinan.community.community.service;

import com.xinan.community.community.dao.UserMapper;
import com.xinan.community.community.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User findUserById(int id) {
        return userMapper.selectById(id);
    }
    // 此处的方法用于根据用户 id 查询用户
}
