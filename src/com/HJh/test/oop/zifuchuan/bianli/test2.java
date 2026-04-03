package com.HJh.test.oop.zifuchuan.bianli;

import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
//        键盘录入一个字符串，统计该字符串中大小写字母，数字字符出现的次数（不考虑其他字符）
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String str = sc.next();
        int countUp = 0;
        int countLow = 0;
        int countNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)>='A'&&str.charAt(i)<='Z'){
                countUp++;
            }else if(str.charAt(i)>='a'&&str.charAt(i)<='z'){
                countLow++;
            }else{
                countNum++;
            }
        }
        System.out.println("大写字母出现的次数为："+countUp);
        System.out.println("小写字母出现的次数为："+countLow);
        System.out.println("数字出现的次数为："+countNum);
    }
}
