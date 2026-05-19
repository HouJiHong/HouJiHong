package com.HJh.test.oop.duoxiancheng.threadsate.solve;
//Lock锁
//Lock锁是JDK5开始提供的一个新的锁定操作，通过它可以创建出锁对象进行加锁和解锁，更灵活、更方便、更强大。
//Lock是接口，不能直接实例化，可以采用它的实现类ReentrantLock来构建Lock锁对象。
//构造器
//public ReentrantLock()    获得Lock锁的实现类对象

//Lock的常用方法
//void lock()           获得锁
//void unlock()         释放锁

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//建议使用final修饰，防止被别人篡改
//建议将释放锁的操作放到finally代码块中，确保锁用完了一定会被释放
public class FangFa3 {
    private String id;
    private double money;
    private final Lock lock = new ReentrantLock();//不能是static，因为static会锁定所有account对象

    public void drawMoney(double drawMoney){
        String name = Thread.currentThread().getName();
        lock.lock();//获得锁

        try {
            if(money >= drawMoney){

                System.out.println(name+"取钱成功，取了："+drawMoney+"元");
                money -= drawMoney;
                System.out.println(name+"取钱成功，余额为："+money);
            }else{
                System.out.println(name+"取钱失败，余额不足！");
            }
        } finally {
            lock.unlock();//释放锁
        }

    }
}
