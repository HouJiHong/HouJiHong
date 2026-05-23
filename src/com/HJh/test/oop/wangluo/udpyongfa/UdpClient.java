package com.HJh.test.oop.wangluo.udpyongfa;
//UDP通信的实现
//DatagramSocket:用于创建客户端、服务端
//构造器
//public DatagramSocket()                       创建 客户端 的Socket对象，系统会随机分配一个端口号。
//public DatagramSocket(int port)               创建 服务端 的Socket对象，并指定端口号
//方法
//public void send(DatagramPacket dp)           发送数据包
//public void receive(DatagramPacket p)         使用数据包接收数据

//DatagramPacket：创建数据包
//构造器
//public DatagramPacket(byte[] buf，int length，InetAddress address，int port) 创建发出去的数据包对象
//public DatagramPacket(byte[] buf,int length)                                创建用来接收数据的数据包
//方法
//public int getLength()                        获取数据包，实际接收到的字节个数

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpClient {
    public static void main(String[] args) throws Exception {
        System.out.println("客户端启动，实现一发一收..");
        //1.创建发送端对象
        DatagramSocket socket = new DatagramSocket();
        //2.创建数据包，封装发送的数据
        /**
         * 参数1：发送的数据(字节数组)
         * 参数2：字节数组的长度
         * 参数3：目的地的ip
         * 参数4：目的的端口
         */
        byte[] bys = "这是客户端，你好！udp".getBytes();
        DatagramPacket dp = new DatagramPacket(bys, bys.length, InetAddress.getLocalHost(), 8080);

        //3.发送数据
        socket.send(dp);

        //4.关闭资源
        socket.close();

    }
}
