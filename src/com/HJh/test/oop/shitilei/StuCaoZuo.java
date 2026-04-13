package com.HJh.test.oop.shitilei;

public class StuCaoZuo {
    private Student s;
    public StuCaoZuo(Student s) {
        this.s = s;
    }
    public void show() {
        System.out.println("姓名：" + s.getName());
        System.out.println("年龄：" + s.getAge());
        System.out.println("性别：" + s.getSex());
    }
}
