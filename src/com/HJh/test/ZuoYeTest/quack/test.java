package com.HJh.test.ZuoYeTest.quack;
//想象你有这些鸭子：
//🦆 普通鸭：能飞 + 能叫
//🤐 橡皮鸭：不能飞 + 能叫
//🕊️ 玩具鸭：不能飞 + 不能叫
//传统做法：每个鸭子写一个类，代码重复很多。
//现在的做法：飞行和叫声单独封装，需要时组合起来
public class test extends Duck{
    //重点,测试鸭子,这只鸭子在构造时设定了：能叫 + 能飞
    public test (){
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }
    public void display(){
        System.out.println("我是一只测试鸭");
    }
    public void eat(){
        System.out.println("吃吃吃");
    }
    public static void main(String[] args) {
        Duck duckone = new test();
        duckone.performFly();
        duckone.performQuack();
        ((test) duckone).display();
        if(duckone instanceof test){
            test mallardDuck = (test) duckone;
            mallardDuck.display();
            ((test) duckone).eat();
        }
    }
}

//定义行为类,具体行为实现
class Quack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("嘎嘎嘎我能叫");
    }
}
class MuteQuack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("沉默我不能叫");
    }
}
class FlyWithWings implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("我能飞");
    }
}
class FlyNoWay implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("我不能飞");
    }
}

//定义行为接口
interface QuackBehavior{
    void quack();
}
interface FlyBehavior{
    void fly();
}


//鸭子自己不决定怎么飞、怎么叫，而是委托给持有的行为对象。
abstract class Duck{
    //重点
    //两个成员变量，类型是接口：这两个变量的类型是接口，可以指向任何实现类
    //默认值是 null：如果子类不在构造方法中赋值，调用时会报 NullPointerException
    //这叫"组合"（Composition）——鸭子包含行为对象，而不是自己实现行为。

    QuackBehavior quackBehavior;    // 可以随时替换
    FlyBehavior flyBehavior;        // 可以随时替换

    //委托给 quackBehavior 持有的叫声对象
    //不同的叫声对象会产生不同的叫声
    public void performFly(){
        flyBehavior.fly();
    }
    public void performQuack(){
        quackBehavior.quack();
    }
}

