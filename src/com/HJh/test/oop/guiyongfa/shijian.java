package com.HJh.test.oop.guiyongfa;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class shijian {
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

        //给按钮添加点击事件,所以用jb. ,e 为接受的事件对象，这里是点击事件对象
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("登录按钮被点击了");
                JOptionPane.showMessageDialog(jf,"登录成功！");
            }
        });

        //创建按键事件,这里的e就接受上下左右按键的对象,因为监听的对象是窗体，所以用jf.
        jf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if(keyCode == KeyEvent.VK_UP){
                    System.out.println("按下了上");
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    System.out.println("按下了下");
                } else if (keyCode == KeyEvent.VK_LEFT) {
                    System.out.println("按下了左");
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    System.out.println("按下了右");
                }
            }
        });

        //因为在窗体上创建了面板，面板上创建了按钮，此时焦点在按钮上，监听窗体的按键事件不在焦点，没有响应（按钮和按键冲突）
        //所以需要将焦点设置在窗体上
        jf.setFocusable(true);

        //显示窗体
        jf.setVisible(true);

    }
}
