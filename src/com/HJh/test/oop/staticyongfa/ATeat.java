package com.HJh.test.oop.staticyongfa;
//static修饰的静态方法成为工具类，此时已经不能创建对象
//类名调用（推荐）
//对象名调用


//规范：如果这个方法只是为了做一个功能且不需要直接访问对象的数据，这个方法直接定义成静态方法
//如果这个方法是对象的行为，需要访问对象的数据，这个方法必须定义成实例方法

//在之前的练习中，有在同一个类中的main方法外定义了多个静态方法，main方法调用时没有用类名.方法名，是因为在同一个类中，所以可以省略类名
public class ATeat {


    public static void main(String[] args) {
        int [] arr = new int []{1,2,3,4,5,6,7,8,9,10};
        String res = ArrayUitl.printArray(arr);
        System.out.println(res);

        double avg = ArrayUitl.getAverage(arr);
        System.out.println(avg);
    }
}
