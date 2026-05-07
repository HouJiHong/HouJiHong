package com.hjh.test.zuoye.Em;

public class BasePlusSalesEmployee extends SalesEmployee {

        private int baseSalary; // 底薪

        public BasePlusSalesEmployee(String name, int birthMonth, int sales, double rate, int baseSalary) {
            super(name, birthMonth, sales, rate);
            this.baseSalary = baseSalary;
        }

        @Override
        public int getSalary(int month) {
            return baseSalary + super.getSalary(month);
        }

}
