package com.HJh.test;

import java.util.Random;

public class yiweishuzulianxi {
    public static void main(String[] args) {
        System.out.println("开始做牌");
        String[] poker =zuoPai();
        printPoker( poker);
        System.out.println("开始洗牌");
        String[] pokerAfter = xiPai(poker);
        printPoker( poker);
    }
    public static String[] zuoPai(){
        String[] poker = new String[54];
        String[] colors = {"♠","♥","♣","♦"};
        String[] numbers = {"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
        int index = 0;
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < numbers.length ; j++) {
                poker[index] = colors[i]+numbers[j];
                index++;
            }
        }
        poker[index++] = "🃏";
        poker[index] = "🤡";
        System.out.println("\n做牌完成");
        return poker;
    }
    public static String[] xiPai(String[] poker){
        Random r = new Random();
        for (int i = 0; i < poker.length; i++) {
            int index = r.nextInt(poker.length);
            String temp = poker[i];
            poker[i] = poker[index];
            poker[index] = temp;
        }
        System.out.println("洗牌完成");
        return poker;
    }
    public static void printPoker(String[] poker){
        for (int i = 0; i < poker.length; i++) {
            System.out.print(poker[i]+" ");
            if ((i+1)%13 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

}
