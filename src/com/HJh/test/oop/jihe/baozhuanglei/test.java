package com.HJh.test.oop.jihe.baozhuanglei;

import java.util.ArrayList;

//由于集合无法直按添加基本数据类型，需要包装类进行托管
//其实就是默认有一个类，想要在集合中添加基本数据类型，那么需要调用相应的包装类
//byte       Byte
//short      Short
//int        Integer
//long       Long
//float      Float
//double     Double
//char       Character
//boolean    Boolean
public class test {
    public static void main(String[] args) {
        /*需求：定义一个集合，添加数字，并进行遍历。
        遍历格式参照：[元素1，元素2，元素3]。*/
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println( list);
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            //获取集合元素，因为是Integer包装类，所以用Integer接受变量
            Integer result = list.get(i);
            if(i==list.size()-1){
                System.out.println( result+"]");
            }else{
                System.out.print( result+",");
            }
        }
    }
}
