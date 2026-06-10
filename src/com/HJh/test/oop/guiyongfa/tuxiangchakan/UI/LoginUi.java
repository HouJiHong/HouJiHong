package com.HJh.test.oop.guiyongfa.tuxiangchakan.UI;


import com.HJh.test.oop.guiyongfa.tuxiangchakan.Bean.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginUi extends JFrame implements ActionListener {
    private static List<User> users = new ArrayList<>();
    //查找src/com/HJh/test/oop/guiyongfa/tuxiangchakan/resource/User.txt文件，不存在就创建
    static {
        File file = new File("src/com/HJh/test/oop/guiyongfa/tuxiangchakan/resource/User.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //读取文件,并将内容添加到users列表中
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");//读了一行数据，用逗号分隔开，存入parts数组中
                users.add(new User(parts[0], parts[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(users);

    }

    //以下四个成员变量是为了以后访问
    private JTextField username;//用户名
    private JPasswordField password;//密码
    private JButton login;//登录
    private JButton register;//注册

    public LoginUi(){
        this.setTitle("登录");
        this.setSize(400,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
    }
    public void init(){
        //初始化面板内容
        JPanel jp = new JPanel();
        jp.setLayout(null);//设置布局,默认是流式布局
        jp.setBackground(new Color(9, 210, 234));

        //设置字体和颜色
        Font customFont = new Font("微软雅黑",Font.PLAIN,16);
        Color primaryColor = new Color(151, 36, 244);
        Color secondaryColor = new Color(0,200,100);

        //标题
        JLabel title = new JLabel("登录");
        title.setBounds(150 ,50,200,30);//设置标题的位置
        title.setFont(new Font("微软雅黑",Font.BOLD,20));
        jp.add(title);

        //用户名
        JLabel usernameLabel = new JLabel("用户名：");
        usernameLabel.setBounds(100,100,80,30);
        usernameLabel.setFont(customFont);
        jp.add(usernameLabel);

        //用户名输入框
        username = new JTextField();
        username.setBounds(180,100,150,30);
        username.setFont(customFont);
        jp.add(username);

        //密码
        JLabel passwordLabel = new JLabel("密码：");
        passwordLabel.setBounds(100,150,80,30);
        passwordLabel.setFont(customFont);
        jp.add(passwordLabel);

        //密码输入框
        password = new JPasswordField();
        password.setBounds(180,150,150,30);
        password.setFont(customFont);
        jp.add(password);

        //登录按钮
        login = new JButton("登录");
        login.setBounds(100,200,80,30);
        login.setFont(customFont);
        login.setBackground(primaryColor);
        login.setForeground(Color.WHITE);
        jp.add(login);
        login.addActionListener(this);

        //注册按钮
        register = new JButton("注册");
        register.setBounds(200,200,80,30);
        register.setFont(customFont);
        register.setBackground(secondaryColor);
        register.setForeground(Color.WHITE);
        jp.add(register);
        register.addActionListener(this);

        this.add(jp);




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login){
            login();
        }else{
            register();
        }
    }

    //注册逻辑
    private void register() {
        new RegisterUI(users).setVisible(true);
        this.dispose();

    }




    //登录逻辑
    private void login(){
        String user = username.getText().trim();
        String pwd = new String(password.getPassword());
        if (user.isEmpty() || pwd.isEmpty()) {
            JOptionPane.showMessageDialog(this, "用户名或密码不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        //验证用户
        if (validateUser(user, pwd)) {
            JOptionPane.showMessageDialog(this, "登录成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
            //打开图片显示界面
            new PictureShow().setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "用户名或密码错误！", "提示", JOptionPane.ERROR_MESSAGE);
        }

    }
    private boolean validateUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }







}