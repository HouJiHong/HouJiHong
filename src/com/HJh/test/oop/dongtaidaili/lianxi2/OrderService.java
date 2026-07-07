package com.HJh.test.oop.dongtaidaili.lianxi2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface OrderService {
    void createOrder(String productName, int quantity);
    void cancelOrder(String orderId);
}

class OrderServiceImpl implements OrderService {
    @Override
    public void createOrder(String productName, int quantity) {
        System.out.println("📦 [核心业务] 成功创建订单：商品=" + productName + ", 数量=" + quantity);
    }

    @Override
    public void cancelOrder(String orderId) {
        System.out.println("🚫 [核心业务] 成功取消订单，订单号：" + orderId);
    }
}

class SystemLogHandler implements InvocationHandler {
    private final Object target;

    public SystemLogHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 【前置增强 1：权限校验】
        System.out.println("🔒 [安全拦截] 正在校验当前用户是否具备 [" + method.getName() + "] 的操作权限...");
        boolean hasPermission = checkPermission(method.getName()); // 模拟权限校验
        if (!hasPermission) {
            System.out.println("❌ [安全拦截] 权限不足，操作被拒绝！");
            return null; // 直接拦截，不执行真实业务
        }

        // 【前置增强 2：记录开始时间】
        long startTime = System.currentTimeMillis();
        System.out.println("📝 [系统日志] 开始执行方法：" + method.getName() + "，参数：" + java.util.Arrays.toString(args));

        // 【核心】调用真实对象的方法
        Object result = method.invoke(target, args);

        // 【后置增强：记录耗时与完成状态】
        long costTime = System.currentTimeMillis() - startTime;
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("✅ [系统日志] 方法执行完成，耗时：" + costTime + "ms，执行时间：" + now);

        return result;
    }

    // 模拟权限校验方法（实际项目中可能读取 Redis 或数据库）
    private boolean checkPermission(String methodName) {
        // 假设取消订单需要高级权限，这里简单模拟
        return !methodName.equals("cancelOrder");
    }
}

class OrderSystemDemo {
    public static void main(String[] args) {
        // 1. 创建真实的订单服务对象
        OrderService realOrderService = new OrderServiceImpl();

        // 2. 包装系统日志与权限处理器
        SystemLogHandler logHandler = new SystemLogHandler(realOrderService);

        // 3. 动态生成代理对象
        OrderService proxyOrderService = (OrderService) Proxy.newProxyInstance(
                realOrderService.getClass().getClassLoader(),
                realOrderService.getClass().getInterfaces(),
                logHandler
        );

        System.out.println("========== 测试1：正常创建订单 ==========");
        proxyOrderService.createOrder("iPhone 15", 1);

        System.out.println("\n========== 测试2：尝试取消订单（模拟无权限） ==========");
        proxyOrderService.cancelOrder("ORD-20231001");
    }
}