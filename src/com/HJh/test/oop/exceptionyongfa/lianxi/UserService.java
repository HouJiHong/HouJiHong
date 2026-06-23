package com.HJh.test.oop.exceptionyongfa.lianxi;

public class UserService {

    public void registerUser(String username) {
        // 1. 模拟业务校验
        if (username == null || username.trim().isEmpty()) {
            // 抛出带有错误码的自定义异常
            throw new BusinessException(400, "用户名不能为空");
        }

        if ("admin".equalsIgnoreCase(username)) {
            throw new BusinessException(403, "该用户名已被保留，无法注册");
        }

        // 2. 模拟数据库操作可能引发的异常
        try {
            // saveToDatabase(username);
        } catch (Exception e) {
            // 包装原始异常并抛出，方便排查问题
            throw new BusinessException(500, "用户注册失败，请稍后重试", e);
        }

        System.out.println("用户 " + username + " 注册成功！");
    }

    // 测试入口
    public static void main(String[] args) {
        UserService userService = new UserService();

        try {
            userService.registerUser("admin");
        } catch (BusinessException e) {
            System.out.println("捕获到业务异常:");
            System.out.println("错误码: " + e.getCode());
            System.out.println("错误信息: " + e.getMessage());
        }
    }
}