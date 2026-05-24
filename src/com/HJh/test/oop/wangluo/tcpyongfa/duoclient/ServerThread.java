package com.HJh.test.oop.wangluo.tcpyongfa.duoclient;
//由于在tcp中客户端和服务端是需要建立socket连接，想要多个客户端连接，所以需要创建多个线程，每一个服务端线程对应一个客户端

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ServerThread extends  Thread{
    private Socket socket;
    public ServerThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            //3.通过Socket对象调用getInputStream()方法得到字节输入流、完成数据的接收
            InputStream is = socket.getInputStream();
            //4.与对方统一输入输出流
            DataInputStream dis = new DataInputStream(is);
            while (true) {
                //5.接收数据
                String data = dis.readUTF();
                System.out.println("data:"+data);
                //6.打印客户端ip和端口
                System.out.println("客户端ip:"+socket.getInetAddress().getHostAddress()+" 端口:"
                        +socket.getPort());

            }
        } catch (Exception e) {
            //由于客户端和服务端是连接绑定的，所以当客户端断开连接时，服务端会报异常，所以这里可以
            // 通过捕获异常来判断客户端是否已断开连接
            System.out.println("客户端已下线..."+socket.getInetAddress().getHostAddress()+" "+socket.getPort());
        }

    }
}
