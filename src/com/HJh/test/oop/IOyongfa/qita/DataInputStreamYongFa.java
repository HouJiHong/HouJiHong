package com.HJh.test.oop.IOyongfa.qita;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class DataInputStreamYongFa {
    public static void main(String[] args) {
        try (
                //创建字节输入流管道与源文件接通
                InputStream is = new FileInputStream("fileshuchucaozuo.txt");
                //创建字节输入流管道包装成数据输入流管道
                DataInputStream dis = new DataInputStream(is);
        ) {
            //怎么写文件的，就怎么读文件，不能多也不能少
            System.out.println(dis.readByte());
            System.out.println(dis.readInt());
            System.out.println(dis.readDouble());
            System.out.println(dis.readUTF());
            System.out.println(dis.read());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
