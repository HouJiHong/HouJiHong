package com.HJh.test.oop.jichenyongfa.jichenzonghe;

public class Teacher extends Person {
    private String subject;
    public void teach() {
        System.out.println("在教学");
    }

    public Teacher() {
    }

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }
}
