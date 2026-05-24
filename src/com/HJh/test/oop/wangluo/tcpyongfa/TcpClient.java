package com.HJh.test.oop.wangluo.tcpyongfa;
//Tcp通信通过管道socket

//TCP通信的实现一发一收
//客户端开发
//1.创建客户端的Socket对象，请求与服务端的连接。（客户端和服务端是通过socket连接的）
//2.使用socket对象调用getOutputStream()方法得到字节输出流。
//3.使用字节输出流完成数据的发送。
//4.释放资源：关闭socket管道。

//客户端程序就是通过java.net包下的socket类来实现的。
//public Socket(String host, int port)  根据指定的服务器ip、端口号请求与服务端建立连接，连接通过，就获得了客户端socket

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

//public OutputStream getOutputStream()     获得字节输出流对象
//public InputStream getInputStream()       获得字节输入流对象
public class TcpClient {
    public static void main(String[] args) throws Exception {
        System.out.println("客户端启动，实现一发一收..");
        //1.创建客户端的Socket对象，请求与服务端的连接。
        //参数1：指定服务器的ip地址
        //参数2：指定服务器的端口号
        Socket socket = new Socket("127.0.0.1", 8888);
        //2.使用socket对象调用getOutputStream()方法得到字节输出流。
        OutputStream os = socket.getOutputStream();
        //3.特殊数据流(随便什么流都行，但要和服务器接收的流一样)
        DataOutputStream dos = new DataOutputStream(os);
        //由于是DataOutputStream流，写一个发一个
        dos.writeInt(1);
        dos.writeUTF("这是客户端，你好！");
        //4.释放资源
        socket.close();

    }
}
