package com.HJh.test.oop.duoxiancheng.threadsate.problem;

public class Account {
    private String id;
    private double money;

    public void drawMoney(double drawMoney){
        String name = Thread.currentThread().getName();

        if(money >= drawMoney){

            System.out.println(name+"取钱成功，取了："+drawMoney+"元");
            money -= drawMoney;
            System.out.println(name+"取钱成功，余额为："+money);
        }else{
            System.out.println(name+"取钱失败，余额不足！");
        }

    }




    public Account() {
    }

    public Account(String id, double money) {
        this.id = id;
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
