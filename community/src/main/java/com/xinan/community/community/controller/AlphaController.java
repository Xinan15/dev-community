package com.xinan.community.community.controller;

import com.xinan.community.community.service.AlphaService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
// @Controller / @Service / @Repository 都是 @Component 的衍生注解
// 用于对不同层的组件进行标识，被注解的类会被 Spring 扫描并创建 Bean，放入 Spring 容器中托管

@RequestMapping("/alpha")
// @RequestMapping 注解用于指定访问路径

// Controller 调用 Service
public class AlphaController {

    @Autowired
    private AlphaService alphaService;

    @RequestMapping("/hello")
    @ResponseBody
    // http://localhost:8080/community/alpha/hello
    public String sayHello() {
        return "Hello Spring Boot.";
    }

    @RequestMapping("/data")
    @ResponseBody
    // http://localhost:8080/community/alpha/data
    public String getData() {
        return alphaService.find();
    }
    // 此处 Controller 层调用 Service 层的 find 方法
    // 而 Service 层的 find 方法调用 Dao 层的 select 方法
    // Controller 层再接收 Service 层返回的数据并返回给浏览器

    @RequestMapping("/http")
    // response 直接可以返回数据，此处不需要 @ResponseBody 注解
    // http://localhost:8080/community/alpha/http
    public void http(HttpServletRequest request, HttpServletResponse response) {
        // 获取请求数据
        // getMethod 和 getServletPath 构成了 请求行
        System.out.println(request.getMethod());
        // getMethod() 方法返回请求方式
        System.out.println(request.getServletPath());
        // getServletPath() 方法返回请求路径

        // Enumeration 这里构成了 请求头
        Enumeration<String> enumeration = request.getHeaderNames();
        while(enumeration.hasMoreElements()) {      // 遍历是否有下一个元素
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name + ": " + value);
        }

        // 获取请求参数
        System.out.println(request.getParameter("code"));
        // http?code=10086 / http?code=10086&name=jack
        // ? 后面的是请求参数，多个参数用 & 连接

        // response 是用来向浏览器返回响应数据的对象
        // 返回响应数据
        response.setContentType("text/html;charset=utf-8");     // 返回网页
        try{
            PrintWriter writer = response.getWriter();
            writer.write("<h1>Coding Community</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // writer 需要有对应的 close 方法
        response.setStatus(404);                                // 返回状态码
    }

    // 浏览器向服务器发送请求时，请求数据有两种方式：GET 和 POST
    // GET 请求
    // 例如，查询 /students?current=1&limit=20，意思是，查询第一页的 20 个学生
    @RequestMapping(path = "/students", method = RequestMethod.GET)
    // http://localhost:8080/community/alpha/students?current=1&limit=20
    // path 指定请求路径，method 指定请求方式

    @ResponseBody
    // 可写成
    // public String getStudents(int current, int limit) {
    // 此时，current 获取请求参数 current 的值，limit 获取请求参数 limit 的值
    // 只要参数名和方法参数名一致，就会自动赋值

    // 但在此使用 @RequestParam 注解，可以指定参数名
    public String getStudents(
        @RequestParam(name = "current", required = false, defaultValue = "1") int current,
        @RequestParam(name = "limit", required = false, defaultValue = "10") int limit){
            System.out.println(current);
            System.out.println(limit);
            return "some students";
        }

        // /student/123 -> 查询学生 id = 123 --> 此时参数在路径中
    @RequestMapping(path = "/student/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id) {
        // @PathVariable 注解用于获取路径中的参数
        System.out.println(id);
        return "a student";
    }

    // POST 请求
    // 浏览器向服务器提交数据时，使用 POST 请求
    // 此时，需要有一个表单，表单中有一个提交按钮，点击提交按钮后，浏览器向服务器发送 POST 请求
    // 这个表单，我们需要创建在 resources 目录下
    // resources 目录中，static 目录下是静态资源，templates 目录下是模板/动态资源
    // 此时，表单是一个静态网页，我们建立在 resources/static 目录下
    // 我们不使用 GET 请求
    // 1. 因为 GET 请求会将数据暴露在 URL 中，不安全
    // 2. 同时，路径长度有限制，因为 GET 请求会将数据拼接在 URL 中，数据量大时，会超出 URL 长度限制
    @RequestMapping(path = "/student", method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name, int age) {
        // @RequestParam 注解可以不写，参数名和方法参数名一致时，会自动赋值
        System.out.println(name);
        System.out.println(age);
        return "success";
    }

    // 服务器响应 HTML 数据
    // 方法一
    @RequestMapping(path = "/teacher", method = RequestMethod.GET)
    // 获取老师
    // http://localhost:8080/community/alpha/teacher
    // 不写 @ResponseBody 时，默认返回的数据类型是 HTML
    public ModelAndView getTeacher() {
        // 接收 model 和 view
        ModelAndView mav = new ModelAndView();
        mav.addObject("name", "Mr. Zhang");
        mav.addObject("age", 30);
        mav.setViewName("/demo/view");
        // view.html 需要位于 resources/templates/demo 目录下
        // 因为 templates 目录下的文件都默认是 html 文件，因此不需要写后缀
        return mav;
    }

    // 方法二
    // 查询学校
    @RequestMapping(path = "/school", method = RequestMethod.GET)
    // http://localhost:8080/community/alpha/school
    public String getSchool(Model model) {
        // 此时，我们把信息保存在 Model 类型的对象中，返回给浏览器，相对简洁
        model.addAttribute("name", "Coding School");
        model.addAttribute("age", 100);
        return "/demo/view";
    }

    // 服务器向浏览器响应 JSON 数据
    // JSON 一般应用于 异步请求 中
    // Java 对象 -> JSON 字符串 -> JS 对象
    @RequestMapping(path = "/emp", method = RequestMethod.GET)
    // 查询员工
    // http://localhost:8080/community/alpha/emp
    @ResponseBody
    public Map<String, Object> getEmp() {
        Map<String, Object> emp = new HashMap<>();
        emp.put("name", "Mr. Zhang");
        emp.put("age", 25);
        emp.put("salary", 8000.00);
        return emp;
    }
    // 此时，Map 对象会自动转换为 JSON 字符串，返回给浏览器

    // 类似的，返回多个相似结构的数据
    @RequestMapping(path = "/emps", method = RequestMethod.GET)
    // 查询所有员工
    // http://localhost:8080/community/alpha/emps
    @ResponseBody
    public List<Map<String,Object>> getEmps (){
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String, Object> emp = new HashMap<>();

        emp.put("name", "Mr. Zhang");
        emp.put("age", 25);
        emp.put("salary", 8000.00);
        list.add(emp);

        emp.put("name", "Mr. Yang");
        emp.put("age", 29);
        emp.put("salary", 9000.00);
        list.add(emp);

        emp.put("name", "Mr. Wang");
        emp.put("age", 23);
        emp.put("salary", 8100.00);
        list.add(emp);

        return list;
    }
}
