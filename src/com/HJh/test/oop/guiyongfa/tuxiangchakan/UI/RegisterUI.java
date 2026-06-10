package com.HJh.test.oop.guiyongfa.tuxiangchakan.UI;

import com.HJh.test.oop.guiyongfa.tuxiangchakan.Bean.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RegisterUI extends JFrame implements ActionListener {
    private List<User> users;

    //用戶名，密碼
    private JTextField username;
    private JPasswordField password;
    //注冊，取消按鈕
    private JButton btnRegister;
    private JButton btnCancel;


    public RegisterUI() {
        setTitle("注冊");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        //設置背景
        getContentPane().setBackground(new Color(0, 100, 200));
        init();
    }

    public RegisterUI(List<User>  users){
        this();
        this.users = users;
    }


    private void init() {
        JPanel jp = new JPanel();
        jp.setLayout(null);
        jp.setBackground(new Color(0, 100, 200));

        Font customFont = new Font("微软雅黑", Font.PLAIN, 16);
        Color primaryColor = new Color(0, 50, 255);
        Color secondaryColor = new Color(150, 150, 150);

        //标题
        JLabel title = new JLabel("注册");
        title.setBounds(135, 50, 200, 30);
        title.setFont(new Font("微软雅黑", Font.BOLD, 20));
        jp.add(title);

        //用户名
        JLabel usernameLabel = new JLabel("用户名：");
        usernameLabel.setBounds(100, 100, 80, 30);
        usernameLabel.setFont(customFont);
        jp.add(usernameLabel);

        //用户名输入框
        username = new JTextField();
        username.setBounds(180, 100, 150, 30);
        username.setFont(customFont);
        jp.add(username);

        //密码
        JLabel passwordLabel = new JLabel("密码：");
        passwordLabel.setBounds(100, 150, 80, 30);
        passwordLabel.setFont(customFont);
        jp.add(passwordLabel);

        //密码输入框
        password = new JPasswordField();
        password.setBounds(180, 150, 150, 30);
        password.setFont(customFont);
        jp.add(password);

        //注册按钮
        btnRegister = new JButton("注册");
        btnRegister.setBounds(100, 200, 80, 30);
        btnRegister.setFont(customFont);
        btnRegister.setBackground(primaryColor);
        btnRegister.setForeground(Color.WHITE);
        jp.add(btnRegister);
        btnRegister.addActionListener(this);

        //取消按钮
        btnCancel = new JButton("取消");
        btnCancel.setBounds(200, 200, 80, 30);
        btnCancel.setFont(customFont);
        btnCancel.setBackground(secondaryColor);
        btnCancel.setForeground(Color.WHITE);
        jp.add(btnCancel);
        btnCancel.addActionListener(this);

        this.add(jp);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegister) {
            register();
        } else {
            cancel();
        }
    }

    //注册逻辑
    private void register() {
        String user = username.getText().trim();
        String pwd = new String(password.getPassword());

        if (user.isEmpty() || pwd.isEmpty()) {
            JOptionPane.showMessageDialog(this, "用户名或密码不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }

        //检查用户名是否已存在
        if (isUserExists(user)) {
            JOptionPane.showMessageDialog(this, "用户名已存在！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }

        //保存用户信息到文件
        saveUser(user, pwd);
        JOptionPane.showMessageDialog(this, "注册成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

        //返回登录界面
        new LoginUi().setVisible(true);
        this.dispose();
    }

    //检查用户是否存在
    private boolean isUserExists(String username) {
        for (User user : users){
            if (user.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    //保存用户信息
    private void saveUser(String username, String password) {
        File file = new File("src/com/HJh/test/oop/guiyongfa/tuxiangchakan/resource/User.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write(username + "," + password);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //取消注册，返回登录界面
    private void cancel() {
        new LoginUi().setVisible(true);
        this.dispose();
    }
}
