package com.HJh.test.oop.fanxing.fanxingjiekou;

public class Book {
    private String title;       // 书名
    private String author;      // 作者
    private double price;       // 价格

    // 构造方法
    public Book(String title) {
        this.title = title;
    }

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Getter / Setter
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    // 打印时显示书名，方便查看
    @Override
    public String toString() {
        return "《" + title + "》";
    }
}
