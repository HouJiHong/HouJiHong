package com.HJh.test.oop.IOyongfa.qita;
//InputStreamReader字符输入流转换流
//解决不同编码时，字符流读取文本内容乱码的问题。
//解决思路：先获取文件的原始字节流，再将其按真实的字符集编码转成字符输入流，这样字符输入流中的字符就不乱码了。

//public InputStreamReader(InputStream is)      把原始的字节输入流，按照代码默认编码转成字符输入流（与直接用FileReader的效果一样）
//public InputStreamReader(InputStream is，String charset)   把原始的字节输入流，按照指定字符集编码转成字符输入流（重点）

import java.io.*;

public class InputStreamReaderYongFa {
    public static void main(String[] args) {
        try (
                //先提取原始字节输入流
                InputStream is = new FileInputStream("filecaozuo.txt");//假如这个文件是GBK编码，但是我需要用UTF-8编码
                //指定字符集把原始字节输入流转换成字符输入流
                Reader isr = new InputStreamReader(is,"GBK");
                //创建缓冲输入流包装字符输入流
                BufferedReader br = new BufferedReader(isr);
        ) {
            //按照字符读取
            String line;
            while ((line = br.readLine()) != null) {
                System.out.print(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
