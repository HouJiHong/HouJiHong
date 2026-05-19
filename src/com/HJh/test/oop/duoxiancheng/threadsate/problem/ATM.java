package com.HJh.test.oop.duoxiancheng.threadsate.problem;

public class ATM extends  Thread{
    private Account account;
    public ATM(String name,Account account) {
        super(name);
        this.account = account;

    }
    @Override
    public void run() {
        account.drawMoney(1000);


    }

}
