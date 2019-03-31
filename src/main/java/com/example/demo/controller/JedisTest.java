package com.example.demo.controller;
import redis.clients.jedis.Jedis;

public class JedisTest {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        jedis.set("testJedis1","22");
        jedis.set("testJedis2","");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
        System.out.println("1:"+jedis.get("testJedis1"));   //"22"
        System.out.println("2:"+jedis.get("testJedis2"));   //""
        System.out.println("3:"+jedis.get("testJedis3"));   //null
    }
}
