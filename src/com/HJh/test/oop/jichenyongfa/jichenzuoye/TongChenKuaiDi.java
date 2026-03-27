package com.HJh.test.oop.jichenyongfa.jichenzuoye;

public class TongChenKuaiDi extends JiChuKuaiDi {
    @Override
    public int calculateFee() {
        int fee = super.calculateFee();
        return fee+10;
    }

    public TongChenKuaiDi() {
    }

    public TongChenKuaiDi(String danHao, int weight, String receiver) {
        super(danHao, weight, receiver);
    }
}
