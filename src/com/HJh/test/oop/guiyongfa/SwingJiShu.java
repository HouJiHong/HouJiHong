package com.HJh.test.oop.guiyongfa;

import javax.swing.*;

public class SwingJiShu {
    public static void main(String[] args) {
        //了解GUI swing 的使用
        //1.创建一个窗体（桌子）
        JFrame jf = new JFrame("登录窗体");
        //2.创建一个面板（桌布）
        JPanel jp = new JPanel();
        jf.add(jp);     //将面板添加到窗体中
        //设置窗体的属性
        jf.setSize(400,300);
        //窗体居中
        jf.setLocationRelativeTo(null);
        //窗体关闭
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //创建按钮
        JButton jb = new JButton("登录");
        jp.add(jb);
        //显示窗体
        jf.setVisible(true);

    }
}
