package com.HJh.test.oop.duoxiancheng.xianchengchi;

//通过Executors创建线程池
//是一个线程池的工具类，提供了很多静态方法用于返回不同特点的线程池对象。

//public static ExecutorService newFixedThreadPool(int nThreads)    创建固定线程数量的线程池，如果某个线程因为执行异
                                                                      //常而结束，那么线程池会补充一个新线程替代它。
//public static ExecutorService newSingleThreadExecutor()           创建只有一个线程的线程池对象，如果该线程出现异常
                                                                      //而结束，那么线程池会补充一个新线程。
//public static ExecutorService newCachedThreadPool()               线程数量随着任务增加而增加，如果线程任务执行完毕
                                                                      //且空闲了60s则会被回收掉。
//public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize)    创建一个线程池，可以实现在给定的延迟
                                                                                      //后运行任务，或者定期执行任务。

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//注意：这些方法的底层，都是通过线程池的实现类ThreadPoolExecutor创建的线程池对象。
public class FangFa2 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);//其实就是把ThreadPoolExecutor的核心
                                                                // 线程数量设置为3，最大线程数量设置为3，临时线程数量设置为0
                                                                // 临时线程存活时间设置为0,不限制等待队列的长度
        pool.execute(new MyTaskR());
        pool.execute(new MyTaskR());
        pool.execute(new MyTaskR());
        pool.execute(new MyTaskR());

    }
}
