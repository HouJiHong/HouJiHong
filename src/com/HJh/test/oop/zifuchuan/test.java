package com.HJh.test.oop.zifuchuan;
//字符串也是一个类，在Java.lang包下，不需要导包
//所以可以通过new关键字创建对象

//直接赋值和new关键字创建字符串对象在内存中存储方式不一样
//第一次直接赋值时会在堆内存中创建一个StringTable(串池)，下次直接赋值时，会从StringTable中查找，
//如果找到，则直接从StringTable中获取对象，如果没有找到，则创建对象，并放入StringTable中，所以会有一个复用功能
//而new关键字创建字符串对象，是通过new创建对象，对象直接存储在堆内存中，每new一次，就会创建一个新对象，没有复用功能
public class test {
    public static void main(String[] args) {
//第一种：直接赋值
//第二种：new关键字
//       public String()                     空白字符串，不含任何内容
//       public String(String original)      根据传入的字符串，创建新的字符串对象
//       public String(char[] chs)           根据字符数组，创建字符串对象
//       public String(byte[] chs)
//       根据字节数组，创建字符串对象


//1．直接赋值
//最简单最常用---------------------------------------------------------它
        String s="abc";
        System.out.println(s);

//2.new+构造方法的方式创建字符串对象
//new+空参构造
        String s1 = new String();
        System.out.println("--" + s1 + "@@");  // ""内容为空
//3.new+有参构造------------------------------------------------------和它区别
//根据传入字符串的内容，创建一个新的字符串对象
        String s2 = new String(s);
        System.out.println(s2);// abc
//4.new+有参构造（字符数组）
        char[] chs = {'a','b','c','d','e'};
        String s3 = new String(chs);
        System.out.println(s3); // abcde
//5.new+有参构造（字节数组）
//ASCII码表
        byte[] bytes ={97,98,99,100,101};
        String s4 = new String(bytes);
        System.out.println(s4);// abcde
    }
}
