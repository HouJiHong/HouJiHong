package com.HJh.test.oop.wangluo.tcpyongfa.duoclient;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServerS {
    public static void main(String[] args) throws Exception {
        System.out.println("服务端启动了，接收多个客户端...");
        //1.创建ServerSocket对象，注册服务端端口
        ServerSocket ss = new ServerSocket(8888);
        while (true) {
            //2.调用ServerSocket对象的accept()方法，等待客户端的连接，并得到Socket管道对象
            Socket socket = ss.accept();
            //一旦一个客户端连接，就会产生一个Socket管道对象，服务端就知道客户端上线了
            System.out.println("一个客户端上线了..."+socket.getInetAddress().getHostAddress()+":"+socket.getPort());
            //3.把客户端管道交给一个服务端线程处理
            new ServerThread(socket).start();
        }

    }
}
