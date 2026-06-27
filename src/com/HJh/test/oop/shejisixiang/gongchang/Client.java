package com.HJh.test.oop.shejisixiang.gongchang;
/**
 * 简单工厂模式
 * 场景：一个工厂，根据传入的参数（如  "car"  或  "bike" ）返回对应的交通工具。
 */

// 1. 抽象产品
interface Transport {
    void deliver();
}

// 2. 具体产品
class Car implements Transport {
    public void deliver() { System.out.println("Deliver by land in a Car."); }
}
class Bike implements Transport {
    public void deliver() { System.out.println("Deliver by land on a Bike."); }
}

// 3. 简单工厂
class SimpleTransportFactory {
    public static Transport createTransport(String type) {
        if ("car".equalsIgnoreCase(type)) {
            return new Car();
        } else if ("bike".equalsIgnoreCase(type)) {
            return new Bike();
        }
        throw new IllegalArgumentException("Unknown transport type: " + type);
    }
}

// 客户端调用
public class Client {
    public static void main(String[] args) {
        Transport t = SimpleTransportFactory.createTransport("car");
        t.deliver();
    }
}


/**
 * 工厂方法模式
 * 场景：每个交通工具都有自己的专属工厂。新增交通工具（如  Ship ）时，
 * 只需新增  Ship  和  ShipFactory ，不改动已有代码。
 */
// 1. 抽象产品 & 抽象工厂
interface Transport2 { void deliver(); }
interface TransportFactory { Transport2 createTransport(); }

// 2. 具体产品 & 具体工厂
class Car2 implements Transport2 {
    public void deliver() { System.out.println("Deliver by Car."); }
}
class CarFactory implements TransportFactory {
    public Transport2 createTransport() { return new Car2(); }
}

class Bike2 implements Transport2 {
    public void deliver() { System.out.println("Deliver by Bike."); }
}
class BikeFactory implements TransportFactory {
    public Transport2 createTransport() { return new Bike2(); }
}

// 客户端调用
class Client2 {
    public static void main(String[] args) {
        TransportFactory factory = new CarFactory(); // 也可以从配置文件读取类名反射创建
        Transport2 t = factory.createTransport();
        t.deliver();
    }
}


/**
 * 抽象工厂模式
 * 场景：生产产品族。比如“现代风格”的工厂同时生产“现代汽车”和“现代飞机”；
 * “复古风格”的工厂同时生产“复古汽车”和“复古飞机”。
 */

// 1. 两个产品等级：汽车 和 飞机
interface Car3 { void drive(); }
interface Airplane { void fly(); }

// 2. 抽象工厂：定义产品族的生产能力
interface VehicleFactory {
    Car3 createCar();
    Airplane createAirplane();
}

// 3. 具体工厂：现代风格工厂
class ModernCar implements Car3 { public void drive() { System.out.println("Driving a Modern Car."); } }
class ModernAirplane implements Airplane { public void fly() { System.out.println("Flying a Modern Airplane."); } }

class ModernFactory implements VehicleFactory {
    public Car3 createCar() { return new ModernCar(); }
    public Airplane createAirplane() { return new ModernAirplane(); }
}

// 4. 具体工厂：复古风格工厂
class OldCar implements Car3 { public void drive() { System.out.println("Driving a Old Car."); } }
class OldAirplane implements Airplane { public void fly() { System.out.println("Flying a Old Airplane."); } }

class OldFactory implements VehicleFactory {
    public Car3 createCar() { return new OldCar(); }
    public Airplane createAirplane() { return new OldAirplane(); }
}

// 客户端调用
class Client3 {
    public static void main(String[] args) {
        VehicleFactory factory = new ModernFactory();
        Car3 car = factory.createCar();
        Airplane plane = factory.createAirplane();
        car.drive();
        plane.fly();
    }
}