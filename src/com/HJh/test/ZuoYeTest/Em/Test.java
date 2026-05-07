package com.hjh.test.zuoye.Em;

public class Test {
    public static void main(String[] args) {
        Employee[] emps = {
                new SalariedEmployee("张三", 3, 8000),
                new HourlyEmployee("李四", 5, 50, 180),
                new SalesEmployee("王五", 10, 50000, 5),
                new BasePlusSalesEmployee("赵六", 12, 80000, 3, 2000)
        };

        int month = 5;
        System.out.println(month + "月份工资:");
        for (Employee e : emps) {
            System.out.println(e.getName() + ": " + e.getSalary(month) + "元");
        }
    }
}
