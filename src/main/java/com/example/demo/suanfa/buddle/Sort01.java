package com.example.demo.suanfa.buddle;

/**
 * @Author: Administrator
 * @Date 2019/3/31
 * @Description: 冒泡排序
 */
public class Sort01 {

    public static int[] sortNum(int[] num){
        //对所有的数从小到大排序
        for(int i = 0;i<num.length;i++){
            //每排一次就产生一个最大值，比如第一次从N个值中排出最大值，第二次从N-1个数中排出最大值
            for(int j = 0;j<num.length-i-1;j++){
                //如果前面的数比后面的大就交换顺序
                if(num[j]>num[j+1]){
                    int temp = num[j];
                    num[j]=num[j+1];
                    num[j+1]=temp;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[] aa = {3,1,33,44,23,2,6};
        sortNum(aa);
        for (int a : aa){
            System.out.println(a);
        }
    }
}
