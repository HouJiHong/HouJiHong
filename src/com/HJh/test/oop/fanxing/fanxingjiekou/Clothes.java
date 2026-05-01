package com.HJh.test.oop.fanxing.fanxingjiekou;

public class Clothes {
    private String name;        // 名称（T恤、牛仔裤等）
    private String size;        // 尺码（S/M/L/XL）
    private String color;       // 颜色

    // 构造方法
    public Clothes(String name) {
        this.name = name;
    }

    public Clothes(String name, String size, String color) {
        this.name = name;
        this.size = size;
        this.color = color;
    }

    // Getter / Setter
    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return color + size + "码" + name;
    }
}
