package com.HJh.test.oop.IOyongfa.qita;
//PrintStream/PrintWriter（打印流）
//作用：打印流可以实现更方便、更高效的打印数据出去，能实现打印啥出去就是啥出去。
//PrintStream提供的打印数据的方案

//public PrintStream(OutputStream/File/String)              打印流直接通向字节输出流/文件/文件路径
//public PrintStream(String fileName,Charset charset)       可以指定写出去的字符编码
//public PrintStream(OutputStream out,boolean autoFlush)    可以指定实现自动刷新
//public PrintStream(OutputStream out,boolean autoFlush，String encoding)    可以指定实现自动刷新，并可指定字符的编码

//public void println(Xxx xx)                   打印任意类型的数据出去
//public void write(int/byte[]/byte[]一部分）    可以支持写字节数据出去

import java.io.FileWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

public class PrintStreamAndPrintWriter {
    public static void main(String[] args) {
        try (
                //创建打印流对象
                //PrintStream ps = new PrintStream("fileshuchucaozuo.txt");
                PrintWriter ps = new PrintWriter(new FileWriter("fileshuchucaozuo.txt", true));
        ){
            ps.println(97);
            ps.println('b');
            ps.println("我");


            ps.println("我爱你520");

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
