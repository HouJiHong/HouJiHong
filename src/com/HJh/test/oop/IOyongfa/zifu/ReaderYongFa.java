package com.HJh.test.oop.IOyongfa.zifu;
//字符输入流
//public FileReader(File file)          创建字符输入流管道与源文件接通
//public FileReader(String pathname)    创建字符输入流管道与源文件接通


//public int read()                 每次读取一个字符返回，如果发现没有数据可读会返回-1.
//public int read(char[] buffer)    每次用一个字符数组去读取数据，返回字符数组读取了多少个字符，
                                    //如果发现没有数据可读会返回-1.

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class ReaderYongFa {
    public static void main(String[] args) {
        try (
                Reader r = new FileReader("filecaozuo.txt")
        ){
            char[] buffer = new char[3];
            int len;
            while ((len = r.read(buffer)) != -1) {
                System.out.print(new String(buffer,0,len));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
