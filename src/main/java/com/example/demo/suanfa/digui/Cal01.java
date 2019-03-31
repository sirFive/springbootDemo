package com.example.demo.suanfa.digui;

/**
 * @Author: Administrator
 * @Date 2019/3/31
 * @Description: 递归
 */
public class Cal01 {

    /**
     * 递归：知道初始值；后面的数可以根据前一个或前几个获得
     * @param n
     * @return
     */
    public static int caln(int n){
        if(n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }
        if(n>=3){
            return caln(n-1)+caln(n-2);
        }
        return 0;
    }

    public static int getAge(int n){
        if(n==1){
            return 10;
        }else {
            return getAge(n-1)+2;
        }
    }

    public static void main(String[] args) {
        System.out.println(caln(8));
    }
}
