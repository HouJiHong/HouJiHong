package com.HJh.test.oop.jichenyongfa.jichenzonghe;

public class MasterStudent extends Student {

    public MasterStudent() {
    }

    public MasterStudent(String name, int age, String grade) {
        super(name, age, grade);
    }

    @Override
    public void study() {
        System.out.println("硕士生在学习");

    }
}
