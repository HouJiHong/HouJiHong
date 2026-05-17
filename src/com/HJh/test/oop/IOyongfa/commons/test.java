package com.HJh.test.oop.IOyongfa.commons;
//Commons-io是apache开源基金组织提供的一组有关IO操作的小框架，目的是提高Io流的开发效率。(需要导入jar包)

//FileUtils类
//public static void copyFile(File srcFile,File destFile)               复制文件。
//public static void copyDirectory(File srcDir,File destDir)            复制文件夹
//public static void deleteDirectory(File directory)                    删除文件夹
//public static String readFileToString(File file, String encoding)     读数据
//public static void writeStringToFile(File file, String data, String charname,boolean append)  写数据

//IOUtils类
//public static int copy(InputStream inputStream, OutputStream outputStream)        复制文件。
//public static int copy(Reader reader,Writer writer)                               复制文件。
//public static void write(String data, OutputStream output, String charsetName)    写数据

import org.apache.commons.io.FileUtils;

import java.io.File;

public class test {
    public static void main(String[] args) {
        try {
            FileUtils.copyFile(new File("E:\\桌面\\信息.txt"),new File("E:\\桌面\\信息1.txt"));
            FileUtils.copyDirectory(new File("E:\\桌面\\信息"),new File("E:\\桌面\\信息1"));
            FileUtils.deleteDirectory(new File("E:\\桌面\\信息1"));
            System.out.println(FileUtils.readFileToString(new File("E:\\桌面\\信息.txt"),"utf-8"));
            FileUtils.writeStringToFile(new File("E:\\桌面\\信息1.txt"),"HJh", "utf-8",true);
            System.out.println(FileUtils.readFileToString(new File("E:\\桌面\\信息1.txt"),"utf-8"));



        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }
}
