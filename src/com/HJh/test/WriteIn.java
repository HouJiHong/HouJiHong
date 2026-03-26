package com.HJh.test;

import java.util.Scanner;

public class WriteIn {
    public static void main(String[] args) {
        //如何输入
        /*Scanner sc = new Scanner(System.in);
        //输入整数
        int num=sc.nextInt();
        System.out.println(num);

        //输入浮点数
        double num2=sc.nextDouble();
        System.out.println(num2);

        //输入字符串
        String str=sc.next();
        System.out.println(str);*/

        /*//练习1
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入两个整数：");
        int num1=sc.nextInt();
        int num2=sc.nextInt();
        System.out.println("两个整数的和为："+(num1+num2));*/

        //练习2
        //BMI=体重(kg)/身高^2(m)
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入体重");
        double weight = sc.nextDouble();
        System.out.println("请输入身高");
        double height = sc.nextDouble();

        double bmi = weight/(height*height);
        System.out.println("BMI="+bmi);
    }
}
