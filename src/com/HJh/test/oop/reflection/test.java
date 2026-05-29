package com.HJh.test.oop.reflection;
//反射：加载类，并允许以编程的方式解剖类中的各种成分（成员变量、方法、构造器等）。
//1、反射第一步：加载类，获取类的字节码：Class对象
//2、获取类的构造器：Constructor对象
//3、获取类的成员变量：Field对象
//4、获取类的成员方法：Method对象

//获取Class对象的三种方式
//Class c1 =类名.class
//调用Class提供方法：public static Class forName(String package);
//Object提供的方法：public Class getClass(); Class c3 =对象.getClass();

public class test {
    public static void main(String[] args) throws Exception {
        //1.获取Class对象
        Class c1 = Student.class;
        System.out.println(c1);
        //2.获取Class对象
        Class c2 = Class.forName("com.HJh.test.oop.reflection.Student");
        System.out.println(c2);
        System.out.println(c1 == c2);
        //3.获取Class对象
        Student s = new Student();
        Class c3 = s.getClass();
        System.out.println(c3);
        System.out.println(c1 == c3);


    }
}
