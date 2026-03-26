package com.HJh.test.oop.jichenyongfa.jichen_chenyuanfangfa_tedian2;
/*智能设备：手机，电脑
计算价格：[0~1000)，不打折，
        [1000~5000)，9折，
        [5000~10000)，8折，
        [10000~)，7折
        手机额外打九折
        电脑不打折*/


public class test {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.name = "小米14";
        phone.price = 3999;
        System.out.println(phone.name);
        System.out.println(phone.payment());
        Laptop laptop = new Laptop();
        laptop.name = "MacBook Pro";
        laptop.price = 12999;
        System.out.println(laptop.name);
        System.out.println(laptop.payment());
    }
}
