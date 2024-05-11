package com.xinan.community.community.controller;


// controller 的作用是接收请求，处理请求，返回数据
// controller 可以省略访问路径

import ch.qos.logback.core.model.Model;
import com.xinan.community.community.entity.DiscussPost;
import com.xinan.community.community.service.DiscussPostService;
import com.xinan.community.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller

public class HomeController {
    // 调用 Service
    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/index",method = RequestMethod.GET)
    // 此时返回的是网页
    // 通过 Model 携带数据，将数据传递给模板
    public String getIndexPage(Model model){
        List<DiscussPost> list = discussPostService.findDiscussPosts(0,0,10);
        // 主页查询所有用户，因此 userId 为 0
        return "/index";
        // 此处返回的是 templates 目录下的 index.html
    }


}
