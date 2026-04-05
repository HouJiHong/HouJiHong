package com.HJh.test.oop.zifuchuan.lianxi;

import java.util.Random;


//验证码的内容：可以是小写字母，也可以是大写字母，还可以是数字
//验证码的规则：
//长度为5
//内容中是四位字母，1位数字。
//其中数字只有1位，但是可以出现在任意的位置。
//举例:
//正确的验证码：We1fg 6gKoq tqB2p
//错误的验证码：iuybs（没有数字） j1s2u（两个数字）
public class test3 {
    //法一：四个字母一个数字
    public static void main(String[] args) {
        Random random = new Random();
        char[] zm = new char[52];
        //创建字母库
        for (int i = 0; i < 26; i++) {
            zm[i] = (char) ('a' + i);
            zm[i + 26] = (char) ('A' + i);
        }

        StringBuilder sb = new StringBuilder();
        //随机获取4个字母
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(zm.length);
            sb.append(zm[index]);
        }
        //把一个数字拼接到字母后面
        int num = random.nextInt(10);
        sb.append(num);
        //toString()方法要有返回值接受，不然输出地址
        String result = sb.toString();
        System.out.println( result);

        //转换成字符数组，随机排序
        char[] charArray = result.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int num2 = random.nextInt(charArray.length);
            char temp = charArray[i];
            charArray[i] = charArray[num2];
            charArray[num2] = temp;
        }
        String result2 = new String(charArray);
        System.out.println(result2);
    }
    //法二：五个字母，一个数字替换
    /*public static void main(String[] args) {
        Random random = new Random();
        char[] zm = new char[52];
        //创建字母库
        for (int i = 0; i < 26; i++) {
            zm[i] = (char) ('a' + i);
            zm[i + 26] = (char) ('A' + i);
        }

        StringBuilder sb = new StringBuilder();
        //随机获取5个字母
        for (int i = 0; i < 5; i++) {
            int index = random.nextInt(zm.length);
            sb.append(zm[index]);
        }

        //随机选择一个位置，用数字替换该位置的字母
        int replaceIndex = random.nextInt(5);
        int num = random.nextInt(10);
        sb.setCharAt(replaceIndex, (char)('0' + num));

        String result = sb.toString();
        System.out.println(result);
    }*/
}
