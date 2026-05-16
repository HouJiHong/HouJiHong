package com.HJh.test.oop.IOyongfa.huanchong;
//缓冲字符输出流
//作用：自带8K的字符缓冲池，可以提高字符输出流写字符数据的性能。

//public BufferedWriter(Writer r)   把低级的字符输出流包装成一个高级的缓冲字符输出流管道，从而提高字符输出流写数据的性能

//字符缓冲输出流新增的功能：换行(代替\r\n)
//public void newLine() 换行

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;

public class BufferedWriterYongFa {
    public static void main(String[] args) {
        try (
                //先创建输出流，再创建缓冲输出流
                Writer w = new FileWriter("fileshuchucaozuo.txt", true);
                BufferedWriter bw = new BufferedWriter(w);
        ){
            //1.写入一个字符
            bw.write(97);
            bw.write('b');
            bw.write("我");
            bw.newLine(); //换行

            //2.写入一个字符串
            bw.write("我爱你520");
            bw.write("我爱你520",0,2);
            bw.write("\r\n");

            //3.写入一个字符数组
            bw.write(new char[]{'a','b','c'});
            char[] cbuf = "哈哈牛逼".toCharArray();
            bw.write(cbuf);
            bw.write(cbuf,0,2);
            bw.newLine();

            //w.flush();//刷新缓冲区,将缓冲区中的数据写出去,刷新可以接着写入
            //w.close();//关闭流包含flush刷新缓冲区,关闭流后不能再写入,由于使用了try-with-resources,所以不需要手动关闭流


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
