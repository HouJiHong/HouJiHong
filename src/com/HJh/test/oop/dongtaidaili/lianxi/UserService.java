package com.HJh.test.oop.dongtaidaili.lianxi;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 1. 定义接口
public interface UserService {
    void saveUser(String username);
}

// 2. 目标类（真实业务逻辑）
class UserServiceImpl implements UserService {
    @Override
    public void saveUser(String username) {
        System.out.println("【核心业务】正在保存用户: " + username);
    }
}

class JdkDynamicProxy {
    private final Object target; // 目标对象

    public JdkDynamicProxy(Object target) {
        this.target = target;
    }

    // 获取代理对象的方法
    public Object getProxy() {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 类加载器
                target.getClass().getInterfaces(),  // 目标类实现的所有接口
                new InvocationHandler() {           // 调用处理器
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 前置增强
                        System.out.println("[JDK代理] 前置增强: 准备保存用户...");

                        // 执行目标方法
                        Object result = method.invoke(target, args);

                        // 后置增强
                        System.out.println("[JDK代理] 后置增强: 用户保存成功！");
                        return result;
                    }
                }
        );
    }

    // 测试运行
    public static void main(String[] args) {
        UserService target = new UserServiceImpl();
        // 强转为接口类型
        UserService proxy = (UserService) new JdkDynamicProxy(target).getProxy();
        proxy.saveUser("张三");
    }
}