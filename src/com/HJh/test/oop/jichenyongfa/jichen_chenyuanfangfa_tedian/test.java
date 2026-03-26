package com.HJh.test.oop.jichenyongfa.jichen_chenyuanfangfa_tedian;

//继承在成员方法中，可以调用父类的成员方法，也可以重写父类方法
//在重写时，要保持与父类方法的参数列表、返回值类型、异常类型等一致


/*第一代手机：功能：打电话
第二代手机：功能：打电话+发短信
第三代手机：功能：打电话升级成打视频+发短信+打游戏*/


public class test {
    public static void main(String[] args) {
        //第一代
        FristPhone fristPhone = new FristPhone();
        fristPhone.call();
        System.out.println("-----------------");

        //第二代  继承父类方法
        SecondPhone secondPhone = new SecondPhone();
        secondPhone.call();
        secondPhone.send();
        System.out.println("-----------------");

        //第三代  继承并重写父类方法
        ThirdPhone thirdPhone = new ThirdPhone();
        thirdPhone.call();
        thirdPhone.send();
        thirdPhone.playGame();
    }
}
