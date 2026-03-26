package com.HJh.test.oop;

public class test2 {
    public static void main(String[] args) {
        Stu s1 = new Stu();
        s1.setName("小王");
        s1.setAge(18);
        System.out.println(s1.getName()+" "+s1.getAge());
        Stu s2 = new Stu("小里", 1002);
        System.out.println(s2.getName()+" "+s2.getAge());
        s1.eat();
        s1.sleep();
        s1.study();
        s2.eat();
        s2.sleep();
        s2.study();
    }
}
