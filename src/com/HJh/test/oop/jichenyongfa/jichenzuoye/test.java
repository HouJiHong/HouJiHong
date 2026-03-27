package com.HJh.test.oop.jichenyongfa.jichenzuoye;

/*计算运费，基础快递属性：单号string，重量int，收件人string。行为：计算运费（每公斤10元）
同城快递：在原基础上+10元
异地空运：在原基础上+15元*/


public class test {
    public static void main(String[] args) {
        TongChenKuaiDi t1 = new TongChenKuaiDi("123456", 10, "张三");
        System.out.println(t1.getDanHao()+" "+t1.getWeight()+" "+t1.getReceiver());
        System.out.println("运费："+t1.calculateFee());

        YiDIKuaiDi y1 = new YiDIKuaiDi("23456", 20, "李四");
        System.out.println(y1.getDanHao()+" "+y1.getWeight()+" "+y1.getReceiver());
        System.out.println("运费："+y1.calculateFee());

    }
}
