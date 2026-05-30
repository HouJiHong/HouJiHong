package com.HJh.test.oop.reflection;
//反射的作用？
//基本作用：可以得到一个类的全部成分然后操作。
//可以破坏封装性
//可以绕过泛型的约束

//最重要的用途是：
//适合做Java的框架，基本上，主流的框架都会基于反射设计出一些通用的功能。

import java.lang.reflect.Method;
import java.util.ArrayList;

public class ZuoYong {
    public static void main(String[] args) throws Exception {
        //泛型是在编译时检查的，编译完就没有泛型的约束，反射是在运行时检查的，所以反射可以绕过泛型的约束
        ArrayList<String> list = new ArrayList<>();
        list.add("HJh");
        list.add("HJh2");
        //list.add(132);
        //list.add(true);

        Class c1 = list.getClass();
        Method add = c1.getDeclaredMethod("add", Object.class);
        add.invoke(list, 132);
        add.invoke(list, true);
        System.out.println(list);
    }
}
