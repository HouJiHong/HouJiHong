package com.HJh.test.oop.kebiancanshu;
//方法中可变参数
//就是一种特殊形参，定义在方法、构造器的形参列表里，格式是：数据类型...参数名称；
//可变参数的特点和好处
//特点：可以不传数据给它；可以传一个或者同时传多个数据给它；也可以传一个数组给它。
//好处：常常用来灵活的接收数据。

//可变参数的注意事项：
//        可变参数在方法内部就是一个数组。
//        一个形参列表中可变参数只能有一个
//        可变参数必须放在形参列表的最后面
import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        sum();
        sum(1);
        sum(1,2,3,4,5,6,7,8,9,10);
        sum(new int[]{1,2,3,4,5,6,7,8,9,10});

    }
    public static void sum(int... a){
        System.out.println(a.length);
        System.out.println(Arrays.toString( a));
    }
}
