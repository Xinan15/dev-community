package com.xinan.community.community.service;

import com.xinan.community.community.dao.DiscussPostMapper;
import com.xinan.community.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// DiscussPostService 用于处理与  DiscussPost / 帖子 相关的业务逻辑

@Service
public class DiscussPostService {
    // Service 层是业务逻辑层，用于处理业务逻辑
    // Service 层通过调用 DAO 层来访问数据库
    // 在 DAO 层，我们定义了各种 Mapper 接口，用于操作数据库
    // 因此我们在 Service 层中，需要将对应的 Mapper 注入进来，从而调用 Mapper 中的方法
    @Autowired
    private DiscussPostMapper discussPostMapper;
    // 业务方法一：根据用户 id 查询对应的帖子
    // 返回 DiscussPost / 帖子 的集合
    public List<DiscussPost> findDiscussPosts(int userId, int offset, int limit) {
        // userId 定位到用户 / userId 为 0 时，查询所有用户
        // offset 为起始行，limit 为每页最大行数
        return discussPostMapper.selectDiscussPosts(userId, offset, limit);
    }

    // 业务方法二：根据用户 id 查询其对应的帖子数量
    public int findDiscussPostRows(int userId) {
        // 根据 userId 查询对应的帖子数量
        return discussPostMapper.selectDiscussPostRows(userId);
    }
}
