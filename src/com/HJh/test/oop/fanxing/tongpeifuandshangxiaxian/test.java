package com.HJh.test.oop.fanxing.tongpeifuandshangxiaxian;

import java.util.ArrayList;

//通配符
//就是'?'，可以在 “使用泛型” 的时候代表一切类型；ETKV是在 “定义泛型” 的时候使用。

//上下限
//泛型上限：？extends Car ,  ？能接收的必须是Car或者其子类。
//泛型下限：？super Car  , ？能接收的必须是Car或者其父类。
public class test {
    public static void main(String[] args) {
        ArrayList<BMW> bmws = new ArrayList<>();
        bmws.add(new BMW());
        bmws.add(new BMW());
        bmws.add(new BMW());
        //printArray(bmws);  第一个报错
        //printArray(bmws);  第二个加了？,可以接受任意集合,但显然不合理，dog也可以加入
        //所以要引入上下限来约束
        printArray(bmws);

        ArrayList<XM> xms = new ArrayList<>();
        xms.add(new XM());
        xms.add(new XM());
        xms.add(new XM());
        printArray(xms);

        ArrayList<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        dogs.add(new Dog());
        dogs.add(new Dog());
        //printArray(dogs); 错误，不是Car的子类
    }

    //尽管Car是BWM和XM的父类，但是ArrayList<BMW>，ArrayList<XM>，ArrayList<Car>都是集合，没有继承关系
    /*public static void printArray(ArrayList<Car> cars){
    }*/


    //此时用了通配符?，可以传入任意的集合
    /*public static void printArray(ArrayList<?> cars){
    }*/



    //添加上限，这样就可以把不是Car的子类排除在外
    public static void printArray(ArrayList<? extends Car> cars){
        for (Car car : cars) {
            System.out.println(car);
        }
    }



}
