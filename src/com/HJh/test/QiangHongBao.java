package com.HJh.test;


import java.util.Random;
import java.util.Scanner;

//要求1：每个人至少一分钱
//要求2：每个人领完后，至少预留1*N分钱
//要求3：最后一个人拿剩余的
public class QiangHongBao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入红包金额(单位：分)：");
        int money = sc.nextInt();
        System.out.println("请输入红包个数：");
        int count = sc.nextInt();
        while(money< count){
            System.out.println("输入金额或个数有误，请重新输入：");
            System.out.println("请输入红包金额(单位：分)：");
            money = sc.nextInt();
            System.out.println("请输入红包个数：");
            count = sc.nextInt();
        }
        Random r = new Random();
        for (int i = 1; i <= count - 1; i++) {
            //money-(n-i)为后面的人预留至少一分钱
            //+1保证至少抽取一分钱

            int myMoney = r.nextInt(money-(count-i))+1;

            money-=myMoney;
            System.out.println("第"+i+"个人抢到"+myMoney+"分");
        }
        System.out.println("最后一个人抢到"+money+"分");
    }
}
