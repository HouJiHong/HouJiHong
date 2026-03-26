package com.HJh.test.oop.staticyongfa;
//static修饰的静态方法成为工具类，此时已经不能创建对象
//类名调用（推荐）
//对象名调用
public class ATeat {


    public static void main(String[] args) {
        int [] arr = new int []{1,2,3,4,5,6,7,8,9,10};
        String res = ArrayUitl.printArray(arr);
        System.out.println(res);

        double avg = ArrayUitl.getAverage(arr);
        System.out.println(avg);
    }
}
