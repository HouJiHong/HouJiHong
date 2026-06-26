package com.HJh.test.oop.shejisixiang.danli;

public enum SingletonEnum {
    INSTANCE; // 唯一实例

    public void doSomething() {
        System.out.println("执行业务逻辑...");
    }
}


class SingletonDCL {
    // 必须加 volatile 关键字！
    // 作用：防止 JVM 指令重排序，并保证可见性
    private static volatile SingletonDCL instance;

    // 1. 私有构造器，防止外部 new
    private SingletonDCL() {}

    public static SingletonDCL getInstance() {
        // 第一次检查：无锁，提高性能
        if (instance == null) {
            synchronized (SingletonDCL.class) {
                // 第二次检查：防止多线程并发时重复创建
                if (instance == null) {
                    instance = new SingletonDCL();
                }
            }
        }
        return instance;
    }
}

class SingletonInnerClass {
    private SingletonInnerClass() {}

    // 私有静态内部类，只有被调用时才会被加载
    private static class Holder {
        private static final SingletonInnerClass INSTANCE = new SingletonInnerClass();
    }

    public static SingletonInnerClass getInstance() {
        return Holder.INSTANCE;
    }
}

class SingletonEager {
    // 类加载时直接实例化
    private static final SingletonEager INSTANCE = new SingletonEager();

    private SingletonEager() {}

    public static SingletonEager getInstance() {
        return INSTANCE;
    }
}