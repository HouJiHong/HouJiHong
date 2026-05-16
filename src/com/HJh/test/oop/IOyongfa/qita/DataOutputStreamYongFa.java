package com.HJh.test.oop.IOyongfa.qita;
//DataOutputStream数据输出流
//允许把数据和其类型一并写出去。

//public DataOutputStream(OutputStream out)                    创建新数据输出流包装基础的字节输出流

//public final void writeByte(int v) throws IOException        将byte类型的数据写入基础的字节输出流
//public final void writeInt(int v) throws IOException         将int类型的数据写入基础的字节输出流
//public final void writeDouble(Double v) throws IOException   将double类型的数据写入基础的字节输出流
//public final void writeUTF(String str) throws IOException    将字符串数据以UTF-8编码成字节写入基础的字节输出流
//public void write(int/byte[]/byte[]一部分）                   支持写字节数据出去

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataOutputStreamYongFa {
    public static void main(String[] args) { //写到文件里的数据是带类型的，文件不是用来看的会乱码，是给对方对应的接收
        try (
                DataOutputStream dos = new DataOutputStream(new FileOutputStream("fileshuchucaozuo.txt"));
        ) {
            dos.writeByte(127);
            dos.writeInt(100);
            dos.writeDouble(100.0);
            dos.writeUTF("HJh");
            dos.write("HJh".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
