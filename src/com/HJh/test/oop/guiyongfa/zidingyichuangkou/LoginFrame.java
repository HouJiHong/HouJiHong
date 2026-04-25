package com.HJh.test.oop.guiyongfa.zidingyichuangkou;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame implements ActionListener {
    //初始化窗体
    public LoginFrame() {
        //设置窗体的标题
        this.setTitle("登录界面");
        //设置窗体的宽高
        this.setSize(400, 300);
        //设置窗体的位置
        this.setLocation(200, 200);
        //设置窗体关闭模式
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        init();
    }
    //初始化窗体内容
    private void init() {
        JPanel jp = new JPanel();
        JButton jb = new JButton("登录");

        //这个this既代表着窗体，也可以代表actionListener对象,因为类继承了jframe类和actionListener接口
        jb.addActionListener(this);

        this.add(jp);
        jp.add(jb);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this,"登录成功！");
    }
}
