package com.HJh.test.oop.jichenyongfa.jichen2;
/*三个电子设备，设计继承关系：
安卓：属性：品牌，价格。行为：打电话，发短信，nfc功能。
苹果：属性：品牌，价格。行为：打电话，发短信。
电脑：属性：品牌，价格。行为：编程。*/

//画图：从下往上（先子类，再父类）
//代码：从上往下（先父类，再子类）


public class test {
    public static void main(String[] args) {
        //创建安卓
        Androw androw = new Androw();
        androw.pingPai = "小米";
        androw.price = 1900;
        System.out.println(androw.pingPai+" "+androw.price);
        androw.call();
        androw.send();
        androw.nfc();

        //创建苹果
        Apple apple = new Apple();
        apple.pingPai = "苹果";
        apple.price = 2900;
        System.out.println(apple.pingPai+" "+apple.price);
        apple.call();
        apple.send();

        //创建电脑
        Computer computer = new Computer();
        computer.pingPai = "联想";
        computer.price = 3900;
        System.out.println(computer.pingPai+" "+computer.price);
        computer.program();
    }
}
