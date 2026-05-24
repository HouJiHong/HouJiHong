package com.HJh.test.oop.wangluo.tcpyongfa;

//TCP通信的实现一发一收一服务端开发
//1.创建ServerSocket对象，注册服务端端口。
//2.调用ServerSocket对象的accept()方法，等待客户端的连接，并得到Socket管道对象。
//3.通过Socket对象调用getInputStream()方法得到字节输入流、完成数据的接收。
//4.释放资源：关闭socket管道

//服务端是通过java.net包下的ServerSocket类来实现的。
//public ServerSocket(int port)     为服务端程序注册端口

//public Socket accept()    阻塞等待客户端的连接请求，一旦与某个客户端成功连接，则返回服务端这边的Socket对象。

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) throws Exception {
        System.out.println("服务端启动了，只能接收一个客户端...");
        //1.创建ServerSocket对象，注册服务端端口
        ServerSocket ss = new ServerSocket(8888);
        //2.调用ServerSocket对象的accept()方法，等待客户端的连接，并得到Socket管道对象
        Socket socket = ss.accept();
        //3.通过Socket对象调用getInputStream()方法得到字节输入流、完成数据的接收
        InputStream is = socket.getInputStream();
        //4.与对方统一输入输出流
        DataInputStream dis = new DataInputStream(is);
        //5.接收数据
        //由于是DataInputStream，所以收一个存一个
        int id = dis.readInt();
        String data = dis.readUTF();
        System.out.println("id:"+id+" data:"+data);
        //6.打印客户端ip和端口
        System.out.println("客户端ip:"+socket.getInetAddress().getHostAddress()+" 端口:"+socket.getPort());
    }
}
