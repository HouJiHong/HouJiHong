package com.HJh.test.oop.fileyongfa;

//递归查找文件并运行

import java.io.File;
import java.io.IOException;

public class ChaZhao {
    public static void main(String[] args) {
        File dir = new File("E:\\c");
        try {
            searchFile(dir,"devcpp.exe");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    /**
     * 递归查找文件
     * @param dir 想要在哪开始
     * @param s  查找的文件名
     */

    private static void searchFile(File dir, String s) throws Exception {
        //如果开始路径没有给或者路径不存在，不查找
        if (dir==null||!dir.exists()){
            return;
        }
        File[] files = dir.listFiles();
        //如果创建的文件对象数组为空或者长度为0，不查找
        if (files!=null||files.length > 0) {
            for (File file : files) {
                if (file.isFile()){
                    if (file.getName().contains(s)&&file.getName().endsWith(".exe")){
                        System.out.println(file.getAbsolutePath());
                        Runtime r = Runtime.getRuntime();//创建一个运行单例对象
                        r.exec(file.getAbsolutePath());
                    }
                }else {
                    searchFile(file,s);
                }
            }
        }else{
            System.out.println("没有找到");
            return;
        }
    }

}
