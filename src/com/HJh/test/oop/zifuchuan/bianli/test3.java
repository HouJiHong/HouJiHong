package com.HJh.test.oop.zifuchuan.bianli;

import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数组的长度：");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("请输入数组的元素：");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        String res = ArrayPingJie.arrayToString(arr);
        System.out.println(res);
    }
}
