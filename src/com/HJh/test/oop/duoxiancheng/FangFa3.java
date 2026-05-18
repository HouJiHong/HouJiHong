package com.HJh.test.oop.duoxiancheng;
//线程的创建方式三：实现callable接口
//前两种线程创建方式都存在的一个问题,假如线程执行完毕后有一些数据需要返回，他们重写的run方法均不能直接返回结果。

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

//1.创建任务对象
//  定义一个类实现Callable接口，重写call方法，封装要做的事情，和要返回的数据。
//  把Callable类型的对象封装成FutureTask（线程任务对象）。
//2.把线程任务对象交给Thread对象。
//3.调用Thread对象的start方法启动线程。
//4.线程执行完毕后、通过FutureTask对象的的get方法去获取线程任务执行的结果。
public class FangFa3 {
    public static void main(String[] args) {
        //方法三：实现Callable接口,最终要得到的结果返回
        //3.创建MyCallable类的线程任务类的对象
        Callable<String> c1 = new MyCallable(100);
        /**
         * 未来任务对象的作用：
         * 1.可以获取线程执行结果
         * 2.本质是一个runnable接口的实现类,创建一个线程任务对象,可以交给thread线程对象处理
         *
         */

        //4.把callable对象封装成FutureTask对象(真正的线程任务对象)
        FutureTask<String> f1 = new FutureTask<>(c1);//FutureTask是runnable接口的实现类
        //5.把FutureTask对象交给Thread对象
        Thread t1 = new Thread(f1);
        t1.start();

        Callable<String> c2 = new MyCallable(50);
        FutureTask<String> f2 = new FutureTask<>(c2);
        Thread t2 = new Thread(f2);
        t2.start();


        try {
            //6.通过get方法获取线程执行结果
            //运行到这，如果主线程发现第一个线程还没有执行完，会让出cpu，等第一个线程执行完毕后，得到结果才会往下执行！
            System.out.println("子线程1执行结果："+f1.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            //运行到这，如果主线程发现第二个线程还没有执行完，会让出cpu，等第二个线程执行完毕后，得到结果才会往下执行！
            System.out.println("子线程2执行结果："+f2.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//1.定义一个类实现Callable接口
class MyCallable implements Callable<String> {
    private int n;
    public MyCallable(int n){
        this.n = n;
    }
    //2.重写call()方法,定义线程执行体
    @Override
    public String call() throws Exception{
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return "子线程执行：1到"+n+"的和为："+sum;
    }

}
