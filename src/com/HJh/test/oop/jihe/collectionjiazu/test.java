package com.HJh.test.oop.jihe.collectionjiazu;
//Collection集合特点(接口)
//List系列集合：添加的元素是有序、可重复、有索引。(接口)
    //ArrayList、LinekdList：有序、可重复、有索引。（实现类）

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Set系列集合：添加的元素是无序、不重复、无索引。(接口)
    //HashSet:无序、不重复、无索引；（实现类）
    //LinkedHashSet:有序、不重复、无索引。（实现类）
    //TreeSet：按照大小默认升序排序、不重复、无索引。（实现类）
public class test {
    public static void main(String[] args) {
        //List家族的集合：添加的元素是有序、可重复、有索引。
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");
        list.add("hello");
        System.out.println( list);

        //Set家族的集合：添加的元素是无序、不重复、无索引。
        Set<String> set = new HashSet<>();
        set.add("hello");
        set.add("world");
        set.add("java");
        set.add("hello");
        System.out.println( set);
    }
}
