package com.HJh.test.oop.xiaoxiangmu.liaotian.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {
    //准备集合容器，存储所有在线的socket和昵称，用于更新在线列表
    public static final Map<Socket, String> onLineSockets = new HashMap<>();
    public static void main(String[] args) {
        System.out.println("服务端启动...");
        try {
            //创建服务器套接字，监听端口
            ServerSocket ss = new ServerSocket(Constant.Port);
            while (true) {
                System.out.println("等待客户端连接...");
                Socket socket = ss.accept();
                new ServerThread(socket).start();
                System.out.println("一个客户端连接了...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
