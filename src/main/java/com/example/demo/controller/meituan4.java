package com.example.demo.controller;

import java.util.*;

/**
 * Created by Administrator on 2018/6/7.
 */
public class meituan4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int m=sc.nextInt();
        int k=sc.nextInt();
        int c=sc.nextInt();
        int mm[]=new int[m];

        //输入轮数的权重
        for(int i=0;i<m;i++){
            mm[i]=sc.nextInt();
        }
        //存放顺序和权重值
        Map<Integer,Integer> numberMap=new TreeMap<>();
        for(int i=0;i<n;i++){
            //List<Integer> list=new ArrayList<>();
            int count=0;
            for(int j=0;j<m;j++){
                int scnum=sc.nextInt();
                if(scnum!=-1){
                    count+=scnum*mm[j];
                }else{
                    count+=c*mm[j];
                }

            }
            numberMap.put(i,count);
        }
        //对map进行从大到小排序
        List<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(numberMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        List<Integer> sortKey=new ArrayList<>();
        for(Map.Entry<Integer,Integer> map:list){
            sortKey.add(map.getKey());
        }

        //一定出线
        List<Integer> mustList=new ArrayList<>();
        //可能出线
        List<Integer> proList=new ArrayList<>();
        //一定不出线
        List<Integer> unList=new ArrayList<>();

        //获取出线的k个人
        List<Integer> kList=sortKey.subList(0,k);
        List<Integer> ukList=sortKey.subList(k,sortKey.size());

        if(numberMap.get(sortKey.get(k-1)).equals(numberMap.get(sortKey.get(k)))){
            //假设肯定出线，刚好
            mustList.addAll(kList);
            //肯定不出现，刚好
            unList.addAll(ukList);
            //判断前部分是否还有和结尾相同的
            for(int i=0;i<kList.size();i++){
                if(numberMap.get(kList.get(i)).equals(numberMap.get(kList.get(k-1)))){
                    mustList.remove(kList.get(i));
                    proList.add(kList.get(i));
                }
            }
            //判断后部分是否还有和结尾相同的
            for(int j=0;j<ukList.size();j++){
                if (numberMap.get(ukList.get(j)).equals(numberMap.get(ukList.get(0)))){
                    unList.remove(ukList.get(j));
                    proList.add(ukList.get(j));
                }

            }

        }else{
            mustList=kList;
            unList=ukList;
        }
        for(int key :numberMap.keySet()){
            if(mustList.contains(key)){
                System.out.println(1);
            } else if (proList.contains(key)){
                System.out.println(3);
            }else if(unList.contains(key)){
                System.out.println(2);
            }
        }

    }
}
