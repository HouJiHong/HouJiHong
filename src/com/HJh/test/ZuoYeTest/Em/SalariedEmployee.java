package com.hjh.test.zuoye.Em;

public class SalariedEmployee extends Employee {

        private int monthlySalary; // 月薪

        public SalariedEmployee(String name, int birthMonth, int monthlySalary) {
            super(name, birthMonth);
            this.monthlySalary = monthlySalary;
        }

        @Override
        public int getSalary(int month) {
            return monthlySalary + super.getSalary(month);
        }


}
