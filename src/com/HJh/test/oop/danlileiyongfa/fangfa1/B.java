package com.HJh.test.oop.danlileiyongfa.fangfa1;
//此单例类只有在使用时才会创建对象，懒汉式单例类
public class B {
    //1.私有化构造方法，防止外部创建对象
    private B() {
    }

    //2.创建一个静态的属性，默认值为null
    private static B b;


    //3.提供一个公共的方法，只有在b为null时才会创建对象，返回唯一的对象
    public static B getInstance() {
        if (b == null) {
            b = new B();
        }
        return b;
    }
}
