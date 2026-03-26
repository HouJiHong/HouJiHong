package com.HJh.test;

import java.sql.SQLOutput;

public class SanJiaoXingTest {
    //System.out.println();输出完会换行
    //System.out.print();不换行
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }//下三角

        for (int i = 1; i <= 5; i++) {
            for (int j = i; j <= 5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }//上三角

        //平行四边形法1
        for (int i=1;i<=3;i++){
            for (int j = i; j <= 2; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 6; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        //平行四边形法2  将图形补成长方形，再将其分割成若干三角形和长方形
        for (int i = 1; i <= 3 ; i++) {
            //第一部分是下三角型
            for (int j = i; j <= 2; j++) {
                System.out.print("#");
            }
            //第二部分是上三角型
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            //第三部分是长方形
            for (int j = 1; j <= 3; j++) {
                System.out.print("&");
            }
            //第四部分是下三角型
            for (int j = i; j <= 2; j++) {
                System.out.print("￥");
            }
            System.out.println();
        }

        //梯形
        for (int i = 1; i <= 3; i++) {
            for (int j = i; j <= 2; j++){
                System.out.print("#");
            }
            for (int j = 1; j <= i; j++){
                System.out.print("*");
            }

            System.out.print("&");

            for (int j = 1; j <= i; j++){
                System.out.print("$");
            }
            System.out.println();
        }


        //菱形


        // 打印菱形（上半部分）
        for (int i = 1; i <= 3; i++) {
            for (int j = i; j <= 2; j++){
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++){
                System.out.print("*");
            }

            for (int j = 1; j < i; j++){
                System.out.print("&");
            }
            System.out.println();
        }

        // 打印菱形（下半部分）
        for (int i = 2; i >= 1; i--) {
            for (int j = i; j <= 2; j++){
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++){
                System.out.print("*");
            }

            for (int j = 1; j < i; j++){
                System.out.print("&");
            }
            System.out.println();
        }





    }
}
