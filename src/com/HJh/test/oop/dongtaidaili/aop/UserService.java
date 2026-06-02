package com.HJh.test.oop.dongtaidaili.aop;

public interface UserService {
    //登录
    void login(String name, String password) throws InterruptedException;
    //删掉用户
    void deleteUsers() throws InterruptedException;
    //查询用户，返回数组
    String[] queryUsers() throws InterruptedException;


}
