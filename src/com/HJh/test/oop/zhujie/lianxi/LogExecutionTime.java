package com.HJh.test.oop.zhujie.lianxi;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 1. 标注这个注解在【运行时】依然有效，这样反射才能读到它
@Retention(RetentionPolicy.RUNTIME)
// 2. 标注这个注解只能贴在【方法】上
@Target(ElementType.METHOD)
public @interface LogExecutionTime {
    // 3. 可以定义属性，并给个默认值
    String description() default "默认方法";
}

class LogInvocationHandler implements InvocationHandler {

    private final Object target; // 被代理的真实对象

    public LogInvocationHandler(Object target) {
        this.target = target;
    }

    // 当调用目标方法时，会自动进入这个方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 1. 检查这个方法上有没有贴 @LogExecutionTime 标签
        if (method.isAnnotationPresent(LogExecutionTime.class)) {
            LogExecutionTime annotation = method.getAnnotation(LogExecutionTime.class);
            String desc = annotation.description();

            long start = System.currentTimeMillis();
            // 2. 执行真实方法
            Object result = method.invoke(target, args);
            long end = System.currentTimeMillis();

            // 3. 打印耗时
            System.out.println("⏱️ [" + desc + "] 方法 " + method.getName() + " 耗时: " + (end - start) + "ms");
            return result;
        }
        // 没贴标签的方法，直接放行
        return method.invoke(target, args);
    }


}

// 1. 定义一个接口（动态代理通常需要接口）
interface UserService {
    void addUser();
    void deleteUser(); // 这个方法我们不贴标签
}

// 2. 真实业务类
class UserServiceImpl implements UserService {
    @Override
    @LogExecutionTime(description = "添加用户操作") // 👈 贴上标签！
    public void addUser() {
        try { Thread.sleep(1000); } catch (Exception e) {} // 模拟耗时
        System.out.println("✅ 用户添加成功！");
    }

    @Override
    public void deleteUser() {
        System.out.println("🗑️ 用户删除成功！");
    }
}

// 3. 测试运行
class Main {
    public static void main(String[] args) {
        UserService realService = new UserServiceImpl();

        // 生成代理对象（相当于给真实对象套了一层壳）
        UserService proxyService = (UserService) Proxy.newProxyInstance(
                realService.getClass().getClassLoader(),
                realService.getClass().getInterfaces(),
                new LogInvocationHandler(realService)
        );

        proxyService.addUser();    // 有标签，会打印耗时
        System.out.println("-------------------");
        proxyService.deleteUser(); // 没标签，正常执行
    }
}