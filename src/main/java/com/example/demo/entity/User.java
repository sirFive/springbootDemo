package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class User {

    private String name;
    private int age;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
