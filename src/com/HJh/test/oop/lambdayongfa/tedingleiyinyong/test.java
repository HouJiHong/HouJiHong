package com.HJh.test.oop.lambdayongfa.tedingleiyinyong;
//特定类的方法引用

//使用场景
//如果某个Lambda表达式里只是调用一个特定类型的实例方法，并且前面参数列表中的第一个参数是作为方
//法的主调，后面的所有参数都是作为该实例方法的入参的，则此时就可以使用特定类型的方法引用。

import java.util.Arrays;
import java.util.Comparator;

//特定类的名称方法::方法
public class test {
    public static void main(String[] args) {
        //有一个字符串数组，忽略大小写对字符串进行排序
        String[] strings = new String[]{"Bob", "Alice", "Tom", "bob", "dog", "Cat"};

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });
        //此时发现使用的compareToIgnoreCase方法是string特定类的方法，且第一个参数是方法的主调，后面的是方法的参数
        //所以可以用特定类方法引用
        //Arrays.sort(strings, (o1, o2) ->o1.compareToIgnoreCase(o2));
        Arrays.sort(strings, String::compareToIgnoreCase);


        System.out.println( Arrays.toString( strings));
    }
}
