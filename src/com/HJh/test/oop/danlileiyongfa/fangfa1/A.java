package com.HJh.test.oop.danlileiyongfa.fangfa1;
//此单例类在加载时就创建了对象，饿汉式单例类
public class A {
    //1.私有化构造方法，防止外部创建对象
    private A() {
    }

    //2.创建一个静态的属性，指向唯一的对象
    private static A a = new A();
    //或者
    //private static final A a = new A();
    //或者
    //public static final A a = new A();

    //3.提供一个公共的方法，返回唯一的对象
    public static A getInstance() {
        return a;
    }
}
