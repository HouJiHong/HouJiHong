package com.HJh.test.oop.duotaiyongfa.jichu.lianxi2;

public class People {
    private String name;
    public String getDescription(){
        return "这是一个人";
    }

    public People() {
    }

    public People(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
