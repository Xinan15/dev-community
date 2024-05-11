package com.xinan.community.community;

import com.xinan.community.community.dao.DiscussPostMapper;
import com.xinan.community.community.dao.UserMapper;
import com.xinan.community.community.entity.DiscussPost;
import com.xinan.community.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {
    @Autowired
    private UserMapper userMapper;
    // 将 UserMapper 注入进来

    @Autowired
    private DiscussPostMapper discussPostMapper;
    // 将 DiscussPostMapper 注入进来

    @Test
    public void testSelectUser() {
        User user = userMapper.selectById(101);
        System.out.println(user);

        user = userMapper.selectByName("liubei");
        System.out.println(user);

        user = userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user);
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("123456");
        user.setSalt("abc");
        user.setEmail("1234@gmail.com");
        user.setHeaderUrl("https://picsum.photos/200/300");
        user.setCreateTime(new Date());

        int rows = userMapper.insertUser(user);
        // 此处返回的是插入的行数
        System.out.println(rows);
        // 此处返回的是插入的 id，会自动生成
        System.out.println(user.getId());
    }

    @Test
    public void testUpdateUser() {
        int rows = userMapper.updateStatus(150, 1);
        System.out.println(rows);

        rows = userMapper.updateHeader(150, "https://picsum.photos/200/300");
        System.out.println(rows);

        rows = userMapper.updatePassword(150, "hello");
        System.out.println(rows);
    }

    @Test
    public void testSelectPosts() {
       List<DiscussPost> list = discussPostMapper.selectDiscussPosts(149, 0, 10);
       for(DiscussPost post : list) {
           System.out.println(post);
       }
       // 这里是一个增强的 for 循环，用于遍历集合
         // 增强 for 循环只能用于访问集合或数组中的元素，不能用于修改集合或数组中的元素
         // 语法：for(元素类型 元素变量 : 遍历对象) {循环体}
         // 相当于 for(int i = 0; i < list.size(); i++) {DiscussPost post = list.get(i); System.out.println(post);}

        int rows = discussPostMapper.selectDiscussPostRows(0);
        System.out.println(rows);

    }
}
