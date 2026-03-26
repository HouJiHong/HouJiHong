package com.HJh.test.oop.staticyongfa;

public class test {
    public static void main(String[] args) {
        Stu.teacher = "a老师";        //相当于将初始化的null值改为a老师

        Stu s1 = new Stu();
        s1.name = "小王";
        s1.age = 18;
        System.out.println(s1.name+" "+s1.age+" "+Stu.teacher);
        Stu s2 = new Stu();
        s2.name = "小里";
        s2.age = 20;
        Stu.teacher = "b老师";        //修改静态变量

        System.out.println(s1.name+" "+s1.age+" "+Stu.teacher);
        System.out.println(s2.name+" "+s2.age+" "+Stu.teacher);
    }
}
