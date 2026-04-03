package com.HJh.test.oop.zifuchuan.bianli;
//public char charAt(int index)：根据索引返回字符
//public int length()：返回此字符串的长度
//需求：键盘录入一个字符串，使用程序实现在控制台遍历该字符串
public class test {
    public static void main(String[] args) {
        String str = "abcdefg";
        char c = str.charAt(2);
        System.out.println(c);
        int length = str.length();
        System.out.println(length);
    }
}
