package com.HJh.test.oop.jihe.collectionjiazu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//Collections提供的常用静态方法
//public static <T>boolean addAll(Collection<? super T> c,T... elements)    给集合批量添加元素
//public static void shuffle(List<?> list)                                  打乱List集合中的元素顺序

//public static <T> void sort(List<T> list)                                 对List集合中的元素进行升序排序
//public static <T>void sort(List<T> list,Comparator<?super T> c)           对List集合中元素，按照比较器对象指定的规则进行排序
public class Collections_GongJuLei {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"张三丰","张无忌","周芷若","赵敏","张强");//批量添加元素
        System.out.println(list);
        Collections.shuffle(list);//打乱集合中的元素顺序
        System.out.println(list);

        list.stream().sorted().forEach(System.out::println);
        List<String> collect2 = list.stream().sorted().collect(Collectors.toList());
        System.out.println(collect2);
    }

}
