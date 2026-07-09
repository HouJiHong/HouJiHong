package com.HJh.test.ZuoYeTest.Em;

public class HourlyEmployee extends Employee {

        private int hourlyWage; // 时薪
        private int hoursWorked; // 工作小时

        public HourlyEmployee(String name, int birthMonth, int hourlyWage, int hoursWorked) {
            super(name, birthMonth);
            this.hourlyWage = hourlyWage;
            this.hoursWorked = hoursWorked;
        }

        @Override
        public int getSalary(int month) {
            int salary;
            if (hoursWorked > 160) {
                salary = 160 * hourlyWage + (int)((hoursWorked - 160) * hourlyWage * 1.5);
            } else {
                salary = hoursWorked * hourlyWage;
            }
            return salary + super.getSalary(month);
        }

}
