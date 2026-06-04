package com.HJh.test.oop.guiyongfa.tuxiangchakan.Bean;

import javax.swing.*;
public class User {
    private JTextField username;
    private JPasswordField password;

    public User() {
    }

    public User(JTextField username, JPasswordField password) {
        this.username = username;
        this.password = password;
    }

    public JTextField getUsername() {
        return username;
    }

    public void setUsername(JTextField username) {
        this.username = username;
    }

    public JPasswordField getPassword() {
        return password;
    }

    public void setPassword(JPasswordField password) {
        this.password = password;
    }
}
