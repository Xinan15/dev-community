package com.xinan.community.community.entity;

// entity 目录用于存放实体类
// 定义 DiscussPost 实体类，对应数据库表 discuss_post，表示 帖子 的信息
// 建立完成 DiscussPost 实体类后：
// 1. 需要在 dao 目录下创建 DiscussPostMapper 接口，用于操作数据库
// 2. 需要在 resources/mapper 目录下创建 DiscussPostMapper.xml 文件，用于编写 SQL 语句

import java.util.Date;

public class DiscussPost {
    private int id;                     // 帖子的 id
    private int userId;                 // 发帖用户的 id
    private String title;               // 帖子的标题
    private String content;             // 帖子的内容
    private int type;                   // 帖子的类型 - 0-普通， 1-置顶
    private int status;                 // 帖子的状态 - 0-正常， 1-精华， 2-拉黑
    private Date createTime;            // 帖子的创建时间
    private int commentCount;           // 帖子的评论数量
    private double score;               // 帖子的分数

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "DiscussPost{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", createTime=" + createTime +
                ", commentCount=" + commentCount +
                ", score=" + score +
                '}';
    }
}
