package com.HJh.test.oop.duoxiancheng.xianchengchi;

import java.util.concurrent.*;
//简单说说多线程是怎么执行的？
//并发和并行同时进行的
//并发：CPU分时轮询的执行线程。
//并行：同一个时刻同时在执行。

//进程：（由于线程在不停的执行不同的任务，所以进程是动态的）
//正在运行的程序（软件）就是一个独立的进程。
//线程是属于进程的，一个进程中可以同时运行很多个线程。
//进程中的多个线程其实是并发和并行执行的。

public class FangFa1_Callable {
    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(
                3,
                5,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        Future<String> f1 = pool.submit(new MyTaskC(10));
        Future<String> f2 = pool.submit(new MyTaskC(20));
        Future<String> f3 = pool.submit(new MyTaskC(30));
        Future<String> f4 = pool.submit(new MyTaskC(40));
        try {
            System.out.println(f1.get());
            System.out.println(f2.get());
            System.out.println(f3.get());
            System.out.println(f4.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
}

class MyTaskC implements Callable<String> {
    private int n;
    public MyTaskC(int n) {
        this.n = n;
    }
    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return Thread.currentThread().getName()+"线程执行结果："+sum;
    }
}
