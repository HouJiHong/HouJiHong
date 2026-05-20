package com.HJh.test.oop.duoxiancheng.xianchengchi;
//当使用多线程时，线程的创建和销毁都是耗时的，所以，线程的创建和销毁应该交给线程池来完成复用。

//创建线程池
//●JDK 5.0起提供了代表线程池的接口：ExecutorService。
//如何创建线程池对象
//方式一：使用ExecutorService的实现类ThreadPoolExecutor自创建一个线程池对象。
//ExecutorService    ->    ThreadPoolExecutor

//方式二：使用Executors（线程池的工具类）调用方法返回不同特点的线程池对象。 （不推荐）


//方式一：通过ThreadPoolExecutor创建线程池
//ThreadPoolExecutor类提供的构造器         使用指定的初始化参数创建一个新的线程池对象
//public ThreadPoolExecutor(int corePoolSize,                   --指定线程池的核心线程的数量（正式工）
//                          int maximumPoolSize,                --指定线程池的最大线程数量。（包括正式工和临时工）
//                          long keepAliveTime,                 --指定临时线程的存活时间。
//                          TimeUnit unit,                      --指定临时线程存活的时间单位(秒、分、时、天)
//                          BlockingQueue<Runnable> workQueue,  --指定线程池的任务队列。（任务排队的地方）
//                          ThreadFactory threadFactory,        --指定线程池的线程工厂，负责招聘员工的（hr）
//                          RejectedExecutionHandler handler)   --指定线程池的任务拒绝策略（正式工和临时工都在忙，任务
//                                                                          队列也满了的时候，新任务来了该怎么处理）

//什么时候开始创建临时线程？
//◆新任务提交时发现核心线程都在忙，任务队列也满了，并且还可以创建临时线程，此时才会创建临时线程。
//什么时候会拒绝新任务？
//◆核心线程和临时线程都在忙，任务队列也满了，新的任务过来的时候才会开始拒绝任务。

//任务拒绝策略
//ThreadPoolExecutor.AbortPolicy()              丢弃任务并抛出RejectedExecutionException异常。(是默认的策略)
//ThreadPoolExecutor.DiscardPolicy()            丢弃任务，但是不抛出异常，这是不推荐的做法
//ThreadPoolExecutor.DiscardOldestPolicy()      抛弃队列中等待最久的任务然后把当前任务加入队列中
//ThreadPoolExecutor.CallerRunsPolicy()         由主线程负责调用任务的run()方法从而绕过线程池直接执行

//ExecutorService的常用方法
//void execute(Runnable command)        执行 Runnable任务
//Future<T> submit(Callable<T> task)    执行Callable任务，返回未来任务对象，用于获取线程返回的结果
//void shutdown()                       等全部任务执行完毕后，再关闭线程池！
//List<Runnable>shutdownNow()           立刻关闭线程池，停止正在执行的任务，并返回队列中未执行的任务

//核心线程数量和最大线程数量的配置：
//CPU密集型任务（计算为主）:核心线程数 = CPU核数 + 1
//IO密集型任务（文件读写、网络请求等）:核心线程数 = CPU核数 * 2

import java.util.concurrent.*;

public class FangFa1_Runnable {
    public static void main(String[] args) {
        //使用线程池的实现类ThreadPoolExecutor创建线程池对象
        ExecutorService pool = new ThreadPoolExecutor(
                3,                              //核心线程数量
                5,                             //最大线程数量
                10,                           //临时线程的存活时间
                TimeUnit.SECONDS,          //临时线程的存活时间单位
                new ArrayBlockingQueue<>(3),    //数组队列   linkedBlockingQueue链表阻塞队列
                Executors.defaultThreadFactory(),   //线程工厂
                new ThreadPoolExecutor.AbortPolicy()   //拒绝策略
        );

        //创建线程池处理任务
        Runnable myTaskR = new MyTaskR();
        pool.execute(myTaskR);//提交第一个任务，线程池创建第一个线程
        pool.execute(myTaskR);//提交第二个任务，线程池创建第二个线程
        pool.execute(myTaskR);//提交第三个任务，线程池创建第三个线程
        pool.execute(myTaskR);//复用线程(因为任务加了很长时间，进入等待队列)
        pool.execute(myTaskR);//复用线程（进入队列）
        pool.execute(myTaskR);//复用线程（进入队列）
        pool.execute(myTaskR);//此时核心线程都在忙，任务队列也满了，此时才会创建临时线程
        pool.execute(myTaskR);//创建第二个临时线程
        pool.execute(myTaskR);//此时线程池满，任务队列也满了，此时执行拒绝策略


        //关闭线程池  一般不关闭
        //pool.shutdown();//等全部任务执行完毕后，再关闭线程池！
        //pool.shutdownNow();//立刻关闭线程池
    }
}

class MyTaskR implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+"线程执行进度："+ i);
            try {
                Thread.sleep(Integer.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
