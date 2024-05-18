package com.xinan.community.community.controller;


import com.xinan.community.community.entity.DiscussPost;
import com.xinan.community.community.entity.Page;
import com.xinan.community.community.entity.User;
import com.xinan.community.community.service.DiscussPostService;
import com.xinan.community.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
// controller 的作用是接收请求，处理请求，返回数据
// controller 可以省略访问路径，下面直接调用方法即可

public class HomeController {
    // 1. 接收请求，调用 Service
    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    // 2. 处理请求，返回数据
    // GET 请求，访问首页
    @RequestMapping(path = "/index", method = RequestMethod.GET)
    // 此时返回的是网页
    // 通过 Model 携带数据，将数据传递给模板
    public String getIndexPage(Model model, Page page) {
        // 方法调用前，SpringMVC 会自动实例化 Model 和 Page，并将 Page 注入 Model
        // 注入到 Model 中后，thymeleaf 便能够访问 Page 对象中的数据
        // 计算当前页的起始行
        page.setRows(discussPostService.findDiscussPostRows(0));
        // 设置分页路径
        page.setPath("/index");
        // 查询前 10 条帖子
        // 主页查询所有用户，因此 userId 为 0
        List<DiscussPost> list = discussPostService.findDiscussPosts(0, 0, 10);
        // 将帖子和用户信息封装到 map 中 - 每个映射都包含一个讨论帖子和创建该帖子的用户
        List<Map<String, Object>> discussPosts = new ArrayList<>();
        if (list != null) {
            for (DiscussPost post : list) {
                Map<String, Object> map = new HashMap<>();
                map.put("post", post);
                User user = userService.findUserById(post.getUserId());
                map.put("user", user);
                discussPosts.add(map);
            }
        }
        // 将这个列表添加到模型中，以便在视图层 index.html 模板中使用。
        // 此处返回的是模版的路径，即 templates 目录下的 index.html，此处直接写 index 即可
        model.addAttribute("discussPosts", discussPosts);
        return "/index";
    }
}