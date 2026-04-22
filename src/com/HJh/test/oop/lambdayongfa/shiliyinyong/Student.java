package com.HJh.test.oop.lambdayongfa.shiliyinyong;

public class Student {
    private String name;
    private int age;
    private String sex;
    private double height;

    //定义了一个静态方法用来静态引用
    public static int compareAge(Student o1, Student o2) {
        return o1.getAge()-o2.getAge();   // 升序
    }

    //定义了一个实例方法用来实例引用
    //由于比较的两个是double类型，但是返回值是int，所以要用Double.compare()方法
    public int compareHeight(Student o1, Student o2) {
        return Double.compare(o1.getHeight(), o2.getHeight());
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
