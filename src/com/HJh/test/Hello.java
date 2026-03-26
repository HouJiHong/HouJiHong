package com.HJh.test;

public class Hello {
    public static void main(String[] args) {
        //BMI=体重/身高的平方

        //1.定义变量记录我的体重68.9KG
        double weight = 68.9;

        //2.定义变量记录我的身高1.75M
        double height = 1.75;

        //3.计算BMI
        double bmi = weight / (height * height);
        System.out.println("BMI=" + bmi);

        double maxWeight;
         maxWeight=23.9*height*height;

         System.out.println("最大体重="+maxWeight+"KG");
    }


}
