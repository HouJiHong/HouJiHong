package com.HJh.test.oop.jihe.bianli;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

public class test {
    public static void main(String[] args) {
        //1.迭代器遍历
        //没有索引也可以用
        Collection<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");
        System.out.println( list);//[hello, world, java]
        //                            it                位置在第一个，取完后，next

        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String result = it.next();
            System.out.println(result);
        }
        System.out.println("=========================================");

        //2.foreach遍历(增强for循环)
        //for（元素的数据类型 变量名：数组或者集合）{}
        //增强for可以用来遍历集合或者数组。
        for (String result : list) {
            System.out.println(result);
        }
        System.out.println("=========================================");

        //3.lambda表达式
//        list.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println( s);
//            }
//        });
        //list.forEach(s -> System.out.println(s));
        list.forEach(System.out::println);

    }

}
