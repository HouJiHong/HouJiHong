package com.HJh.test.oop.dongtaidaili.aop;

public class UserServiceImpl implements UserService{
    @Override
    public void login(String name, String password) throws InterruptedException {
        //记录执行开始时间(重复代码，交给代理)
        //long start = System.currentTimeMillis();
        //简单的判断
        if("admin".equals(name) && "admin".equals(password)){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }
        Thread.sleep(1000);
        //long end = System.currentTimeMillis();
        //System.out.println("耗时："+(end-start));

    }

    @Override
    public void deleteUsers() throws InterruptedException {
        //long start = System.currentTimeMillis();
        System.out.println("删除用户");
        Thread.sleep(1500);
        //long end = System.currentTimeMillis();
        //System.out.println("耗时："+(end-start));

    }

    @Override
    public String[] queryUsers() throws InterruptedException {
        //long start = System.currentTimeMillis();
        String[] names = {"张三","李四","王五"};
        Thread.sleep(500);
        //long end = System.currentTimeMillis();
        //System.out.println("耗时："+(end-start));
        return names;
    }
}
