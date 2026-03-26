package com.HJh.test.oop.enumyongfa;

public class test {
    public static void main(String[] args) {
        //枚举项默认值是public static final,因为是static所以直接用类名调用
        Order o1= Order.WAIT_PAY;
        System.out.println("o1"+o1);
        System.out.println("o1.getName()"+o1.getName());

        switch (o1){
            case WAIT_PAY -> System.out.println("请支付");
            case WAIT_SEND -> System.out.println("请发货");
            case WAIT_RECEIVE -> System.out.println("请收货");
            case WAIT_EVALUATE -> System.out.println("请评价");
        }
    }
}
