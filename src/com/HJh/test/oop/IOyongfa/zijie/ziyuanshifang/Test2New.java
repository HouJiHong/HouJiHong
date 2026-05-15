package com.HJh.test.oop.IOyongfa.zijie.ziyuanshifang;

import java.io.*;
//资源释放用try-with-resources
//try(定义资源1;定义资源2;..){
//  可能出现异常的代码；
//}catch(异常类名变量名）
//  异常的处理代码；

public class Test2New {
    public static void main(String[] args) {

            copyFile("E:\\桌面\\信息安全.txt","E:\\桌面\\信息.txt");


    }

    private static void copyFile(String s, String s1) {
        try (
                //此处只能放资源，最终实现了AutoCloseable接口的都是资源，会自动调用close方法
                InputStream is = new FileInputStream(s);//建立输入流管道与源文件接通
                OutputStream os = new FileOutputStream(s1);//建立输出流管道与目标文件接通
        ) {

            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer, 0, len);//必须限制读取字节个数
            }

            System.out.println("拷贝成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
