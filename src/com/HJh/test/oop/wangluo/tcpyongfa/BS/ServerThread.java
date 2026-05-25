package com.HJh.test.oop.wangluo.tcpyongfa.BS;
//由于在tcp中客户端和服务端是需要建立socket连接，想要多个客户端连接，所以需要创建多个线程，每一个服务端线程对应一个客户端

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

//public class ServerThread extends Thread{
public class ServerThread implements Runnable{
    private Socket socket;
    public ServerThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            OutputStream os = socket.getOutputStream();
            PrintStream ps = new PrintStream(os);
            ps.println("HTTP/1.1 200 OK");
            ps.println("Content-Type:text/html; charset=utf-8");
            ps.println();
            ps.println("<html>");
            ps.println("<head>");
            ps.println("<title>");
            ps.println("hello world");
            ps.println("</title>");
            ps.println("</head>");
            ps.println("<body>");
            ps.println("<h1 style='color:red'>线程池实现B/S</h1>");
            ps.println("</body>");
            ps.println("</html>");
            ps.close();
            socket.close();

        } catch (Exception e) {
            System.out.println("浏览器下线"+socket.getInetAddress().getHostAddress()+" "+socket.getPort());

        }

    }
}
