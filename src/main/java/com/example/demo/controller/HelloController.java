package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.entity.User;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController   //相当于@ResponseBody +@Controller这两个注解的合并，加了 这个后想返回json对象，可以不用再方法中添加@ResponseBody
@RequestMapping(value = "hello")
public class HelloController {

    @Autowired
    private Department department;

    @RequestMapping(value = "/user")
    public User getUser(){
        User u=new User();
        u.setName("xie1");
        u.setAge(24);
        u.setBirth(new Date());
        return u;
    }

    @RequestMapping(value = "/getDepartment")
    public Department getDepartment(){
        Department dep=new Department();
        BeanUtils.copyProperties(department,dep);
        return dep;
    }
}
