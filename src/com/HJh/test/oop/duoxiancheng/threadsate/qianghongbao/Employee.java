package com.HJh.test.oop.duoxiancheng.threadsate.qianghongbao;

public class Employee {
    private String name;
    private int totalAmount;

    public Employee(String name) {
        this.name = name;
        this.totalAmount = 0;
    }

    public String getName() {
        return name;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void addAmount(int amount) {
        this.totalAmount += amount;
    }

    @Override
    public String toString() {
        return name + " 累计抢到：" + totalAmount + "元";
    }
}
