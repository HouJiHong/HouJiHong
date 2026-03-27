package com.HJh.test.oop.jichenyongfa.jichenzuoye;

public class YiDIKuaiDi extends JiChuKuaiDi {
    @Override
    public int calculateFee() {
        int fee = super.calculateFee();
        return fee+15;
    }

    public YiDIKuaiDi() {
    }

    public YiDIKuaiDi(String danHao, int weight, String receiver) {
        super(danHao, weight, receiver);
    }
}
