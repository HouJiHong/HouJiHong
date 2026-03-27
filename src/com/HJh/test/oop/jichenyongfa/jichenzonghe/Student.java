package com.HJh.test.oop.jichenyongfa.jichenzonghe;

public class Student extends Person {
    private String grade;
    public void study(){
        System.out.println("在学习");
    }

    public Student() {
    }

    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }


    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
