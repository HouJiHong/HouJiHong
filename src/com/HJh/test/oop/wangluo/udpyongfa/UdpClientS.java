package com.HJh.test.oop.wangluo.udpyongfa;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpClientS {
    public static void main(String[] args) throws Exception {
        System.out.println("客户端启动，实现多发多收..");

        DatagramSocket socket = new DatagramSocket();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要发送的数据：");
            String data = sc.nextLine();
            if ("886".equals(data)) {
                break;
            }
            byte[] bys = data.getBytes();
            DatagramPacket dp = new DatagramPacket(bys, bys.length, InetAddress.getLocalHost(), 8080);


            socket.send(dp);
        }


        socket.close();

    }
}
