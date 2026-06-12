package fuxi;

import java.util.Scanner;

// 形状类
abstract class Shape {
    public abstract double getArea();
}

// 圆形类
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

// 矩形类
class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return length * width;
    }
}

// 三角形类
class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // 判断是否能构成三角形
    private boolean isValidTriangle() {
        return side1 + side2 > side3 &&
                side1 + side3 > side2 &&
                side2 + side3 > side1;
    }

    @Override
    public double getArea() {
        if (!isValidTriangle()) {
            return 0;  // 不能构成三角形，面积为0
        }
        // 海伦公式
        double p = (side1 + side2 + side3) / 2;
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }
}

// 梯形类
class Trapezoid extends Shape {
    private double topBase;
    private double bottomBase;
    private double height;

    public Trapezoid(double topBase, double bottomBase, double height) {
        this.topBase = topBase;
        this.bottomBase = bottomBase;
        this.height = height;
    }

    @Override
    public double getArea() {
        return (topBase + bottomBase) * height / 2;
    }
}

// 测试类
class TestShape {
    private static double area = 0;  // 存储总面积

    // 静态方法：累加形状面积
    public static void totalArea(Shape s) {
        area += s.getArea();
    }

    // 获取总面积
    public static double getArea() {
        return area;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取圆的半径
        double radius = scanner.nextDouble();
        Circle circle = new Circle(radius);

        // 读取矩形的长和宽
        double length = scanner.nextDouble();
        double width = scanner.nextDouble();
        Rectangle rectangle = new Rectangle(length, width);

        // 读取三角形的三边长
        double side1 = scanner.nextDouble();
        double side2 = scanner.nextDouble();
        double side3 = scanner.nextDouble();
        Triangle triangle = new Triangle(side1, side2, side3);

        // 读取梯形的上底、下底和高
        double topBase = scanner.nextDouble();
        double bottomBase = scanner.nextDouble();
        double height = scanner.nextDouble();
        Trapezoid trapezoid = new Trapezoid(topBase, bottomBase, height);

        // 累加面积
        TestShape.totalArea(circle);
        TestShape.totalArea(rectangle);
        TestShape.totalArea(triangle);
        TestShape.totalArea(trapezoid);

        // 输出总面积，保留两位小数
        System.out.printf("%.2f\n", TestShape.getArea());

        scanner.close();
    }
}