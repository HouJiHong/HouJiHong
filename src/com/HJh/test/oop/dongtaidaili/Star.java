package com.HJh.test.oop.dongtaidaili;

//其实这里面也用到了AOP，把重复的准备和收钱封装到了代理类，这样代理类就有了准备和收钱的功能，
// 以后无论谁调用代理类都自动具有准备和收钱的功能
public class Star implements StarService{
    private String name;

    @Override
    public void sing(String name) {
        System.out.println(this.name+"唱："+name);
    }

    @Override
    public String dance() {
        System.out.println(this.name+"跳舞");
        return "表演结束";
    }

    public Star() {
    }

    public Star(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
