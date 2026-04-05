package com.HJh.test.oop.zifuchuan;

import java.util.Arrays;

//定义两个字符串，记录为非负整数，求它们的和。
//输入："12395”和“133"，输出：“12528"
//注意：需要数据过大，超出int取值范围的情况
public class zifuchuanjiafa {
    public static void main(String[] args) {
        String s1 = "12395";
        String s2 = "133";
        int length = (s1.length()>s2.length())?s1.length():s2.length();
        int[] chs1 = stringToArray(s1, length);
        int[] chs2 = stringToArray(s2, length);
        for (int i = 0; i < length; i++) {
            System.out.print(chs1[ i]);
        }
        System.out.println();
        for (int i = 0; i < length; i++) {
            System.out.print(chs2[ i]);
        }
        System.out.println();

        //进位
        int num = 0;
        //存储结果含最高位进位
        int[] chs3 = new int[length+1];
        for (int i = length-1; i >= 0; i--) {
            int sum =0;
            sum = chs1[i] + chs2[i] + num;
            //length为原来数组长度，现在有最高位进位，所以长度加1
            chs3[i+1] = sum % 10;
            num = sum / 10;

        }
        //此时只是计算完了原来两个数组的和，没有考虑最高位进位
        if(num != 0){
            chs3[0] = num;
        }
        for (int i = 0; i < chs3.length; i++) {
            System.out.print(chs3[i]);
        }
        System.out.println();

        //将结果转换为字符串
        StringBuilder sb = new StringBuilder();
        if(num != 0){
            sb.append(num);
        }
        for (int i = 1; i < chs3.length; i++) {
            sb.append(chs3[i]);
        }
        String result = sb.toString();
        System.out.println(result);

    }



    public static int[] stringToArray(String s,int length) {
        int[] chs = new int[length];
        int index = length-1;
        for (int i = s.length()-1; i >= 0; i--) {
            char ch = s.charAt(i);
            chs[index] = ch - '0';
            index--;
        }
        return chs;
    }
}
