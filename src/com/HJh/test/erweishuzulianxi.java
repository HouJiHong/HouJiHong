package com.HJh.test;

import java.util.Random;

public class erweishuzulianxi {
    public static void main(String[] args) {
        String[][] zuoWei = new String[][]{
                {"张三", "李四", "王五"},
                {"李六", "王七", "赵八", "小九"},
                {"小十", "小十一"},
                {"小十三", "小十四", "小十五"}};
        printStr(zuoWei);
        System.out.println("开始换座位");
        String[][] result = huanZuoWei(zuoWei);
        System.out.println("换座位结束");
        printStr(result);
    }

    public static void printStr(String[][] str) {
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str[i].length; j++) {
                System.out.print(str[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static String[][] huanZuoWei(String[][] zuoWei) {
        int strLength = zuoWei.length * zuoWei[0].length;
        String[] str = new String[strLength];
        int index = 0;
        for (int i = 0; i < zuoWei.length; i++) {
            for (int j = 0; j < zuoWei[i].length; j++) {
                str[index++] = zuoWei[i][j];
            }
        }
        Random r = new Random();
        for (int i = 0; i < str.length; i++) {
            int rNum = r.nextInt(str.length);
            String temp = str[i];
            str[i] = str[rNum];
            str[rNum] = temp;
        }
        index = 0;
        for (int i = 0; i < zuoWei.length; i++) {
            for (int j = 0; j < zuoWei[i].length; j++) {
                zuoWei[i][j] = str[index++];
            }
        }
        return zuoWei;
    }

}

