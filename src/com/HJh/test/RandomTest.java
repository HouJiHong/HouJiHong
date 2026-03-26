package com.HJh.test;

import java.util.Random;
import java.util.Scanner;

public class RandomTest {
    public static void main(String[] args) {
        /*Random r=new Random();
        int num=r.nextInt();
        int num2=r.nextInt(10);//0-9
        int num3=r.nextInt(1,10);//1-9*/

        Random r=new Random();
        int number=r.nextInt(1,101);
        System.out.println(number);

        int countA=0;
        int countB=0;

        while (true) {
            Scanner sc=new Scanner(System.in);
            System.out.println("请输入猜测的数字：");
            int guessNumber=sc.nextInt();

            countA++;
            countB++;

            if(countB==10){
                guessNumber=number;
            }

            if(guessNumber<number){
                System.out.println("猜的数字小了");
            }else if(guessNumber>number){
                System.out.println("猜的数字大了");
            }else{
                System.out.println("恭喜你猜对了");
                break;
            }

            if(countA%3==0){
                System.out.println("小保底，数字在"+(number-5)+"到"+(number+5)+"之间");
            }
        }
    }
}
