package com.HJh.test.oop.IOyongfa.zijie;

//FileoutputStrean文件字节输出流
//作用：以内存为基准，把内存中的数据以字节的形式写出到文件中去。

//public FileOutputStream(File file)        创建字节输出流管道与源文件对象接通
//public FileOutputStream(String filepath)  创建字节输出流管道与源文件路径接通
//public FileOutputStream(File file,boolean append)         创建字节输出流管道与源文件对象接通，可追加数据
//public FileOutputStream(String filepath,boolean append)   创建字节输出流管道与源文件路径接通，可追加数据

//public void write(int a)                  写一个字节出去
//public void write(byte[] buffer)          写一个字节数组出去
//public void write(byte[] buffer ，int pos ，int len)    写一个字节数组的一部分出去。
//public void close() throws IOException    关闭流。

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class OutputStreamYongFa {
    public static void main(String[] args) throws Exception {
        //1.创建字节输出流管道
        //OutputStream os = new FileOutputStream("fileshuchucaozuo.txt"); //此为覆盖管道
        OutputStream os = new FileOutputStream("fileshuchucaozuo.txt", true); //此为追加管道

        //2.写数据
        os.write(97);//写一个字节出去
        os.write('b');//写一个字节出去(字母是一个字节)
        //os.write('哈');//乱码
        os.write("\r\n".getBytes());//换行

        byte[] bytes = {97,98,99};//字节数组
        os.write(bytes);//写字节数组出去
        os.write("\r\n".getBytes());//换行

        byte[] bytes2 = "我爱你520".getBytes();
        os.write(bytes2);//字符串转字节数组
        os.write("\r\n".getBytes());//换行

        os.write(bytes2,0,3);//字节数组的一部分出去,第0个字节开始，写3个字节(汉字三个字节，所以写入一个字)
        os.write("\r\n".getBytes());//换行

        os.close();//关闭流

    }
}
