package com.HJh.test.oop.dongtaidaili;

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
