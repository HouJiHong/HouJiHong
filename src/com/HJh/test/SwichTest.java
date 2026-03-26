package com.HJh.test;

import java.util.Scanner;

public class SwichTest {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入月份：");
//        int mouth = sc.nextInt();
//        switch (mouth){
//            case 1:
//            case 2:
//            case 12:
//                System.out.println("冬季");
//                break;
//            case 3:
//            case 4:
//            case 5:
//                System.out.println("春季");
//                break;
//            case 6:
//            case 7:
//            case 8:
//                System.out.println("夏季");
//                break;
//            case 9:
//            case 10:
//            case 11:
//                System.out.println("秋季");
//                break;
//            default:
//                System.out.println("输入的月份有误");
//
//        }



        /*switch新用法：
        1箭头标签；
        2case后面可以写多个值；
        3switch可以有运行结果；
        4yield关键字；*/


        //1,2
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入月份：");
        int number = sc.nextInt();
        switch(number){
//            case 1,2,3->{
//                System.out.println("星期一");
//            }
            case 1,2,3-> System.out.println("星期一");
            case 4,5,6-> System.out.println("星期二");
            case 7,8,9-> System.out.println("星期三");
            default -> System.out.println("数字不在范围内");
        }

        //3,4

        String name = switch(number) {
//            case 1, 2, 3 -> "星期一"; //只有一句可以省略

            case 1, 2, 3 -> {
                yield "星期一";
            }
            case 4, 5, 6 -> {
                yield "星期二";
            }
            case 7, 8, 9 -> {
                yield "星期三";
            }
            default -> {
                yield "未知";
            }
        };       //有分号
        System.out.println(name);




















    }
}
