package com.HJh.test.oop.dongtaidaili;
//代理工具类，专门负责创建代理对象并返回去使用

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {
    public static StarService createProxy(Star s){ //代理和被代理对象都使用同一个接口StarService，
                                                // 所以返回值可以写同一个接口，如果有多个接口，则返回值可以写Object
        //参数一：类加载器，随便什么类加载器都可以
        //参数二：代理对象和被代理所实现的接口,可能有多个，所以用数组new Class[]{StarService.class},
                                //由于被代理对象Star实现了同样的接口，所以这里可以用s.getClass().getInterfaces()
        //参数三：在InvocationHandler的匿名类中，实现invoke方法，用于代理对象要干什么事情
        StarService proxy =(StarService) Proxy.newProxyInstance(ProxyUtil.class.getClassLoader(),
                s.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //申明代理要干什么
                        //参数一：用于接收代理对象
                        //参数二：用于接收代理对象被调用的方法,也就是接收main方法里的proxy.sing("《学而不思则罔》");
                        //参数三：用于接收代理对象被调方法的参数,也就是"《学而不思则罔》"
                        String methodName = method.getName();
                        if ("sing".equals(methodName)){
                            System.out.println("代理做唱歌准备工作,收钱");
                        }else if ("dance".equals(methodName)){
                            System.out.println("代理做跳舞准备工作,收钱");
                        }
                        //调用被代理对象方法(明星开始干活)
                        Object result = method.invoke(s, args); //反射的逻辑
                        return result;  //如果明星的方法有返回值
                    }
                });
        return proxy;
    }
}
