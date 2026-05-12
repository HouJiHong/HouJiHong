package com.HJh.test.oop.fileyongfa;

//File其对象代表具体的文件，只能操作文件本身
//IO流 读写数据

//File类的对象可以代表文件/文件夹，并可以调用其提供的方法对象文件进行操作。
//创建File类的对象
//public File(String pathname)      根据文件路径创建文件对象
//注意:
    //File对象既可以代表文件、也可以代表文件夹。
    //File封装的对象仅仅是一个路径名，这个路径可以是存在的，也允许是不存在的。

//public boolean exists()           判断当前文件对象，对应的文件路径是否存在，存在返回true
//public boolean isFile()           判断当前文件对象指代的是否是文件，是文件返回true
//public boolean isDirectory()      判断当前文件对象指代的是否是文件夹，是文件夹返回true
//public String getName()           获取文件的名称（包含后缀）
//public long length()              获取文件的大小，返回字节个数
//public long lastModified()        获取文件的最后修改时间。
//public String getPath()           获取创建文件对象时，使用的路径
//public String getAbsolutePath()   获取绝对路径

//File类提供的遍历文件夹的功能
//public String[] list()            获取当前目录下所有的“一级文件名称“到一个字符串数组中去返回。
//public File[] listFiles()         获取当前目录下所有的"一级文件对象“到一个文件对象数组中去返回（重点）

//使用listFiles方法时的注意事项：
//        当主调是文件，或者路径不存在时，返回null
//        当主调是空文件夹时，返回一个长度为0的数组
//        当主调是一个有内容的文件夹时，将里面所有一级文件和文件夹的路径放在File数组中返回
//        当主调是一个文件夹，且里面有隐藏文件时，将里面所有文件和文件夹的路径放在File数组中返回，包含隐藏文件
//        当主调是一个文件夹，但是没有权限访问该文件夹时，返回null

import java.io.File;

public class test {
    public static void main(String[] args) {
        File f1 = new File("E:\\JavaProject\\HelloWorld\\filecaozuo.txt");
        System.out.println(f1.length());
        System.out.println(f1.getName());

        //创建文件对象,如果文件不存在,则创建文件
        File f2 = new File("E:\\JavaProject\\HelloWorld\\filecaozuo2.txt");
        if(!f2.exists()){
            try {
                f2.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //创建不存在的文件夹
        File f3 = new File("E:\\JavaProject\\HelloWorld\\filecaozuo3");
        System.out.println(f3.mkdir());//创建一级文件夹
        File f4 = new File("E:\\JavaProject\\HelloWorld\\filecaozuo4\\filecaozuo5");
        System.out.println(f4.mkdirs());//创建多级文件夹
        //删除文件(只能删空文件夹)
        System.out.println(f2.delete());

        //获取当前目录下所有的"一级文件名称"
        File f5 = new File("E:\\JavaProject\\HelloWorld");
        String[] names = f5.list();
        for(String name : names){
            System.out.println(name);
        }

        //获取当前目录下所有的"一级文件对象"
        File[] files = f5.listFiles();
        for(File file : files){
            System.out.println(file.getAbsoluteFile());//获取绝对路径
        }


    }
}
