package com.HJh.test.ZuoYeTest.square;
//创建一个正方形类,添加正方形的边作为成员变量
//在正方形类中添加两种方法分别计算正方形的周长和面积
//编程在测试类中输出一个正方形的周长和面积.
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Square s = new Square();
        Scanner length = new Scanner(System.in);
        System.out.println("请输入边长：");
        double side = length.nextDouble();

        s.perimeter(side);
        s.area(side);
    }
}
