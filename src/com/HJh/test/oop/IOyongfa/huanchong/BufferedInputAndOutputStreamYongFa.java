package com.HJh.test.oop.IOyongfa.huanchong;
//缓冲字节输入/输出流
//作用：可以提高字节输入流读取数据的性能
//原理：缓冲字节输入流自带了8KB缓冲池；缓冲字节输出流也自带了8KB缓冲池。

//public BufferedInputStream(InputStream is)    把低级的字节输入流包装成一个高级的缓冲字节输入流，从而提高读数据的性能
//public BufferedOutputStream(OutputStream os)  把低级的字节输出流包装成一个高级的缓冲字节输出流，从而提高写数据的性能

import java.io.*;

public class BufferedInputAndOutputStreamYongFa {
    public static void main(String[] args) {
        copyFile("E:\\桌面\\信息安全.txt","E:\\桌面\\信息1.txt");
    }

    private static void copyFile(String s, String s1) {
        try (
                //先创建输入流，再创建缓冲输入流
                InputStream is = new FileInputStream(s);
                InputStream bis = new BufferedInputStream(is);
                OutputStream os = new FileOutputStream(s1);
                OutputStream bos = new BufferedOutputStream(os);
        ) {

            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }

            System.out.println("拷贝成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
