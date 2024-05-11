package com.xinan.community.community.service;

import com.xinan.community.community.dao.DiscussPostMapper;
import com.xinan.community.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {
    @Autowired
    private DiscussPostMapper discussPostMapper;
    // 因为 Service 需要调用 Mapper，因此需要将 Mapper 注入进来
    // 因为目前 Mapper 中只有查询方法，因此在当前的 Service 中，我们只需要实现查询方法

    public List<DiscussPost> findDiscussPosts(int userId, int offset, int limit) {
        return discussPostMapper.selectDiscussPosts(userId, offset, limit);
    }
    // 此处的方法用于根据用户 id 查询帖子

    public int findDiscussPostRows(int userId) {
        return discussPostMapper.selectDiscussPostRows(userId);
    }
    // 此处的方法用于根据用户 id ，查询该用户的帖子数量




}
