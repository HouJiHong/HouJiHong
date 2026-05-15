package com.HJh.test.oop.IOyongfa.zifu;
//FileWriter字符输出流
//作用：以内存为基准，把内存中的数据以字符的形式写出到文件中去。

//public FileWriter(File file)                  创建字节输出流管道与源文件对象接通
//public FileWriter(String filepath)            创建字节输出流管道与源文件路径接通
//public FileWriter(File file,boolean append)   创建字节输出流管道与源文件对象接通，可追加数据
//public FileWriter(String filepath, boolean append)    创建字节输出流管道与源文件路径接通，可追加数据

//void write(int c)                         写一个字符
//void write(String str)                    写一个字符串
//void write(String str,int off,int len)    写一个字符串的一部分
//void write(char[] cbuf)                   写入一个字符数组
//void write(char[] cbuf,int off, int len)  写入字符数组的一部分

import java.io.FileWriter;
import java.io.Writer;

public class WriterYongFa {
    public static void main(String[] args) {
        try (
                Writer w = new FileWriter("fileshuchucaozuo.txt", true)
        ){
            //1.写入一个字符
            w.write(97);
            w.write('b');
            w.write("我");
            w.write("\r\n");

            //2.写入一个字符串
            w.write("我爱你520");
            w.write("我爱你520",0,2);
            w.write("\r\n");

            //3.写入一个字符数组
            w.write(new char[]{'a','b','c'});
            char[] cbuf = "哈哈牛逼".toCharArray();
            w.write(cbuf);
            w.write(cbuf,0,2);
            w.write("\r\n");

            //w.flush();//刷新缓冲区,将缓冲区中的数据写出去,刷新可以接着写入
            //w.close();//关闭流包含flush刷新缓冲区,关闭流后不能再写入,由于使用了try-with-resources,所以不需要手动关闭流


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
