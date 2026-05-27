package com.HJh.test.oop.xiaoxiangmu.liaotian.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Collection;

public class ServerThread extends Thread{
//public class ServerThread implements Runnable{
    private Socket socket;
    public ServerThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            //服务器接收客户端的消息可能有多种类型：1.登录消息（包含昵称）2.群聊消息3.私聊消息
            //客户端需要申明什么消息类型
            DataInputStream dis = new DataInputStream(socket.getInputStream());//接收字节输入流并包装为数据输入流
            int type = dis.readInt();
            switch (type) {
                case 1:
                    //1.登录消息,要获取昵称，并更新客户端的在线列表
                    String nickName = dis.readUTF();
                    Server.onLineSockets.put(socket,nickName);
                    updateClientOnLineUserList();
                    break;
                case 2:
                    //2.群聊消息，要获取内容，并把消息发送给所有在线的客户端
                    break;

            }
        } catch (Exception e) {
            System.out.println("浏览器下线"+socket.getInetAddress().getHostAddress()+" "+socket.getPort());
            Server.onLineSockets.remove(socket);//移除掉下线的客户端
        }

    }

    private void updateClientOnLineUserList() {
        //更新所有在线用户的列表
        //获取所有在线用户的名称，把名称发送给所有在线客户端
        Collection<String> onLineUsers = Server.onLineSockets.values();
        for (Socket socket : Server.onLineSockets.keySet()){
            try {
                OutputStream outputStream = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(outputStream);
                dos.writeInt(1);//1代表告诉客户端，这是在线用户列表，2代表群聊消息，3代表私聊消息
                dos.writeInt(onLineUsers.size());
                for (String onLineUser : onLineUsers) {
                    dos.writeUTF(onLineUser);
                }
                dos.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
