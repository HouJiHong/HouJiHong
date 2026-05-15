package com.HJh.test.oop.IOyongfa.zijie.ziyuanshifang;

import java.io.*;

//资源释放可以用try-catch finally（过时）

public class Test1Old {
    public static void main(String[] args)  {

        copyFile("E:\\桌面\\信息安全.txt","E:\\桌面\\信息.txt");


    }

    private static void copyFile(String s, String s1)  {
        InputStream is = null;//由于is和os在try中，是局部变量，在后面的close中无法访问，所以要定义为成员变量
        OutputStream os = null;
        try {
            is = new FileInputStream(s);//建立输入流管道与源文件接通
            os = new FileOutputStream(s1);//建立输出流管道与目标文件接通
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer,0,len);//必须限制读取字节个数
            }

            System.out.println("拷贝成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {//由于担心close时，对象可能为null，所以要判断对象是否为null
            try {
                if (is != null)is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (os != null)os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
