package com.HJh.test.oop.zhujie.zhujieFrame;

//使用注解开发出一个简易版的Junit框架
//需求
//●定义若干个方法，只要加了MyTest注解，就会触发该方法执行。
//分析
//1.定义一个自定义注解MyTest，只能注解方法，存活范围是一直都在。
//2.定义若干个方法，部分方法加上@MyTest注解修饰，部分方法不加。
//3.模拟一个junit程序，可以触发加了@MyTest注解的方法执行。

import java.lang.reflect.Method;

public class test {
    public static void main(String[] args) {
        //创建test对象，用于调用
        test test = new test();
        //1.获取Class对象
        Class c1 = test.class;
        //2.获取所有方法
        Method[] methods = c1.getDeclaredMethods();
        //3.遍历方法,判断是否有@MyTest注解，如果有，则执行该方法
        for (Method m:methods) {
            if (m.isAnnotationPresent(MyTest.class)){
                try {
                    //可以通过获取注解对象，解析注解属性，用属性的值控制循环次数
                    MyTest myTest = m.getDeclaredAnnotation(MyTest.class);
                    int value = myTest.value();
                    for (int i = 0; i < value; i++) {
                        m.invoke(test);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


    }
    @MyTest(value = 3)
    public void test1(){
        System.out.println("测试方法1");
    }
    public void test2(){
        System.out.println("测试方法2");
    }
    @MyTest()
    public void test3(){
        System.out.println("测试方法3");
    }
    public void test4(){
        System.out.println("测试方法4");
    }
    public void test5(){
        System.out.println("测试方法5");
    }

}
