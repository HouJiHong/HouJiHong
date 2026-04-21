package com.HJh.test.oop.lambdayongfa;
//函数式编程：
//在java中函数是指lambda函数
//使用Lambda函数替代某些匿名内部类对象，是匿名内部类的简化，从而让程序代码更简洁，可读性更好。
//(被重写方法的形参列表)->{被重写方法的方法体代码}

//lambda表达式的省略规则
//作用：用于进一步简化Lambda表达式的写法。
//具体规则
//参数类型全部可以省略不写。
//如果只有一个参数，参数类型省略的同时"()"也可以省略，但多个参数不能省略"()"
//如果Lambda表达式中只有一行代码，大括号可以不写，同时要省略分号";"如果这行代码是return语句，也必须去掉return。


public class test {
    public static void main(String[] args) {
        //法一：
        Animal dog = new Animal() {
            @Override
            public void eat() {
                System.out.println("狗吃骨头");
            }
        };
        dog.eat();
//        //法二：
//        Animal dog = () -> {
//            System.out.println("狗吃骨头");
//        }
//        dog.eat();


        //报错！Lambda并不是可以简化所有的匿名内部类，只能简化函数式接口的匿名内部类。
        //函数式接口：只有一个抽象方法的接口

        Animal2 people = () -> {
            System.out.println("我TM吃吃吃");
        };
        people.eat();

        //省略形式
        Animal2 people2 = () -> System.out.println("我TM吃吃吃");
        people2.eat();


    }
}

abstract class Animal{
    public abstract void eat();
}

//函数式接口,用@FunctionalInterface注解修饰更安全
@FunctionalInterface
interface Animal2{
    void eat();
}
