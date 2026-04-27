package com.HJh.test.oop.guiyongfa.employeesys.UI;

import com.HJh.test.oop.guiyongfa.employeesys.bean.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginUi extends JFrame implements ActionListener {
    //以下四个成员变量是为了以后访问
    private JTextField username;//用户名
    private JPasswordField password;//密码
    private JButton login;//登录
    private JButton register;//注册

    private static ArrayList<User> allUsers = new ArrayList<>();

    static {
        allUsers.add(new User("张三","123456","zhangsan"));
        allUsers.add(new User("李四","123456","lisi"));
        allUsers.add(new User("王五","123456","wangwu"));
    }


    public LoginUi(){
        this.setTitle("登录界面");
        this.setSize(400,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
    }
    public void init(){
        //初始化面板内容
        JPanel jp = new JPanel();
        jp.setLayout(null);//设置布局,默认是流式布局
        jp.setBackground(new Color(0,100,200));

        //设置字体和颜色
        Font customFont = new Font("微软雅黑",Font.PLAIN,16);
        Color primaryColor = new Color(0,50,255);
        Color secondaryColor = new Color(0,200,100);

        //标题
        JLabel title = new JLabel("人事登录界面");
        title.setBounds(135,50,200,30);//设置标题的位置
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
        //jp.setVisible(true);



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
        String username = this.username.getText();
        String password = new String(this.password.getPassword());
        if(username.isEmpty()||password.isEmpty()){
            JOptionPane.showMessageDialog(this,"用户名或密码不能为空");
        }else{
            User user = getUserByLoginName(username);
            if(user!=null){
                JOptionPane.showMessageDialog(this,"用户已存在");
            }else{
                allUsers.add(new User(username,password,username));
                JOptionPane.showMessageDialog(this,"注册成功");
            }
        }

    }




    //登录逻辑
    private void login(){
        String username = this.username.getText();
        String password = new String(this.password.getPassword());
        User user = getUserByLoginName(username);
        if(user==null){
            JOptionPane.showMessageDialog(this,"用户不存在");
        }else if(!user.getPassword().equals(password)){
            JOptionPane.showMessageDialog(this,"密码错误");
        }else{
            EmployeeMangerUI employeeUI = new EmployeeMangerUI(user.getUsername());
            employeeUI.setVisible(true);
            this.dispose(); //关闭当前窗口
        }
    }
    private User getUserByLoginName(String loginName){
        for (int i = 0; i < allUsers.size(); i++) {
            User user = allUsers.get(i);
            if(user.getLoginName().equals(loginName)){
                return user;
            }
        }
        return null;
    }






}
