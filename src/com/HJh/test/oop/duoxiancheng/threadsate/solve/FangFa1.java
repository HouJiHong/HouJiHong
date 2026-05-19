package com.HJh.test.oop.duoxiancheng.threadsate.solve;
//同步代码块
//作用：把访问共享资源的 核心代码 给上锁，以此保证线程安全。
//synchronized(同步锁){
//  访问共享资源的核心代码
//}
//原理：每次只允许一个线程加锁后进入，执行完毕后自动解锁，其他线程才可以进来执行。
//同步锁的注意事项:
//  对于当前同时执行的线程来说，同步锁必须是同一把（同一个对象），否则会出bug。

//锁对象的使用规范：
//  建议使用共享资源作为锁对象。
//  对于实例方法建议使用this作为锁对象。
//  对于静态方法建议使用字节码（类名.class）对象作为锁对象。

public class FangFa1 {
    private String id;
    private double money;

    public void drawMoney(double drawMoney){
        String name = Thread.currentThread().getName();

        //synchronized ("锁只要是唯一的就行") {    //只需要在访问的共享资源时加锁
        //但是这个锁范围太大了，在本例中如果有其他家庭使用另外的账户也无法访问。
        synchronized (this) { //this代表了当前对象，即Account对象，刚好符合要求（不影响其他家庭）
            if(money >= drawMoney){

                System.out.println(name+"取钱成功，取了："+drawMoney+"元");
                money -= drawMoney;
                System.out.println(name+"取钱成功，余额为："+money);
            }else{
                System.out.println(name+"取钱失败，余额不足！");
            }
        }

    }






}

