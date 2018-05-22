package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping(value = "template")
public class TemplateTest {

    @RequestMapping(value = "/thymFirst")
    public String thymFirst(ModelMap map){
        User user=new User();
        user.setName("wu");
        user.setBirth(new Date());
        map.addAttribute("user",user);
        return "thymeleaf/thym1";
    }


    @RequestMapping(value = "/free")
    public String free(ModelMap map){
        User user=new User();
        user.setName("xie");
        map.addAttribute("user",user);
        return "freemarker/free";
    }
}
