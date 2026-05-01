package com.HJh.test.oop.fanxing.fanxingjiekou;
//泛型接口：
//修饰符 interface 接口名 <类型变量，类型变量，……>{}，类型变量常用E,T,K,V，意思是元素类型，返回值类型，键类型，值类型


//在创建接口的时候，方法中的参数不固定，所以就用泛型来定义方法参数和返回值类型
// <T> 表示"容器里存放的物品类型"，具体是什么由实现类决定
public interface Container<T> {

    // 放入一个物品
    void put(T item);

    // 取出一个物品
    T take();

    // 查看当前有多少物品
    int size();
}
