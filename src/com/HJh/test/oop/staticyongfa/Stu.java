package com.HJh.test.oop.staticyongfa;
//静态成员变量(类变量),被类中所有对象所共享
//静态变量是随着类加载而创建的，优先于对象创建，且生命周期和类一样直到关掉java虚拟机，不同的是静态变量放在堆内存中，类和方法放在方法区中
//只要赋值一次
//1.类名调用（推荐）
//2.对象名调用
public class Stu {
    String name;
    int age;
    static String teacher;

}
