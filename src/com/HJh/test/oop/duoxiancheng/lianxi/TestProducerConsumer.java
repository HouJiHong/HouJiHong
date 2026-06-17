package com.HJh.test.oop.duoxiancheng.lianxi;

import java.util.LinkedList;
import java.util.Queue;

// 仓库类 - 循环缓冲区
class BookWarehouse {
    private Queue<String> books = new LinkedList<>();
    private int capacity;

    public BookWarehouse(int capacity) {
        this.capacity = capacity;
    }

    // 生产图书
    public synchronized void produce(String book) {
        while (books.size() >= capacity) {
            try {
                System.out.println("仓库已满，" + Thread.currentThread().getName() + " 等待...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        books.offer(book);
        System.out.println(Thread.currentThread().getName() + " 生产了：" + book + "，当前库存：" + books.size());
        notifyAll();
    }

    // 消费图书
    public synchronized String consume() {
        while (books.isEmpty()) {
            try {
                System.out.println("仓库为空，" + Thread.currentThread().getName() + " 等待...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String book = books.poll();
        System.out.println(Thread.currentThread().getName() + " 消费了：" + book + "，当前库存：" + books.size());
        notifyAll();
        return book;
    }
}

// 生产者类
class Producer extends Thread {
    private BookWarehouse warehouse;
    private int produceCount;

    public Producer(BookWarehouse warehouse, String name, int produceCount) {
        super(name);
        this.warehouse = warehouse;
        this.produceCount = produceCount;
    }

    public void run() {
        for (int i = 1; i <= produceCount; i++) {
            warehouse.produce("图书-" + i + "(" + getName() + ")");
            try {
                Thread.sleep((int)(500 * Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// 消费者类
class Consumer extends Thread {
    private BookWarehouse warehouse;
    private int consumeCount;

    public Consumer(BookWarehouse warehouse, String name, int consumeCount) {
        super(name);
        this.warehouse = warehouse;
        this.consumeCount = consumeCount;
    }

    public void run() {
        for (int i = 1; i <= consumeCount; i++) {
            warehouse.consume();
            try {
                Thread.sleep((int)(800 * Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// 测试类
public class TestProducerConsumer {
    public static void main(String[] args) {
        BookWarehouse warehouse = new BookWarehouse(5);  // 仓库容量为5

        Producer p1 = new Producer(warehouse, "生产者-1", 5);
        Producer p2 = new Producer(warehouse, "生产者-2", 5);
        Consumer c1 = new Consumer(warehouse, "消费者-1", 3);
        Consumer c2 = new Consumer(warehouse, "消费者-2", 3);
        Consumer c3 = new Consumer(warehouse, "消费者-3", 4);

        p1.start();
        p2.start();
        c1.start();
        c2.start();
        c3.start();
    }
}