package com.hjh.test.zuoye.Em;

public class SalesEmployee extends Employee {

        private int sales; // 销售额
        private double rate; // 提成率(%)

        public SalesEmployee(String name, int birthMonth, int sales, double rate) {
            super(name, birthMonth);
            this.sales = sales;
            this.rate = rate;
        }

        @Override
        public int getSalary(int month) {
            int commission = (int)(sales * rate / 100);
            return commission + super.getSalary(month);
        }

}
