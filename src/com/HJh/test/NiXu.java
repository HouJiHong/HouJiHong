package com.HJh.test;

import java.util.Scanner;

public class NiXu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int num = sc.nextInt();
        int result = 0;
        do{
            result=result*10+num%10;
            num=num/10;
        }while(num!=0);
        System.out.println("逆序后的整数为："+result);
    }
}
