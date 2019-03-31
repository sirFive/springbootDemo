package com.example.demo.suanfa.merge;

/**
 * @Author: Administrator
 * @Date 2019/3/31
 * @Description: 归并排序 写法错误
 */
public class sort01 {

    public static int[] sortNum(int[] num, int low, int high){
        if(low<high){
            int mid = (low+high)/2;
            sortNum(num,low,mid);
            sortNum(num,mid+1,high);
            merge2(num,low,high,mid);
        }
        return num;
    }

    public static int[] merge2(int[] numc,int low,int high,int mid){
        int[] numd = new int[numc.length];
        int j=low,k=mid;
        for(int i = 0;i<numc.length;i++){
            if(j>mid-1){
                numd[i]=numc[k];
                k++;
                continue;
            }
            if(k>high-1){
                numd[i]=numc[j];
                j++;
                continue;
            }
            if(numc[j]<numc[k]){
                numd[i]=numc[j];
                j++;
            }else {
                numd[i]=numc[k];
                k++;
            }
        }
        return numd;
    }

    public static int[] merge(int[] numa, int[] numb){
        int[] numc = new int[numa.length+numb.length];
        int j = 0;
        int k = 0;
        for(int i=0;i<numc.length;i++){
            if(k>numb.length-1){
                numc[i]=numa[j];
                j++;
                continue;
            }
            if(j>numa.length-1){
                numc[i]=numb[k];
                k++;
                continue;
            }
            if(numa[j]<numb[k]){
                numc[i]=numa[j];
                j++;
            }else {
                numc[i]=numb[k];
                k++;
            }

        }
        return numc;
    }

    public static void main(String[] args) {
        int[] a = {3,6};
        int[] b = {5,7,8};
        int[] cc = {7,12,5,3,28,6};
        int[] mergeResult = merge(a,b);
        /*for (int r : mergeResult){
            System.out.println(r);
        }*/
        sortNum(cc,0,cc.length);
        for(int c:cc){
            System.out.println(c);
        }
    }
}
