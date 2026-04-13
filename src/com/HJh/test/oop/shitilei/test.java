package com.HJh.test.oop.shitilei;
//实体类也就是javabean
//什么是实体类？有啥特点？
//    ●成员变量必须私有，且要为他们提供get、set方法；必须有无参数构造器。
//    ●仅仅只是一个用来保存数据的java类，可以用它创建对象，保存某个事物的数据,不对数据进行计算或操作
//实体类有啥应用场景？
//    ●实体类对应的是软件开发里现在比较流行的开发方式，数据和数据的业务处理相分离,实现分层思想
public class test {
    public static void main(String[] args) {
        Student s1 = new Student("张三",18,"男");
        Student s2 = new Student("李四",19,"女");
        System.out.println(s1.getName()+s1.getAge()+s1.getSex());
        System.out.println(s2.getName()+s2.getAge()+s2.getSex());

        StuCaoZuo operator1 = new StuCaoZuo(s1);
        operator1.show();
        StuCaoZuo operator2 = new StuCaoZuo(s2);
        operator2.show();
        
    }
}
