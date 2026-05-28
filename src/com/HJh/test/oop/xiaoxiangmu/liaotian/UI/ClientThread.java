package com.HJh.test.oop.xiaoxiangmu.liaotian.UI;

import java.io.DataInputStream;
import java.net.Socket;

public class ClientThread extends  Thread{
    private Socket socket;
    private DataInputStream dis;
    private ClientChatFrame win;
    public ClientThread(Socket socket,ClientChatFrame win) {
        this.socket = socket;
        this.win = win;
    }
    @Override
    public void run() {
        //接收数据：1.在线列表 2.群聊消息
        try {
            dis = new DataInputStream(socket.getInputStream());
            while (true) {
                int type = dis.readInt();
                switch (type) {
                    case 1:
                        //在线列表
                        updateClientList();

                        break;
                    case 2:
                        //群聊消息
                        break;

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateClientList() throws Exception {
        //根据服务端发送到消息来对应一一接收
        //1.读取在线人数
        int onlineCount = dis.readInt();

        String [] onlineUsers = new String[onlineCount];
        //2.循环读取用户昵称
        for (int i = 0; i < onlineCount; i++) {
            String nickName = dis.readUTF();
            onlineUsers[i] = nickName;

        }

        //3.在窗口中显示出来
        win.updateOnLineUsers(onlineUsers);
    }
}
