package com.HJh.test.oop.dongtaidaili.aop;

//这个代理类代码以后都可以无需修改，以后想要添加功能只需要修改接口和实现类，代理类执行程序时总是会加上代理逻辑
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {
    @SuppressWarnings("unchecked")
    public static <T> T createProxy(T s){//使用泛型可以让该方法兼容所有对象
        T proxy =(T) Proxy.newProxyInstance(ProxyUtil.class.getClassLoader(),
                s.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        long start = System.currentTimeMillis();
                        //真正调用被代理对象方法
                        Object result = method.invoke(s, args);
                        long end = System.currentTimeMillis();
                        System.out.println("耗时："+(end-start));
                        return result;
                    }
                }

        );
        return proxy;
    }
}
