package com.HJh.test.ZuoYeTest.qiche;
//定义汽车类,其中包含所有汽车共有的属性如名字、排量、油耗、时速等,包含行为
//如点火、熄火、前进、倒退、鸣笛等,然后在测试类中用定义的类来创建对象,输出该对象的属性和行为信息.


public class test {
    public static void main(String[] args) {
        Car car = new Car("奔驰", 2.0, 10.0, 100.0);
        System.out.println(car.getBrand()+" "+car.getDisplacement()+" "+car.getFuelConsumption()+" "+car.getSpeed());
        car.ignition();
        car.shutOff();
        car.honk();
        car.forward();
        car.reverse();

    }
}
