package com.HJh.test.oop.duoxiancheng;
//多线程的创建方式一：继承Thread类
//1.定义一个子类MyThread继承线程类java.lang.Thread，重写run()方法
//2.创建MyThread类的对象
//3.调用线程对象的start()方法启动线程（启动后还是执行run方法的）

//创建线程的注意事项
//1、启动线程必须是调用start方法，不是调用run方法。
//        ●直接调用run方法会当成普通方法执行，此时相当于还是单线程执行。
//        ●只有调用start方法才是启动一个新的线程执行。
//2、不要把主线程任务放在启动子线程之前。
//这样主线程一直是先跑完的，相当于是一个单线程的效果了。
public class FangFa1 {
    public static void main(String[] args) { //mian方法执行主线程
        //方法一：继承Thread类实现线程
        //4.创建MyThread类的对象
        MyThread myThread = new MyThread();
        //5.调用线程对象的start()方法启动线程
        myThread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("主线程："+i);
        }
    }
}
//1.定义一个子类MyThread继承线程类Thread
class MyThread extends Thread{
    //2.重写run()方法
    @Override
    public void run() {
        //3.编写线程任务
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程："+i);
        }
    }
}
