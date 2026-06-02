package com.HJh.test.oop.dongtaidaili.aop;

//AOP（Aspect-Oriented Programming，面向切面编程）
//是一种编程思想，用于将横切关注点（cross-cutting concerns）与业务逻辑分离。

//横切关注点：指那些散布在多个模块中、与核心业务逻辑无关但又是系统必需的功能，例如：
    //日志记录、事务管理、权限验证、性能监控、异常处理。当遇到这些时，通常使用代理将横切关注点封装起来，程序运行时，
    // 切入到代理，执行横切逻辑，再调用被代理对象方法。

import java.util.Arrays;

public class test {
    public static void main(String[] args) throws InterruptedException {
        /* 场景
        ●某系统有一个用户管理类，包含用户登录，删除用户，查询用户等功能，系统要求统
        计每个功能的执行耗时情况，以便后期观察程序性能。
        需求
         将业务中重复的内容（切面：记录程序性能）提取出来，用代理封装*/

        UserService userService = ProxyUtil.createProxy(new UserServiceImpl());
        userService.login("admin","admin");
        userService.deleteUsers();
        String[] users = userService.queryUsers();
        System.out.println(Arrays.toString( users));


    }
}
