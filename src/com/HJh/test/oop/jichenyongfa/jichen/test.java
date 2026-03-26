package com.HJh.test.oop.jichenyongfa.jichen;

public class test {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "zhangsan";
        s1.age = 18;
        s1.grade = "一年级";
        System.out.println(s1.name + " " + s1.age + " " + s1.grade);
        s1.eat();
        s1.study();

        Teacher t1 = new Teacher();
        t1.name = "lisi";
        t1.age = 30;
        t1.subject = "数学";
        System.out.println(t1.name + " " + t1.age + " " + t1.subject);
        t1.eat();
        t1.teach();


    }
}
