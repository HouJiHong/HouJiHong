package com.HJh.test.oop.danlileiyongfa.fangfa2;
//推荐使用枚举单例，它是最安全、最简洁的单例实现方式
//通过 C.getInstance() 或 C.INSTANCE 都可以获取单例实例
//枚举单例在第一次被引用时才会加载，天然支持懒加载
public class test {
    public static void main(String[] args) {
        // 测试枚举单例 C
        C c1 = C.getInstance();
        C c2 = C.getInstance();
        System.out.println("=== 枚举单例 C ===");
        System.out.println("c1: " + c1);
        System.out.println("c2: " + c2);
        System.out.println("是否是同一实例: " + (c1 == c2));
        c1.showMessage();
        System.out.println();

        // 测试枚举单例 D
        D d1 = D.getInstance();
        D d2 = D.getInstance();
        System.out.println("=== 枚举单例 D ===");
        System.out.println("d1: " + d1);
        System.out.println("d2: " + d2);
        System.out.println("是否是同一实例: " + (d1 == d2));
        d1.initData("测试数据");
        d1.showMessage();
        System.out.println("获取数据: " + d1.getData());
        System.out.println();

        // 直接使用 INSTANCE
        C c3 = C.INSTANCE;
        D d3 = D.INSTANCE;
        System.out.println("=== 直接使用 INSTANCE ===");
        System.out.println("c1 == c3: " + (c1 == c3));
        System.out.println("d1 == d3: " + (d1 == d3));
    }
}
