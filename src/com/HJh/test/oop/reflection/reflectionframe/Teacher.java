package com.HJh.test.oop.reflection.reflectionframe;

public class Teacher {
    private String name;
    private int age;
    private String habit;
    private double salary;
    private String sex;
    private String phone;

    public Teacher() {
    }

    public Teacher(String name, int age, String habit, double salary, String sex, String phone) {
        this.name = name;
        this.age = age;
        this.habit = habit;
        this.salary = salary;
        this.sex = sex;
        this.phone = phone;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
