package com.HJh.test.oop.jihe.jiheyongfa;

import java.util.ArrayList;
//集合就是容器，可以增加，减少容器的大小


//ArrayList集合
//空参构造：
//ArrayList()               创建一个长度为e的集合
//常见方法：
//boolean add(E e)          添加数据
//void add(int index,E e)   添加数据
//boolean remove(E e)       删除元素
//E remove(int index)       删除元素
//E set(int index,E e)      修改元素
//E get(int index)          获取元素
//int size()                集合长度
public class test {
    public static void main(String[] args) {
        //1.创建一个长度为e的ArrayList集合
        // ArrayList list = new ArrayList();
        //问题：能判断集合中能存储什么类型的数据吗？
        //如果没有进行限定，此时集合里面可以存储任意数据类型的数据,包括引用数据类型和基本数据类型
        //泛型：限定集合当中的数据类型<数据类型>
        //ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> list = new ArrayList<>();

        //添加数据,放在集合的末尾，返回值为布尔值
//        在集合当中无法直按添加基本数据类型的(byte short int long float double char boolean)
//        只能添加引用数据类型（对象）
//        如果在集合里面一定要添加基本数据类型，那么可以转成其对应的包装类
        list.add("hello");
        list.add("world");
        System.out.println( list);

        //添加数据，指定索引位置
        list.add(1,"java");
        System.out.println(list);

        //删除数据
        //如果指定了元素，返回值为布尔值
        boolean result = list.remove("java");
        System.out.println( result);

        //删除数据
        //指定索引位置,返回删除的元素
        System.out.println( list);
        String result2 = list.remove(1);
        System.out.println(result2);
        System.out.println( list);

        //修改数据
        //指定索引位置，返回修改前的元素
        String result3 = list.set(0,"java");
        System.out.println(result3);
        System.out.println( list);

        //获取指定索引位置的元素
        String result4 = list.get(0);
        System.out.println(result4);
        //遍历    .size()获取集合长度
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
