package com.HJh.test.oop.neibulei.neibuleiyongfa;
//内部类表示的事物是外部类的一部分
//内部类单独存在没有任何意义
//比如汽车里面有发动机
public class test {
    public static void main(String[] args) {

        /*需求：写一个Javabean类描述汽车
        属性：汽车的品牌，车龄，颜色，发动机的品牌，使用年限
        */
        //由于内部类engine是默认，在同一个包下，可以创建对象
        Car.Engine ce = new Car().new Engine();
    }
}
