package com.HJh.test.oop.jichenyongfa.jichen_gouzaofangfa_tedian;

public class Person {
    String name;
    int age;


    //空参构造
    public Person() {
        System.out.println("父类的空参构造");
    }
    //带参构造
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("父类的带参构造");
    }
}
