package com.HJh.test.oop.IOyongfa.huanchong;
//缓冲字符输入流
//作用：自带8K（8192）的字符缓冲池，可以提高字符输入流读取字符数据的性能。

//public BufferedReader(Reader r)   把低级的字符输入流包装成字符缓冲输入流管道，从而提高字符输入流读字符数据的性能

//字符缓冲输入流新增的功能：按照行读取字符
//public String readLine()   读取 一行 数据返回，如果没有数据可读了，会返回nu11

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

public class BufferedReaderYongFa {
    public static void main(String[] args) {
        try (
                //先创建输入流，再创建缓冲输入流
                Reader r = new FileReader("filecaozuo.txt");
                BufferedReader br = new BufferedReader(r);
        ){
//            char[] buffer = new char[3];
//            int len;
//            while ((len = br.read(buffer)) != -1) {
//                System.out.print(new String(buffer,0,len));
//            }

            //按照行读取,不会发生截断
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
