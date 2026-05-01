package com.HJh.test.oop.fanxing.fanxingjiekou;

public class Demo {
    public static void main(String[] args) {

        // 创建一个装书的容器 —— 编译器知道这里面只能是 Book
        Container<Book> bookBox = new BookBox();
        bookBox.put(new Book("Java核心技术"));
        bookBox.put(new Book("深入理解JVM"));

        Book book = bookBox.take();  // 取出时直接就是 Book 类型，无需强转！
        System.out.println("取出了: " + book.getTitle());

        // 创建一个装衣服的容器
        Container<Clothes> clothesBox = new ClothesBox();
        clothesBox.put(new Clothes("T恤"));
        clothesBox.put(new Clothes("牛仔裤"));

        // ❌ 编译错误！不能往衣服箱子里放书
        // clothesBox.put(new Book("错误示范"));
    }
}
