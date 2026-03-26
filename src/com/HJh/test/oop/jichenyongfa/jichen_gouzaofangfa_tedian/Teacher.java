package com.HJh.test.oop.jichenyongfa.jichen_gouzaofangfa_tedian;

public class Teacher extends Person{
    //添加默认值方法一
    //String subject = "计算机";
    String subject;
    /*this()：调用本类的其他构造方法
    如果想要默认值既可以用
    和super()一样必须放在构造方法中第一行
    1.如果子类有多个构造方法，不能用this()互相调用，要预留一个调用父类构造方法
    2.如果构造方法中写了this，就不能再写super()，jvm也不会默认添加*/
    public Teacher() {
        //添加默认值方法二
        this("老师",20,"语文");

        System.out.println("teacher子类的空参构造");

    }

    public Teacher(String name, int age, String subject) {

        super(name, age);

        this.subject = subject;
        System.out.println("teacher子类的带参构造");
    }
}
