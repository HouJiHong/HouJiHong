package com.HJh.test.oop.duoxiancheng;
//Thread的常用方法
//public void run()                     线程的任务方法
//public void start()                   启动线程
//public String getName()               获取当前线程的名称，线程名称默认是Thread-索引
//public void setName(String name)      为线程设置名称
//public static Thread currentThread()  获取当前执行的线程对象
//public static void sleep(long time)   让当前执行的线程休眠多少毫秒后，再继续执行
//public final void join()...           让调用当前这个方法的线程先执行完！

//Thread提供的常见构造器
//public Thread(String name)            可以为当前线程指定名称
//public Thread(Runnable target)        封装Runnable对象成为线程对象
//public Thread(Runnable target, String name)   封装Runnable对象成为线程对象，并指定线程名称


public class ThreadFangFa {
    public static void main(String[] args) {
        //4.创建MyTd类的对象
        MyTd myThread1 = new MyTd("线程1");
        //myThread1.setName("线程1");//必须在start()方法之前调用
        //5.调用线程对象的start()方法启动线程
        myThread1.start();

        MyTd myThread2 = new MyTd("线程2");
        //myThread2.setName("线程2");
        myThread2.start();

        //哪个线程调用这个代码，这个代码就拿到哪个线程
        Thread m = Thread.currentThread();//主线程
        System.out.println(m.getName());

        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+"主线程："+i);
            try {

                if(i==1){
                    myThread1.join();//当主线程运行到1的时候，就等待myThread1执行完毕
                }
                Thread.sleep(500);//1000ms = 1s
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }


    }
}
//1.定义一个子类MyTd继承线程类Thread
class MyTd extends Thread{
    public MyTd(String name){//调用父类的构造器，为当前线程对象设置名称
        super(name);
    }
    //2.重写run()方法
    @Override
    public void run() {
        //3.编写线程任务
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+"子线程："+i);
        }
    }
}
