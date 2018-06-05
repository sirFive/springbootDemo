package com.example.demo.controller;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/6/5.
 * 新店开张免不了大优惠。我们要在小象生鲜超市里采购n个物品，每个物品价格为ai，有一些物品可以选择八折优惠（称为特价优惠）。
 有m种满减优惠方式，满减优惠方式只有在所有物品都不选择特价优惠时才能使用，且最多只可以选择最多一款。
 每种满减优惠描述为(bi,ci)，即满bi减ci（当消费>=bi时优惠ci）。
 求要买齐这n个物品（必须一单买齐），至少需要多少钱（保留两位小数）。
 */
public class meituan1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int m=sc.nextInt();
        int nn[][]=new int[n][2];
        int mm[][]=new int[m][2];
        for(int i=0;i<n;i++){
            nn[i][0]=sc.nextInt();
            nn[i][1]=sc.nextInt();
        }
        for (int j=0;j<m;j++){
            mm[j][0]=sc.nextInt();
            mm[j][1]=sc.nextInt();
        }

        float count0=0;//全部总数
        float count1=0;//8折减
        float count2=0;//满减
        for(int i=0;i<n;i++){
            if(nn[i][1]==1){
                count1+=nn[i][0]*0.8;
            }else {
                count1+=nn[i][0];
            }
            count0+=nn[i][0];
        }

        float temp=count1;
        for (int j=0;j<m;j++){
            if(count0>=mm[j][0]){
                count2=count0-mm[j][1];
                if(count2<temp){
                    temp=count2;
                }
            }
        }

        System.out.println(String.format("%.2f", temp));

    }
}
