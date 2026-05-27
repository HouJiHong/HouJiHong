package com.HJh.test.oop.xiaoxiangmu.liaotian.UI;

import javax.swing.*;
import java.awt.*;

public class ClientChatFrame extends JFrame {
    private JTextArea smsContent = new JTextArea(23,50);
    private JTextArea smsSend = new JTextArea(4,40);
    public JList< String> onLineUsers = new JList<>();
    private JButton sendButton = new JButton("发送");

    public ClientChatFrame() {
        initView();
        this.setVisible( true);
    }

    private void initView() {
        this.setSize(700,600);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        //设置窗口背景色
        this.getContentPane().setBackground(Color.decode("#F0F0F0"));
        //设置字体
        Font font = new Font("微软雅黑", Font.PLAIN, 14);
        //消息内容框
        smsContent.setFont(font);
        smsContent.setBackground(new Color(0Xdd,0Xdd,0Xdd));
        smsContent.setEditable(false);//消息框不可编辑

        //发送框
        smsSend.setFont(font);
        smsSend.setWrapStyleWord( true);//换行,默认是按字符换行
        smsSend.setLineWrap( true);//按行换行

        //在线用户列表
        onLineUsers.setFont(font);
        onLineUsers.setFixedCellHeight(120);//设置列表项高度
        onLineUsers.setVisibleRowCount(13);//设置可见行数

        //创建底部面板
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(Color.white);

        //消息输入框
        JScrollPane smsSendScrollPane = new JScrollPane(smsSend);//创建滚动面板
        smsSendScrollPane.setBorder(BorderFactory.createEmptyBorder());//边框
        smsSendScrollPane.setPreferredSize(new Dimension(500, 10));//设置大小

        //发送按钮
        sendButton.setFont(font);
        sendButton.setBackground(Color.decode("#007BFF"));
        sendButton.setForeground(Color.white);

        //按钮面板
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));//创建按钮面板:居左,5,5为组件之间的间隔
        buttonPanel.setBackground(Color.white);
        buttonPanel.add(sendButton);

        //添加组件
        bottomPanel.add(smsSendScrollPane, BorderLayout.CENTER);//添加消息输入框
        bottomPanel.add(buttonPanel, BorderLayout.EAST);//添加按钮面板

        //用户列表面板
        JScrollPane userListScrollPane = new JScrollPane(onLineUsers);
        userListScrollPane.setBorder(BorderFactory.createEmptyBorder());
        userListScrollPane.setPreferredSize(new Dimension(120, 500));

        //中心消息面板
        JScrollPane smsContentScrollPane = new JScrollPane(smsContent);
        smsContentScrollPane.setBorder(BorderFactory.createEmptyBorder());

        this.add(smsContentScrollPane, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
        this.add(userListScrollPane, BorderLayout.EAST);

        this.setVisible( true);
    }
}
