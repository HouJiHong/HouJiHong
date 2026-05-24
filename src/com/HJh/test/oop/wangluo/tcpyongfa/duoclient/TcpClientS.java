package com.HJh.test.oop.wangluo.tcpyongfa.duoclient;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TcpClientS {
    public static void main(String[] args) throws Exception {
        System.out.println("客户端启动，实现多发多收..");
        //1.创建客户端的Socket对象，请求与服务端的连接。
        //参数1：指定服务器的ip地址
        //参数2：指定服务器的端口号
        Socket socket = new Socket("127.0.0.1", 8888);
        //2.使用socket对象调用getOutputStream()方法得到字节输出流。
        OutputStream os = socket.getOutputStream();
        //3.特殊数据流(随便什么流都行，但要和服务器接收的流一样)
        DataOutputStream dos = new DataOutputStream(os);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要发送的数据：");
            String data = sc.nextLine();
            if ("886".equals(data)) {
                System.out.println("客户端退出...");
                socket.close();
                break;
            }
            dos.writeUTF(data);
            dos.flush();
        }


    }
}
