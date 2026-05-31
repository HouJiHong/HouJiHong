package com.HJh.test.oop.zhujie.zhujiejiexi;

import java.lang.reflect.Method;
import java.util.Arrays;



public class AnnotationTest {
    public static void main(String[] args) {
        parseClass();//获取类注解
        parseMethod();//获取方法注解
    }

    private static void parseMethod() {
        //1.获取Class对象
        Class c1 = test.class;
        //2.获取所有方法对象
        Method[] methods = c1.getDeclaredMethods();
        for (Method m:methods) {
            //判断方法上是否有注解
            if(m.isAnnotationPresent(MyTest.class)){
                //3.获取注解对象
                MyTest myTest = m.getDeclaredAnnotation(MyTest.class);
                //4.获取注解的属性值
                String value = myTest.value();
                double price = myTest.price();
                String[] address = myTest.address();
                System.out.println(value);
                System.out.println(price);
                System.out.println(Arrays.toString( address));
            }
        }
    }

    private static void parseClass() {
        //1.获取Class对象
        Class c1 = test.class;
        //2.判断这个类上是否有注解Mytest
        if(c1.isAnnotationPresent(MyTest.class)){
            //3.获取注解对象
            MyTest myTest = (MyTest) c1.getDeclaredAnnotation(MyTest.class);
            //4.获取注解的属性值
            String value = myTest.value();
            double price = myTest.price();
            String[] address = myTest.address();
            System.out.println(value);
            System.out.println(price);
            System.out.println(Arrays.toString( address));
        }

    }
}
