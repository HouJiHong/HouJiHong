package com.HJh.test.oop.jichenyongfa.jichen_chenyuanfangfa_tedian2;

//方法重写注意：
//如果父类的代码一行都不想用，则在子类中重新写
//如果父类的代码想用，想在原来的基础上增加，可以通过super关键字调用父类得到一个结果，在对结果重写新内容


public class Phone extends SmartDevice{

    @Override
    public double payment() {
        double payment = super.payment();
        payment = payment * 0.9;
        return payment;
    }
}
