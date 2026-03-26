package com.HJh.test.oop;

public class test1 {
    public static void main(String[] args) {
        Dog d1 = new Dog();
        d1.setName("小白");
        d1.setAge(10);
        System.out.println(d1.getName()+" "+d1.getAge());
        d1.bark();
        System.out.println("2年后");
        d1.setAge(d1.getAge()+2);
        d1.bark();
    }



}
