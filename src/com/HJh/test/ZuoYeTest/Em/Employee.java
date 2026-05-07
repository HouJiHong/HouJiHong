package com.hjh.test.zuoye.Em;

public class Employee {

    private String name;
    private int birthMonth; // 生日月份，直接用整数

    public Employee() {
    }

    public Employee(String name, int birthMonth) {
        this.name = name;
        this.birthMonth = birthMonth;
    }

    // 计算工资，生日月额外+100
    public int getSalary(int month) {
        int bonus = (month == birthMonth) ? 100 : 0;
        return bonus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }


}
