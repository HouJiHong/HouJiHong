package com.HJh.test.oop.shejisixiang.guanchazhe;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@FunctionalInterface // 支持 Lambda 表达式
interface Observer<T> {
    void update(T data);
}

public class Subject<T> {
    // 使用线程安全的 List，防止在遍历通知时发生 ConcurrentModificationException
    private final List<Observer<T>> observers = new CopyOnWriteArrayList<>();
    private T state;

    // 注册观察者
    public void addObserver(Observer<T> observer) {
        observers.add(observer);
    }

    // 移除观察者
    public void removeObserver(Observer<T> observer) {
        observers.remove(observer);
    }

    // 状态变更并通知所有观察者
    public void setState(T newState) {
        this.state = newState;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer<T> observer : observers) {
            observer.update(state);
        }
    }
}

class ObserverDemo {
    public static void main(String[] args) {
        Subject<String> subject = new Subject<>();

        // 使用 Lambda 表达式注册观察者
        subject.addObserver(data -> System.out.println("观察者 A 收到: " + data));
        subject.addObserver(data -> System.out.println("观察者 B 收到: " + data));

        subject.setState("Hello, Observer!");
        // 输出:
        // 观察者 A 收到: Hello, Observer!
        // 观察者 B 收到: Hello, Observer!
    }
}