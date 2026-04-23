package com.HJh.test.ZuoYeTest.zouchangmianji;

public class test {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[2];
        shapes[0] = new Rect(5,6);
        shapes[1] = new Circle(8);
        for (int i = 0; i < shapes.length; i++) {
            shapes[i].area();
            shapes[i].perimeter();
        }
    }
}

interface Shape{
    void perimeter();
    void area();
}

class Circle implements Shape{
    private int radius;
    public static final double PI = 3.14;
    @Override
    public void area() {
        System.out.println("圆形半径为："+this.radius+"，面积为："+(this.radius*this.radius*PI));
    }
    @Override
    public void perimeter() {
        System.out.println("圆形半径为："+this.radius+"，周长为："+(this.radius*2*PI));
    }
    public Circle() {
    }
    public Circle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}

class Rect implements Shape{
    private int length;
    private int width;

    @Override
    public void area() {
        System.out.println("长方形长为："+this.length+"，宽为："+this.width+"，面积为："+(this.length*this.width));
    }
    @Override
    public void perimeter() {
        System.out.println("长方形长为："+this.length+"，宽为："+this.width+"，周长为："+(this.length+this.width)*2);
    }

    public Rect() {
    }

    public Rect(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}