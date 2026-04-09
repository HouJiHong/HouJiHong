package com.HJh.test.oop.duotaiyongfa.jichu.lianxi2;

public class Employee extends  People{
    private double salary;

    @Override
    public String getDescription() {
        return String.format("'s salary is $%.2f", salary);
    }

    public Employee(double salary) {
        this.salary = salary;
    }

    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
