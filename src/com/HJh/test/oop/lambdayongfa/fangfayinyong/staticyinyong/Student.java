package com.HJh.test.oop.lambdayongfa.fangfayinyong.staticyinyong;

public class Student {
    private String name;
    private int age;
    private String sex;
    private double height;

    //定义了一个静态方法用来静态引用
    public static int compareAge(Student o1, Student o2) {
        return o1.getAge()-o2.getAge();   // 升序
    }





    public Student() {
    }

    public Student(String name, int age, String sex, double height) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.height = height;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", height=" + height +
                '}';
    }
}
