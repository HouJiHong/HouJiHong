package com.HJh.test.oop.exceptionyongfa.jichu;
//关于异常，有一个总父类throwable，它有子类Exception和Error
//error：叫错误，它代表的是系统级错误。

//Exception：叫异常，它代表的才是我们程序可能出现的问题，所以，
//我们程序员通常会用Exception以及它的孩子来封装程序出现的问题。
//运行时异常：
//RuntimeException及其子类，编译阶段不会出现错误提醒，运行时出现的异常（如：数组索引越界异常）
//编译时异常：
//除了运行时异常都叫其他异常，编译阶段就会出现错误提醒的。（如：日期解析异常）
//这类异常一般是提醒程序员这段代码很容易出错，需要进行异常的处理（可能是没有错）

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//出现异常，有两种处理方式：
//1.try...catch...finally
//2.通过在方法加上throws关键字来抛异常，抛给调用者处理，
// 调用者可以用try...catch...finally来处理或者继续抛给上一级处理
public class test {
    public static void main(String[] args) {
        //show();//运行时异常

        try {//编译时异常，用try...catch...finally来处理或者继续抛给上一级处理
            show2();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static void show2() throws ParseException, FileNotFoundException {//抛异常给调用者处理
        System.out.println("show2方法开始执行...");
        String str = "2026-04-29 16:11:59";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(str);
        System.out.println(date);

        //如果一个方法出现多个异常，那么就可以用try...catch...finally来处理或者继续抛给上一级处理，
        //在抛多个异常时，可以直接抛exception来包含所有的异常，
        // 在使用try...catch时不需要catch多次，只需要catch exception就行
        InputStream is = new FileInputStream("d:/test.txt");



        System.out.println("show方法结束执行...");
    }

    private static void show() {
        System.out.println("show方法开始执行...");
        int[] arr = {1,2,3};
        System.out.println(arr[10]);

        System.out.println("show方法结束执行...");
    }

}
