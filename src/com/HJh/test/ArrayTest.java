package com.HJh.test;

import java.util.Random;
import java.util.Scanner;

public class ArrayTest {
    public static void main(String[] args) {
        //使用方法
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3, 4, 5};
        double[] arr3 = new double[]{1.1, 2.2, 3.3, 4.4, 5.5};
        double[] arr4 = {1.1, 2.2, 3.3, 4.4, 5.5};
        String[] arr5 = new String[]{"hello", "world", "java"};
        String[] arr6 = {"hello", "world", "java"};
        String a = arr5[0];
        System.out.println(a);

//        //键盘输入数组
//        Scanner sc = new Scanner(System.in);
//        int [] arr7 = new int[5];
//        for (int i = 0; i < arr7.length; i++) {
//            System.out.println("请输入一个数字：");
//            int num =sc.nextInt();
//            arr7[i] = num;
//        }
//        for (int i = 0; i < arr7.length; i++) {
//            System.out.println(arr7[i]);
//        }



        //随机打乱数组
        int [] arr8 = new int []{1, 2, 3, 4, 5,6,7,8,9,10};
        Random r = new Random();

        for (int i = 0; i < arr8.length; i++){
            int index=r.nextInt(arr8.length);

            int temp = arr8[i];
            arr8[i]=arr8[index];
            arr8[index]=temp;

        }
        for (int i = 0; i < arr8.length; i++) {
            System.out.println(arr8[i]);
        }




        //随机生成元素1-100，10个元素的数组，元素是唯一的

        //Random r = new Random();
        int [] arr9 = new int[10];
        for (int i = 0; i < arr9.length; ) {
            int num = r.nextInt(100)+1;
            int count=0;
            for(int j=0;j<arr9.length;j++){
                if(arr9[j]==num){
                    count++;
                    break;
                }
            }
            if(count==0){
                arr9[i]=num;
                i++;                  //重点
            }
        }
        for (int i = 0; i < arr9.length; i++) {
            System.out.print(arr9[i]+" ");
        }
        System.out.println();



        //随机生成元素0-100，10个元素的数组，元素是唯一的

        int [] arr10 = new int[10];
        for (int i = 0; i < arr10.length; ) {
            int num = r.nextInt(0,101);
            int count=0;
            for(int j=0;j<i;j++){     //重点二
                if(arr10[j]==num){
                    count++;
                    break;
                }
            }
            if(count==0){
                arr10[i]=num;
                i++;                  //重点
            }
        }
        for (int i = 0; i < arr10.length; i++) {
            System.out.print(arr10[i]+" ");
        }
        System.out.println();



        //快慢指针，删除重复元素
        int [] arr11 = new int[] {1,2,2,2,3,3,3,3};
        int slow=0;
        int fast=0;
        while(fast<arr11.length){
            if(arr11[slow]==arr11[fast]){
                fast++;
            }else{
                slow++;
                arr11[slow]=arr11[fast];
                fast++;
            }

            //简便
            /*if(arr11[slow]!=arr11[fast]){
                slow++;
                arr11[slow]=arr11[fast];

            }fast++;*/

        }
        for (int i = 0; i <= slow; i++) {
            System.out.print(arr11[i]+" ");
        }
        System.out.println();


    }
}
