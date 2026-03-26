package com.HJh.test.oop.gouzaofangfa;

public class test {
    public static void main(String[] args) {
        //调用空参构造方法，且无赋值
        Student s1 = new Student();
        System.out.println(s1.getName()+" "+s1.getAge()+" "+s1.getGender()+" "+s1.getWeight());
        //调用带参构造方法
        Student s2 = new Student("小王", 18, "男", 80);
        System.out.println(s2.getName()+" "+s2.getAge()+" "+s2.getGender()+" "+s2.getWeight());
    }
}
