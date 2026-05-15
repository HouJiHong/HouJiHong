package com.HJh.test.oop.IOyongfa.zijie;


import java.io.*;

//使用字节流拷贝文件
//源文件E:\桌面\信息安全.txt
//目标文件E:\桌面\信息.txt(目标文件必须手动写新文件名)
public class FuZhiWenJian {
    public static void main(String[] args) {
        try {
            copyFile("E:\\桌面\\信息安全.txt","E:\\桌面\\信息.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private static void copyFile(String s, String s1) throws Exception {
        InputStream is = new FileInputStream(s);//建立输入流管道与源文件接通
        OutputStream os = new FileOutputStream(s1);//建立输出流管道与目标文件接通
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            os.write(buffer,0,len);//必须限制读取字节个数
        }
        is.close();//此资源释放比较low，如果在代码中有异常，则无法释放资源，看资源释放
        os.close();
        System.out.println("拷贝成功");
    }
}
