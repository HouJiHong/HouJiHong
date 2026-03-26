package com.HJh.test.oop.enumyongfa;
//每一个枚举项，就是该类的对象，每一个对象都是通过构造方法创建的
//枚举项在底层就是常量，默认值是public static final
//第一行必须是枚举项，必须用逗号隔开，最后一个枚举项必须添加分号
//枚举类的构造方法必须是private
//编译器会给枚举添加values()和valueOf()方法
//values():表示获取本类的所有枚举项,返回值是枚举项组成的数组
//valueOf():表示根据传入的参数，返回对应的枚举项，相当于Order.


//类名enum
public enum Order {
    //枚举成员变量
    WAIT_PAY("待支付"),
    WAIT_SEND("待发货"),
    WAIT_RECEIVE("待收货"),
    WAIT_EVALUATE("待评价");     //结尾添加分号

    private String name;
    //成员变量内容已经有了，不需要无参构造方法，也不需要setter方法

    //因为不让外界创建对象，所以私有化构造方法
    private Order(String name) {
        System.out.println("枚举项创建了"+ name);
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
