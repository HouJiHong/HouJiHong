package com.HJh.test;

//给定n个柱形，求能装多少水
//给定一个数组，其中n个数表示n个柱形，每个柱形高度为数组中的数，求能装多少水
//比如：
//输入：[0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6

public class JieYuShui {
    public static void main(String[] args) {
        int [] Architecture = new int []{0,1,0,2,1,0,1,3,2,1,2,1};
        //从左边看，想象最右边有一个无限高的墙
        int [] left = new int [Architecture.length];
        //从右边看，想象最左边有一个无限高的墙
        int [] right = new int [Architecture.length];

        //记录高的
        int temp = Architecture[0];
        for(int i = 0; i < Architecture.length; i++){
            if(temp>Architecture[i]){
                left[i] = temp;
            }else{
                left[i] = Architecture[i];
                temp = Architecture[i];
            }
        }

        int temp2 = Architecture[Architecture.length-1];
        for(int i = Architecture.length-1; i >=0 ; i--){
            if(temp2>Architecture[i]){
                right[i] = temp2;
            }else{
                right[i] = Architecture[i];
                temp2 = Architecture[i];
            }
        }

        //两者重叠，取两者中较小的
        int [] result = new int [Architecture.length];
        for(int i = 0; i < Architecture.length; i++){
            if(left[i]<right[i]){
                result[i] = left[i];
            }else{
                result[i] = right[i];
            }
        }
        int water = 0;
        for (int i = 0; i < result.length; i++) {
            water += result[i]-Architecture[i];
        }
        System.out.println("总水量为："+water);
    }
}
