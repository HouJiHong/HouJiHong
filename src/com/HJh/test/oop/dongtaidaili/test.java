package com.HJh.test.oop.dongtaidaili;
//●java.lang.reflect.Proxy类：提供了为对象产生代理对象的方法:
//public static Object newProxyInstance(classLoader loader，Class<?>[] interfaces，InvocationHandler h)
//参数一：用于指定用哪个类加载器，去加载生成的代理类
//参数二：指定接口，这些接口用于指定生成的代理长什么，也就是有哪些方法
//参数三：用来指定生成的代理对象要干什么事情

public class test {
    public static void main(String[] args) {

        //1.创建一个明星，实现一些接口
        Star star = new Star("张三");
        //2.为明星创建代理（创建工具类，不然太臃肿），同样要实现相同的接口
        StarService proxy = ProxyUtil.createProxy(star);
        //之后所有要明星做的事情，都通过代理对象来完成，代理会通过invoke的逻辑来调用明星的方法
        proxy.sing("《学而不思则罔》");//会得到null
        System.out.println(proxy.dance());//会得到字符串"表演结束"


    }
}
