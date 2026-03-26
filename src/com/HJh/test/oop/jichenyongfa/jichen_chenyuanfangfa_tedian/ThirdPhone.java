package com.HJh.test.oop.jichenyongfa.jichen_chenyuanfangfa_tedian;

public class ThirdPhone extends SecondPhone{

    //alt+insert选择第三个override...，进行方法重写


    @Override
    public void call() {
        super.call();
        System.out.println("打视频");
    }
    public void playGame(){
        System.out.println("打游戏");
    }
}
