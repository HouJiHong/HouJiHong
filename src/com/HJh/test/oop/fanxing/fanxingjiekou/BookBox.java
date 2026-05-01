package com.HJh.test.oop.fanxing.fanxingjiekou;

import java.util.ArrayList;

// 📦 实现1：装书的仓库
public class BookBox implements Container<Book> {

    private ArrayList<Book> books = new ArrayList<>();

    @Override
    public void put(Book book) {
        books.add(book);
        System.out.println("放入书籍: " + book.getTitle());
    }

    @Override
    public Book take() {
        if (books.isEmpty()) return null;
        return books.remove(0);
    }

    @Override
    public int size() {
        return books.size();
    }
}
