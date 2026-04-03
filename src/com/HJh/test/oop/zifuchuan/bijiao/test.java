package com.HJh.test.oop.zifuchuan.bijiao;
//boolean equals方法（要比较的字符串）
//完全一样结果才是true，否则为false
//boolean equalsIgnoreCase(要比较的字符串）
//忽略大小写的比较

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
/*  己知正确的用户名和密码，请用程序实现模拟用户登录
    总共给三次机会，登录之后，给出相应的提示*/

        String name = "zhangsan";
        String name2 = new String("Zhangsan");
        boolean result = name.equals(name2);
        System.out.println(result);
        boolean result2 = name.equalsIgnoreCase(name2);
        System.out.println(result2);


        Scanner sc = new Scanner(System.in);
        String userName = "zhangsan";
        String password = "123456";
        for (int i = 1; i <= 3; i++) {
            System.out.println("请输入用户名：");
            String uName = sc.next();
            System.out.println("请输入密码：");
            String pwd = sc.next();
            boolean resultUP = uName.equals(userName) && pwd.equals(password);
            if (resultUP) {
                System.out.println("登录成功！");
                break;
            } else {
                System.out.println("用户名或密码错误！");
                if (i <= 2) {
                    System.out.println("还剩"+(3-i)+"次机会，请重新登录！");
                }
                else {
                    System.out.println("登录失败！");
                }
            }
        }

    }
}
