package com.HJh.test.oop.fileyongfa;

import java.io.UnsupportedEncodingException;

//String类提供了对字符进行编码和解码的方法
//对字符的编码
//byte[] getBytes()                        使用平台的默认字符集将该String编码为一系列字节，将结果存储到新的字节数组中
//byte[] getBytes(String charsetName)      使用指定的字符集将该String编码为一系列字节，将结果存储到新的字节数组中
//对字符的解码
//String(byte[] bytes)                     通过使用平台的默认字符集解码指定的字节数组来构造新的String
//String(byte[] bytes, String charsetName) 通过指定的字符集解码指定的字节数组来构造新的String
public class ZiFuJi {
    public static void main(String[] args) throws Exception {
        String s1 = "我爱你520！I LOVE YOU";
        byte[] bytes = s1.getBytes("GBK");
        System.out.println(bytes.length);
        String s2 = new String(bytes,"GBK");
        System.out.println(s2);
    }

}
