package com.HJh.test.oop.duoxiancheng;
//创建线程的另一种方法是声明一个实现Runnable接口的类。
//该类然后实现run方法。然后可以分配类的实例，在创建Thread时作为参数传递，然后启动。

public class FangFa2 {
    public static void main(String[] args) {
        //方法二：实现Runnable接口
        //3.创建MyRunnable类的线程任务类的对象代表一个线程任务
        Runnable myRunnable = new MyRunnable();
        //4.把线程任务对象交给一个线程对象来处理
        Thread thread = new Thread(myRunnable);
        //5.调用start()方法启动线程
        thread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("主线程："+i);
        }
    }

}

//1.创建一个实现Runnable接口的类
class MyRunnable implements Runnable{
    //2.实现run()方法
    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程："+i);
        }
    }
}
