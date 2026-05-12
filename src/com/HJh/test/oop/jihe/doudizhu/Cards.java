package com.HJh.test.oop.jihe.doudizhu;

public class Cards {
    private String size;
    private String color;
    private int value; //牌值

    @Override
    public String toString() {
        return color+ size;
    }

    public Cards() {
    }

    public Cards(String size, String color, int value) {
        this.size = size;
        this.color = color;
        this.value = value;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
