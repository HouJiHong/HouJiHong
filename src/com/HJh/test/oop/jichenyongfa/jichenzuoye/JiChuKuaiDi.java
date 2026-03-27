package com.HJh.test.oop.jichenyongfa.jichenzuoye;

public class JiChuKuaiDi {
    private String danHao;
    private int weight;
    private String receiver;
    public int calculateFee(){
        return weight*10;
    }

    public JiChuKuaiDi() {
    }

    public JiChuKuaiDi(String danHao, int weight, String receiver) {
        this.danHao = danHao;
        this.weight = weight;
        this.receiver = receiver;
    }



    public String getDanHao() {
        return danHao;
    }

    public void setDanHao(String danHao) {
        this.danHao = danHao;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
}
