package com.HJh.test.oop.duotaiyongfa.jichu.lianxi2;

public class Student extends  People{
    private String school;

    @Override
    public String getDescription() {
        return "'s school is " + school;
    }

    public Student(String school) {
        this.school = school;
    }

    public Student(String name, String school) {
        super(name);
        this.school = school;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
