package com.HJh.test.oop.wangluo.tcpyongfa.BS;



import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class TcpServerS {
    public static void main(String[] args) throws Exception {
        System.out.println("服务端启动了，实现B/S...");
        //1.创建ServerSocket对象，注册服务端端口
        ServerSocket ss = new ServerSocket(8080);
        //创建线程池
        ExecutorService pool = new ThreadPoolExecutor(3,10,10,
                TimeUnit.SECONDS,new ArrayBlockingQueue<>(100), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        while (true) {
            //2.调用ServerSocket对象的accept()方法，等待浏览器的连接，并得到Socket管道对象
            Socket socket = ss.accept();
            //一旦一个浏览器连接，就会产生一个Socket管道对象，服务端就知道浏览器上线了
            System.out.println("一个浏览器上线了..."+socket.getInetAddress().getHostAddress()+":"+socket.getPort());
            //3.把浏览器的Socket管道包装成runnable任务对象交给线程池处理
            //pool.execute(new ServerThread(socket));//可以直接将一个线程对象看成一个runnable任务对象
            //或者将ServerThread实现Runnable接口
            pool.execute(new ServerThread(socket));
        }

    }
}
