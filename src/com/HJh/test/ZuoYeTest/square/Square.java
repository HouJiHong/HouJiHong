package com.HJh.test.ZuoYeTest.square;

public class Square {
    private double side;
    public void perimeter(double side){
        System.out.println("Perimeter is "+(4.0*side));
    }
    public void area(double side){
        System.out.println("Area is "+(side*side));
    }

    public Square() {
    }

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
}
