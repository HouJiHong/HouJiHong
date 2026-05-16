package com.HJh.test.oop.IOyongfa;
//按照流方向：IO流分为
//输入流：从数据源（文件、键盘、网络）中读取数据到内存
//输出流：将内存中的数据写入到数据源（文件、键盘、网络）
//按照流的内容：IO流分为
//字节流
//字符流

//(读取文本适合用字符流；字节流适合做数据的转移，比如：文件复制)
//抽象类
    //字节输入流InputStream（读字节数据的）
    //字节输出流OutputStream（写字节数据出去的)
    //字符输入流Reader（读字符数据的）
    //字符输出流Writer（写字符数据出去的）
//实现类
    //FileInputStream
    //FileOutputStream
    //FileReader
    //FileWriter

    //缓冲输入输出流（为实现类的高性能版）先创建普通的流，再创建缓冲输入输出流包裹普通流
    //BufferedInputStream
    //BufferedOutputStream
    //BufferedReader
    //BufferedWriter




//(抽象类)                                                  IO流体系
//                       字节流                                                字符流
//(抽象类)          字节输入流               字节输出流                   字符输入流                       字符输出流
//(抽象类)          InputStream             OutputStream                Reader                          Writer
//(实现类)          FileInputStream         FileOutputStream            FileReader                      FileWriter
//(实现类)          BufferedInputStream     BufferedOutputStream        BufferedReader                  BufferedWriter
//(实现类)                                                              InputStreamReader
//(实现类)                                  PrintStream                                                 PrintWriter
//(实现类)          DataInputStream         DataOutputStream
public class test {
    public static void main(String[] args) {

    }
}
