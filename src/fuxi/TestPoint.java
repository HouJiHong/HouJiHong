package fuxi;

import java.util.Scanner;

class Point2D {
    protected double x;
    protected double y;

    // 无参构造方法
    public Point2D() {
        this.x = 0;
        this.y = 0;
    }

    // 带参构造方法
    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // 计算点到原点的距离
    public double dis() {
        return Math.sqrt(x * x + y * y);
    }

    // 计算两点之间的距离
    public double dis(Point2D p) {
        double dx = this.x - p.x;
        double dy = this.y - p.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}

class Point3D extends Point2D {
    protected double z;

    // 无参构造方法
    public Point3D() {
        super();  // 调用父类无参构造，x=0, y=0
        this.z = 0;
    }

    // 带参构造方法
    public Point3D(double x, double y, double z) {
        super(x, y);  // 调用父类带参构造，设置 x 和 y
        this.z = z;
    }

    // 设置三维点的坐标
    public void setValue(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // 重写：计算点到原点的距离（三维空间）
    @Override
    public double dis() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    // 重载：计算三维空间中两点之间的距离
    public double dis(Point3D p) {
        double dx = this.x - p.x;
        double dy = this.y - p.y;
        double dz = this.z - p.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
}

public class TestPoint {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Point2D p1 = new Point2D(in.nextDouble(), in.nextDouble());
        Point2D p2 = new Point2D(in.nextDouble(), in.nextDouble());
        Point3D p3 = new Point3D(in.nextDouble(), in.nextDouble(), in.nextDouble());
        Point3D p4 = new Point3D();
        p4.setValue(in.nextDouble(), in.nextDouble(), in.nextDouble());

        System.out.println(String.format("%.2f", p1.dis()));
        System.out.println(String.format("%.2f", p1.dis(p2)));
        System.out.println(String.format("%.2f", p3.dis()));
        System.out.println(String.format("%.2f", p3.dis(p4)));
    }
}