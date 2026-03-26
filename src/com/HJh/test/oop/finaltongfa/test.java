package com.HJh.test.oop.finaltongfa;

public class test {

    public static void main(String[] args) {
        Yuan y = new Yuan(3);
        double s = y.getArea();
        double c = y.getZhouChang();
        System.out.println("面积："+s);
        System.out.println("周长："+c);
    }
}
