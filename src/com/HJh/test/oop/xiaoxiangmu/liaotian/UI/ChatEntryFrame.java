package com.HJh.test.oop.xiaoxiangmu.liaotian.UI;

import com.HJh.test.oop.xiaoxiangmu.liaotian.server.Constant;

import javax.swing.*;
import java.awt.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ChatEntryFrame extends JFrame {
    private JTextField nickNameField; //昵称输入框
    private JButton enterButton;
    private JButton cancelButton;
    private Socket socket;//记住当前的socket

    public ChatEntryFrame() {
        setTitle("局域网聊天室");
        setSize(350, 150);//设置窗体宽高
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//窗体关闭
        setLocationRelativeTo(null);//窗体居中
        setResizable( false);//窗体不可改变大小

        //设置背景
        getContentPane().setBackground(Color.decode("#F0F0F0"));
        //创建主面板
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.decode("#F0F0F0"));
        mainPanel.setLayout(new BorderLayout());//设置布局为边界布局
        this.add(mainPanel);
        //创建顶部面板
        JPanel topPanel = new JPanel(
                new FlowLayout(FlowLayout.CENTER, 10, 10));//设置布局为流式布局,10,10为组件之间的间隔
        topPanel.setBackground(Color.decode("#F0F0F0"));

        //标签和文本框
        JLabel nickNameLabel = new JLabel("昵称：");
        nickNameLabel.setFont(new Font("楷体", Font.BOLD, 16));
        nickNameField = new JTextField(10);
        nickNameField.setFont(new Font("楷体", Font.PLAIN, 16));
        nickNameField.setBorder(BorderFactory.createCompoundBorder( //设置边框
                BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray),//创建一个灰色的边框
                BorderFactory.createEmptyBorder(5, 5, 5, 5) //创建一个空的边框
        ));

        topPanel.add(nickNameLabel);
        topPanel.add(nickNameField);
        mainPanel.add(topPanel, BorderLayout.NORTH);

        //创建按钮面板
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBackground(Color.decode("#F0F0F0"));

        enterButton = new JButton("登录");
        enterButton.setFont(new Font("楷体", Font.BOLD, 16));
        enterButton.setBackground(Color.decode("#007BFF"));
        enterButton.setForeground(Color.white);
        enterButton.setBorderPainted( false);//边框不绘制
        enterButton.setFocusPainted( false);//焦点不绘制

        cancelButton = new JButton("取消");
        cancelButton.setFont(new Font("楷体", Font.BOLD, 16));
        cancelButton.setBackground(Color.decode("#DC3545"));
        cancelButton.setForeground(Color.white);
        cancelButton.setBorderPainted( false);
        cancelButton.setFocusPainted( false);

        //添加监听器
        enterButton.addActionListener(e -> {
            String nickName = nickNameField.getText();
            if (nickName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "请输入昵称！", "提示", JOptionPane.WARNING_MESSAGE);
            } else {
                //与服务端建立连接
                try {
                    login(nickName);
                    new ClientChatFrame(nickName, socket);
                    this.dispose();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

                
            }
        });

        cancelButton.addActionListener(e -> {
            this.dispose();
        });

        buttonPanel.add(enterButton);
        buttonPanel.add(cancelButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        this.setVisible( true);
    }

    private void login(String nickName) throws Exception {
        //创建Socket对象，建立连接
        socket = new Socket(Constant.ServerIP,Constant.Port);
        //发送消息类型和昵称给服务端
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeInt(1);
        dos.writeUTF(nickName);
        dos.flush();
    }
}
