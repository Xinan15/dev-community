package com.xinan.community.community.dao;

import com.xinan.community.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

// 此处声明 DiscussPostMapper 接口，用于操作数据库
@Mapper
public interface DiscussPostMapper {

    // 此时，我们需要实现分页查询帖子的方法
    // 因此，返回值是一个集合，用于存放查询到的帖子，此时我们选择 List 集合
    // ` List<DiscussPost>` 表示一个 List 集合，其中存放的是 DiscussPost 类型的对象，这里的 DiscussPost 类型，就是我们定义的实体类

    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);
    // userId - 查询的用户 id
    // offset - 查询的起始行
    // limit - 查询的行数

    int selectDiscussPostRows(@Param("userId") int userId);
    // 查询帖子的行数
    // @Param("userId") - 用于给参数取别名，如果方法中只有一个参数，并且在<if>里使用，则必须加别名
    // 此处两个名字一样，但是在其他必要的情况下，需要区分别名

}
