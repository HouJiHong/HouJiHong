package com.HJh.test.oop.lambdayongfa.gouzaoqiyinyong;
//构造器引用

//使用场景
//如果某个Lambda表达式里只是在创建对象，并且“→”前后参数情况一致，就可以使用构造器引用。

//类名::new
public class test {
    public static void main(String[] args) {
        CarFactory cf = new CarFactory() {
            @Override
            public Car getCar(String name) {
                return new Car(name);
            }
        };

        //构造器引用
        //CarFactory cf2 = (name) ->new Car(name);
        CarFactory cf2 = Car::new;


        Car car = cf.getCar("奔驰");
        Car car2 = cf2.getCar("宝马");
        System.out.println(car.getName());
        System.out.println(car2.getName());
    }
}

@FunctionalInterface
interface CarFactory{
    Car getCar(String name);
}



class Car{
    private String name;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
