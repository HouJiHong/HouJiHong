package com.HJh.test.oop.reflection.reflectionframe;

public class Student {
    private String name;
    private int age;
    private String habit;
    public Student() {
    }

    public Student(String name, int age, String habit) {
        this.name = name;
        this.age = age;
        this.habit = habit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHabit() {
        return habit;
    }

    public void setHabit(String habit) {
        this.habit = habit;
    }
}
