package com.HJh.test.oop.duoxiancheng;

public class test {
    public static void main(String[] args) {
        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("子线程："+i);
                }
            }
        };
        Thread thread = new Thread(myRunnable);
        thread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("主线程："+i);
        }
    }
}
