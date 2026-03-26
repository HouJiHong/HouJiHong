package com.HJh.test.oop.staticyongfa;

public class ArrayUitl {
    //私有化构造方法，目的：不让外界创建对象
    private ArrayUitl(){}


    //直接显示遍历结果

    /*public static void printArray(int[] a){
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            if(i==a.length-1){
                System.out.println(a[i]+"]");
            }else{
                System.out.print(a[i]+", ");
            }
        }
    }*/


    //定义方法（静态）


    //main方法是static静态方法，静态方法只能调用静态方法，想要调用非静态方法，必须创建对象
    //但由于已经私有化构造方法，无法创建对象，所以只能定义静态方法，通过类名调用
    //遍历数组，组合成字符串返回
    public static String printArray(int[] a){
        String result = "[";
        for (int i = 0; i < a.length; i++) {
            if(i==a.length-1){
                result=result+a[i]+"]";
            }else{
                result=result+a[i]+", ";
            }
        }
        return result;
    }

    public static double getAverage(int[] a){
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return (double)sum/a.length;
    }


}
