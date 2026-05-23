package com.HJh.test.oop.wangluo.udpyongfa;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServer {
    public static void main(String[] args) throws Exception {
        System.out.println("服务器启动了...");
        //1.创建服务端接收对象
        DatagramSocket socket = new DatagramSocket(8080);
        //2.创建数据包，封装接收数据
        byte[] bys = new byte[1024*64];
        DatagramPacket dp = new DatagramPacket(bys, bys.length);

        //3.接收数据，封装到数据包中
        socket.receive(dp);

        //4.解析数据包
        String data = new String(dp.getData(),0,dp.getLength());
        System.out.println("服务器接收到："+data);

        //5.获取发送端的ip和端口
        String ip = dp.getAddress().getHostAddress();
        int port = dp.getPort();
        System.out.println("客户端ip:"+ip+" port:"+port);


    }
}
