package com.HJh.test;

import java.util.Scanner;

public class ZuoYe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入一个整数：");
        int num = sc.nextInt();
        int jiechen = 1;
        do{
            jiechen *= num;
        }while(--num>0);
        System.out.println("输入的整数的阶乘为："+jiechen);

        /*Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个直角边：");
        double a = sc.nextDouble();
        System.out.println("请输入另一个直角边：");
        double b = sc.nextDouble();
        System.out.println("斜边为");
        double c = Math.sqrt(a*a+b*b);
        System.out.println("c="+c);*/


    }
}
