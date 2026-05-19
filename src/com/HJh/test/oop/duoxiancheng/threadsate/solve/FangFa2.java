package com.HJh.test.oop.duoxiancheng.threadsate.solve;
//同步方法
//作用：把访问共享资源的 核心方法 给上锁，以此保证线程安全。
//修饰符 synchronized 返回值类型 方法名称(形参列表){
//    操作共享资源的代码
//}

//原理：每次只能一个线程进入，执行完毕以后自动解锁，其他线程才可以进来执行。
//同步方法底层原理：
//  同步方法其实底层也是有隐式锁对象的，只是锁的范围是整个方法代码。
//  如果方法是实例方法：同步方法默认用this作为的锁对象。
//  如果方法是静态方法：同步方法默认用类名.class作为的锁对象。

public class FangFa2 {
    private String id;
    private double money;

    //只需要在访问共享资源方法上加上synchronized
    public synchronized void drawMoney(double drawMoney){
        String name = Thread.currentThread().getName();

        if(money >= drawMoney){

            System.out.println(name+"取钱成功，取了："+drawMoney+"元");
            money -= drawMoney;
            System.out.println(name+"取钱成功，余额为："+money);
        }else{
            System.out.println(name+"取钱失败，余额不足！");
        }

    }
}
