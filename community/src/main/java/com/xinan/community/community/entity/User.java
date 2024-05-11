package com.xinan.community.community.entity;

import java.util.Date;

// entity 目录用于存放实体类
// 这类实体类与数据库表一一对应，作用是封装数据库表中的字段

// 例如，数据库中有一个名为 user 的表，那么我们可以在 entity 目录下创建一个 User 类，用于封装 user 表中的字段
// 此时，User 变成了一个实体类，其中每一个实例，都对应数据库 user 表中的一行数据，即某一个用户的信息
// 在 User 实体类中，我们可以定义 user 表中的字段，例如 id, username, password, email 等，他们对应数据库 user 表中的字段（列）/（属性）

// 此处 User 是一个实体类，对应数据库表 user，在定义时首字母大写
// 同时，我们可以定义 getter 和 setter 方法，用于获取和设置这些字段的值（操作这些字段）

// 在定义了实体类之后：
// 1. 我们需要在 dao 目录下创建一个对应的 Mapper 接口，用于操作数据库
// 此时的 Mapper 是一个接口，详细定义了对数据库操作的方法，这些方法直接对应于SQL语句或存储过程，如增删改查
// 2. 我们需要在 resources/mapper 目录下创建一个对应的 Mapper.xml 文件，用于编写 SQL 语句

public class User {
    private int id;
    private String username;
    private String password;
    private String salt;
    private String email;
    private int type;
    private int status;
    private String activationCode;
    private String headerUrl;
    private Date createTime;

    // 选中代码后，右键，可以选择 Generate -> Getter and Setter 自动生成 getter 和 setter 方法

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getHeaderUrl() {
        return headerUrl;
    }

    public void setHeaderUrl(String headerUrl) {
        this.headerUrl = headerUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    // 生成 toString 方法，将表中的字段转换为字符串，方便打印对象信息
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", email='" + email + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", activationCode='" + activationCode + '\'' +
                ", headerUrl='" + headerUrl + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
