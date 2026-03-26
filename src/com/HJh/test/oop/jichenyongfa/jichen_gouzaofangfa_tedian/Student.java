package com.HJh.test.oop.jichenyongfa.jichen_gouzaofangfa_tedian;

public class Student extends Person{
    String garde;



    public Student() {
        //默认有一个super()调用父类的空参构造方法

        System.out.println("student子类的空参构造");
    }

    public Student(String name, int age, String garde) {
        //父类中的属性：通过super（参数）的形式传递给父类的构造方法赋值
        super(name, age);                  //重点:super()必须放在第一行
        //子类中的属性：自己赋值
        this.garde = garde;
        System.out.println("student子类的带参构造");
    }
}
