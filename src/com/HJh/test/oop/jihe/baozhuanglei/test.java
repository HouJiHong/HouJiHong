package com.HJh.test.oop.jihe.baozhuanglei;

import java.util.ArrayList;

//泛型和集合不支持基本数据类型，只能支持对象类型（引用数据类型）。
//泛型擦除：泛型工作在编译阶段，等编译后泛型就没用了，都会被擦除，所有类型会恢复成object类型

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
        //把基本数据类型变成包装类对象
        //当使用 Integer.valueOf() 或自动装箱时，如果数值在 [-128, 127] 范围内，会直接从缓存中返回同一个对象
        //如果数值超出这个范围，每次都会创建新的对象
        //Integer i = new Integer(100);过时
        Integer i1 = Integer.valueOf(100);//并不推荐
        Integer i2 = Integer.valueOf(100);
        System.out.println(i1 == i2);

        //自动装箱成对象：基本数据类型的数据可以直接变成包装对象的数据，不需要额外做任何事情
        Integer it11 =130;  //推荐
        Integer it22 =130;
        System.out.println(it11 == it22);

        //自动拆箱成基本数据类型：对象数据可以直接变成基本数据类型的数据，不需要额外做任何事情
        int i3 = it11;
        System.out.println(i3);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(100);//自动装箱成对象
        int i4 = list2.get(0); //自动拆箱成基本数据类型


//        包装类具备的其他功能
//        可以把基本类型的数据转换成字符串类型。
//        public static String toString(double d)
//        public String toString()
//        或者直接用空字符串加拼接

//        可以把字符串类型的数值转换成数值本身对应的真实数据类型。
//        public static int parseInt(String s)
//        public static Integer valueOf(String s)

        //1.把基本数据类型转换成字符串类型
        int i5 = 100;
        String s = Integer.toString(i5);//"100"
        System.out.println(s+1);//1001

        Integer i6 = i5;
        String s2 = i6.toString();//"100"
        System.out.println(s2+1);//1001

        String s3 = i5+ "";
        System.out.println(s3+1);//1001
        System.out.println("-----------------------------------");

        //2.把字符串类型的数值转换成数值本身对应真实的数据类型
        String s4 = "123";
        //int i7 = Integer.parseInt(s4);
        int i7 = Integer.valueOf(s4);   //用valueOf()将字符串转换成对象，然后自动拆箱成基本数据类型
        System.out.println(i7+1);
        double d = Double.valueOf(s4);//124


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
