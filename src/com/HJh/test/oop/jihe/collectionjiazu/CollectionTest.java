package com.HJh.test.oop.jihe.collectionjiazu;
//Collection集合特点(接口)
//List系列集合：添加的元素是有序、可重复、有索引。(接口)
    //ArrayList、LinekdList：有序、可重复、有索引。（实现类）
    //ArrayList是基于数组实现的，查询快，增删慢。
    //LinkedList是基于双链表实现的，查询慢，增删快。

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Set系列集合：添加的元素是无序、不重复、无索引。(接口)
    //HashSet:无序、不重复、无索引；（实现类）
    //LinkedHashSet:有序、不重复、无索引。（实现类）
            //依然是基于哈希表（数组、链表、红黑树)实现的。
            //但是，它的每个元素都额外的多了一个双链表的机制记录它前后元素的位置。

    //TreeSet：按照大小默认升序排序、不重复、无索引。（实现类）


//Collection集合中的常用方法
    //public boolean add(E e)               把给定的对象添加到当前集合中
    //public void clear()                   清空集合中所有的元素
    //public boolean remove(E e)            把给定的对象在当前集合中删除
    //public boolean contains(object obj)   判断当前集合中是否包含给定的对象
    //public boolean isEmpty()              判断当前集合是否为空
    //public int size()                     返回集合中元素的个数。
    //public Object[] toArray()             把集合中的元素，存储到数组中


public class CollectionTest {
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
