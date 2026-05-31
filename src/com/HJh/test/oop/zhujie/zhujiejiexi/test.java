package com.HJh.test.oop.zhujie.zhujiejiexi;

//注解的解析
//●就是判断类上、方法上、成员变量上是否存在注解，并把 注解里的内容 给解析出来。
//如何解析注解？
//指导思想：要解析谁上面的注解，就应该先拿到谁。（需要用到反射）
//比如要解析类上面的注解，则应该先获取该类的Class对象，再通过Class对象解析其上面的注解。
//比如要解析成员方法上的注解，则应该获取到该成员方法的Method对象，再通过Method对象解析其上面的注解。
//Class、Method、Field，Constructor、都实现了AnnotatedElement接口，它们都拥有解析注解的能力。

//AnnotatedElement接口提供了解析注解的方法
//public Annotation[] getDeclaredAnnotations()                          获取当前对象上面的注解。
//public T getDeclaredAnnotation(Class<T> annotationClass)              获取指定的注解对象
//public boolean isAnnotationPresent(Class<Annotation> annotationClass) 判断当前对象上是否存在某个注解


@MyTest(value = "苹果",price = 10,address = {"北京","上海"})
public class test {
    @MyTest(value = "香蕉",price = 20,address = {"江苏","广东"})
    public void test1(){

    }
}
