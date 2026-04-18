package com.HJh.test.oop.danlileiyongfa.fangfa1;
//单例类就是只有一个对象的类，不能创建多个对象
public class test {
    public static void main(String[] args) {
        //a1和a2指向的是同一个对象
        A a1 = A.getInstance();
        A a2 = A.getInstance();
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a1 == a2);

        B b1 = B.getInstance();
        B b2 = B.getInstance();
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b1 == b2);
    }
}
