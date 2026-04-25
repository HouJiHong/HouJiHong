package com.HJh.test.oop.duotaiyongfa.jichu.zhifusystem;

public class test {
    public static void main(String[] args) {
        //假设有一个购物车，需要支持多种支付方式（微信支付、支付宝、银行卡）。
        ShoppingCart cart = new ShoppingCart();
        //cart.setPaymentStrategy((amount) ->System.out.println("使用微信支付 " + amount + " 元"));
        cart.setPaymentStrategy(PaymentStrategy::show);





        cart.checkout(100);  // 输出：使用微信支付 100 元

        cart.setPaymentStrategy(new Alipay());
        cart.checkout(200);
    }
}
//定义支付策略接口
@FunctionalInterface
interface PaymentStrategy {
    void pay(int amount);
    public static void show(int amount){
        System.out.println("使用微信支付 " + amount + " 元");
    }
}

//实现类
//class WeChatPay implements PaymentStrategy {
//    @Override
//    public void pay(int amount) {
//        System.out.println("使用微信支付 " + amount + " 元");
//    }
//}
class Alipay implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("使用支付宝支付 " + amount + " 元");
    }
}

class ShoppingCart {
    private PaymentStrategy paymentStrategy;  // 组合支付策略

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount);   // 委托给具体策略
    }
}
