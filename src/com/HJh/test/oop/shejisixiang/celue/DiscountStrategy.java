package com.HJh.test.oop.shejisixiang.celue;

/**
 * 折扣策略接口
 */
@FunctionalInterface
public interface DiscountStrategy {
    /**
     * 计算最终价格
     * @param price 原价
     * @return 折后价
     */
    double calculate(double price);
}

// 无折扣策略
class NoDiscount implements DiscountStrategy {
    @Override
    public double calculate(double price) {
        return price;
    }
}

// 9折策略
class TenPercentOff implements DiscountStrategy {
    @Override
    public double calculate(double price) {
        return price * 0.9;
    }
}

// 固定金额减免策略（带状态）
class FixedAmountOff implements DiscountStrategy {
    private final double amount;

    public FixedAmountOff(double amount) {
        this.amount = amount;
    }

    @Override
    public double calculate(double price) {
        return Math.max(0, price - amount); // 防止出现负数
    }
}

/**
 * 价格计算器（上下文）
 */
class PriceCalculator {
    // 持有一个策略接口的引用（面向接口编程）
    private DiscountStrategy strategy;

    // 通过构造器注入策略
    public PriceCalculator(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    // 提供 Setter 方法，支持在运行时动态切换策略
    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    // 委托给策略执行计算
    public double getFinalPrice(double price) {
        return strategy.calculate(price);
    }
}

class Main {
    public static void main(String[] args) {
        double originalPrice = 200.0;

        // 1. 初始化时使用无折扣策略
        PriceCalculator calculator = new PriceCalculator(new NoDiscount());
        System.out.println("无折扣: " + calculator.getFinalPrice(originalPrice)); // 200.0

        // 2. 运行时动态切换为9折策略
        calculator.setStrategy(new TenPercentOff());
        System.out.println("9折优惠: " + calculator.getFinalPrice(originalPrice)); // 180.0

        // 3. 切换为固定金额减免策略
        calculator.setStrategy(new FixedAmountOff(50));
        System.out.println("立减50: " + calculator.getFinalPrice(originalPrice)); // 150.0
    }
}

class ModernMain {
    public static void main(String[] args) {
        double originalPrice = 200.0;

        // 直接使用 Lambda 表达式作为策略传入
        PriceCalculator calculator = new PriceCalculator(price -> price); // 无折扣
        System.out.println("无折扣: " + calculator.getFinalPrice(originalPrice));

        calculator.setStrategy(price -> price * 0.9); // 9折
        System.out.println("9折优惠: " + calculator.getFinalPrice(originalPrice));

        // 甚至可以调用外部方法引用
        calculator.setStrategy(price -> Math.max(0, price - 50)); // 固定减50
        System.out.println("立减50: " + calculator.getFinalPrice(originalPrice));
    }
}

