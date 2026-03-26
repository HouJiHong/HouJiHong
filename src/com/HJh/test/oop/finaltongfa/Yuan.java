package com.HJh.test.oop.finaltongfa;
//final：表示最终，不可变，可修饰类，变量，方法
//只能赋值一次，名字大写用下划线隔开
//final修饰哪个变量，则该变量的内容不能被修改
public class Yuan {
    private double r;
    private final double PI = 3.14;

    //空参构造方法
    public Yuan() {
    }
    //带参构造方法
    public Yuan(double r) {
        this.r = r;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    //注意：final修饰的成员变量不能被修改，所以没有setter方法
    public double getPI() {
        return PI;
    }

    public double getArea() {
        return PI*r*r;
    }
    public double getZhouChang() {
        return 2*PI*r;
    }
}
