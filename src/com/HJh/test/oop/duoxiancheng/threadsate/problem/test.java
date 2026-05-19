package com.HJh.test.oop.duoxiancheng.threadsate.problem;

//线程安全问题
//多个线程操作共享资源，导致数据不一致。
public class test {
    public static void main(String[] args) {
        Account account = new Account("HJh123456",1000);
        Thread t1 = new ATM("zhangsan",account);
        Thread t2 = new ATM("lisi",account);
        t1.start();
        t2.start();
    }
}
