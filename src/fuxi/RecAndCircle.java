package fuxi;

import java.util.Scanner;

// 矩形类
class Rec {
    private double a; // 长
    private double b; // 宽

    // 构造方法
    public Rec(double a, double b) {
        this.a = a;
        this.b = b;
    }

    // 计算面积
    public double area() {
        return a * b;
    }
}

// 圆形类
class Circle {
    private double r; // 半径

    // 构造方法
    public Circle(double r) {
        this.r = r;
    }

    // 计算面积
    public double area() {
        return Math.PI * r * r;
    }
}

public class RecAndCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 第一个矩形
        double a1 = sc.nextDouble();
        double b1 = sc.nextDouble();
        Rec rect1 = new Rec(a1, b1);

        // 第二个矩形
        double a2 = sc.nextDouble();
        double b2 = sc.nextDouble();
        Rec rect2 = new Rec(a2, b2);

        // 第一个圆
        double r1 = sc.nextDouble();
        Circle circle1 = new Circle(r1);

        // 第二个圆
        double r2 = sc.nextDouble();
        Circle circle2 = new Circle(r2);

        sc.close();

        // 输出面积，保留两位小数
        System.out.printf("%.2f\n", rect1.area());
        System.out.printf("%.2f\n", rect2.area());
        System.out.printf("%.2f\n", circle1.area());
        System.out.printf("%.2f\n", circle2.area());
    }
}