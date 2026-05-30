package com.HJh.test.oop.reflection.reflectionframe;
//使用反射做一个简易版的框架
//需求：对于任意一个对象，该框架都可以把对象的字段名和对应的值，保存到文件中去。
//实现步骤
//1.定义一个方法，可以接收任意对象。
//2.每收到一个对象，使用反射获取该对象的Class对象，然后获取全部的成员变量。
//3.遍历成员变量，然后提取成员变量在该对象中的具体值。
//4.把成员变量名、和其值，写出到文件中去即可。

public class test {
    public static void main(String[] args) throws Exception {
        Dog dog = new Dog("小白",10);
        SaveObjectFrame.saveObject(dog);

        Student student = new Student("小王",18,"唱歌");
        SaveObjectFrame.saveObject(student);

        Teacher teacher = new Teacher("小王",30,"数学",10000,"男","197923479347");
        SaveObjectFrame.saveObject(teacher);
    }
}
