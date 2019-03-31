package com.example.demo.suanfa.merge;

/**
 * @Author: Administrator
 * @Date 2019/3/31
 * @Description:
 */
public class Sort02 {
    public static int[] sortNum(int[] num,int low,int high){
        if(low<high){
            int mid = (low+high)/2;
            sortNum(num,low,mid);
            sortNum(num,mid+1,high);
            merge(num,low,high,mid);
        }
        return num;
    }

    public static void merge(int[] num,int low,int high,int mid){
        int[] numMerge = new int[high-low+1];
        int j = low;
        int k = mid+1;
        int i;
        for (i=0;j<=mid && k<=high;i++){
            if(num[j]<num[k]){
                numMerge[i]=num[j];
                j++;
            }else {
                numMerge[i]=num[k];
                k++;
            }
        }
        while (j<=mid){
            numMerge[i]=num[j];
            j++;
            i++;
        }
        while (k<=high){
            numMerge[i]=num[k];
            k++;
            i++;
        }
        // 把新数组中的数覆盖nums数组
        for(int x=0;x<numMerge.length;x++){
            num[x+low] = numMerge[x];
        }

    }

    public static void main(String[] args) {
        int[] tt = {7,4,8};
        int[] dd = sortNum(tt,0,tt.length-1);
        for (int d : dd){
            System.out.println(d);
        }
    }
}
