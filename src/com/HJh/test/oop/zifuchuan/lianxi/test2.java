package com.HJh.test.oop.zifuchuan.lianxi;

import java.util.Scanner;

//把任意手机号中间四位变成****
//保留邮箱名第一个字母，保留@后面的内容
//13112345678       131****5678
//zw1234@163.com    z***@163.com
public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入手机号：");
        String phone = sc.next();
        String maskPhone = phone.substring(0,3)+"****"+phone.substring(7);
        System.out.println(maskPhone);
        System.out.println("请输入邮箱：");
        String email = sc.next();
        int index = email.indexOf("@");
        String maskEmail = email.charAt(0)+"***"+email.substring(index);
        System.out.println(maskEmail);
    }
}
