package com.HJh.test.oop.reflection;
//反射：加载类，并允许以编程的方式解剖类中的各种成分（成员变量、方法、构造器等）。
//1、反射第一步：加载类，获取类的字节码：Class对象
//2、获取类的构造器：Constructor对象
//3、获取类的成员变量：Field对象
//4、获取类的成员方法：Method对象

//获取Class对象的三种方式
//Class c1 =类名.class
//调用Class提供方法：public static Class forName(String package);
//Object提供的方法：public Class getClass(); Class c3 =对象.getClass();

//Class提供了从类中获取构造器的方法。
//方法
//Constructor<?>[] getConstructors()            获取全部构造器（只能获取public修饰的）
//Constructor<?>[] getDeclaredConstructors()    获取全部构造器（只要存在就能拿到）
//Constructor<T> getConstructor(class<?>...parameterTypes)          获取某个构造器（只能获取public修饰的）
//Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes) 获取某个构造器（只要存在就能拿到）
//获取类构造器的作用：依然是初始化对象返回
//Constructor提供的方法
//T newInstance(object... initargs)         调用此构造器对象表示的构造器，并传入参数，完成对象的初始化并返回
//public void setAccessible(boolean flag)   设置为true，表示禁止检查访问控制（暴力反射）

//Class提供了从类中获取成员变量的方法。
//方法
//public Field[] getFields()                    获取类的全部成员变量（只能获取public修饰的）
//public Field[] getDeclaredFields()            获取类的全部成员变量（只要存在就能拿到）
//public Field getField(String name)            获取类的某个成员变量（只能获取public修饰的）
//public Field getDeclaredField(String name)    获取类的某个成员变量（只要存在就能拿到）
//获取到成员变量的作用：依然是赋值、取值。
//方法
//void set(object obj,Object value):    赋值
//Object get(object obj)                取值
//public void setAccessible(boolean flag)   设置为true，表示禁止检查访问控制（暴力反射）

//Class提供了从类中获取成员方法的API。
//方法
//Method[] getMethods()                 获取类的全部成员方法（只能获取public修饰的)
//Method[] getDeclaredMethods()         获取类的全部成员方法（只要存在就能拿到）
//Method getMethod(String name, Class<?>...parameterTypes)          获取类的某个成员方法（只能获取public修饰的)
//Method getDeclaredMethod(String name,Class<?>...parameterTypes)   获取类的某个成员方法（只要存在就能拿到）
//成员方法的作用：依然是执行
//Method提供的方法
//public Object invoke(object obj,Object... args)   触发某个对象的该方法执行。
//public void setAccessible(boolean flag)           设置为true，表示禁止检查访问控制（暴力反射）

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class test {
    public static void main(String[] args) throws Exception {
        System.out.println("================获取class对象==============");
        //1.获取Class对象
        Class c1 = Student.class;
        System.out.println(c1);
        System.out.println(c1.getName());
        System.out.println(c1.getSimpleName());
        //2.获取Class对象
        Class c2 = Class.forName("com.HJh.test.oop.reflection.Student");
        System.out.println(c2);
        System.out.println(c1 == c2);
        //3.获取Class对象
        Student s = new Student();
        Class c3 = s.getClass();
        System.out.println(c3);
        System.out.println(c1 == c3);

        System.out.println("================获取构造器==============");//匹配形参类型
        //获取所有构造器
        Constructor[] c4 = c1.getConstructors();
        Constructor[] c5 = c1.getDeclaredConstructors();
        for (Constructor c : c4) {
            System.out.println(c.getName()+"("+c.getParameterCount()+")");
        }
        //获取指定构造器
        Constructor c6 = c1.getConstructor();//获取无参构造器
        Constructor c7 = c1.getDeclaredConstructor(String.class);
        Constructor c8 = c1.getConstructor(String.class, int.class);
        System.out.println(c8.getName()+"("+c8.getParameterCount()+")");

        //获取构造器的作用依然是创建对象
        Student s1 =(Student) c6.newInstance();//创建无参对象
        //由于构造器是private的，所以无法创建对象
        //需要暴力反射：可以访问私有的构造器，方法，属性
        c7.setAccessible(true);
        Student s2 =(Student) c7.newInstance("HJh2");
        System.out.println(s2);

        System.out.println("================获取成员变量==============");//匹配成员变量名字
        //获取所有成员变量
        Field[] f1 = c1.getDeclaredFields();
        for (Field f:f1) {
            System.out.println(f.getName()+"("+f.getType().getName()+")");
        }
        //获取指定的成员变量
        Field f2 = c1.getDeclaredField("name");
        System.out.println(f2.getName()+"("+f2.getType().getName()+")");

        //获取成员变量的目的依然是取值赋值
        Student s3 = new Student();
        f2.setAccessible(true);
        f2.set(s3,"HJh2");
        System.out.println(s3);
        System.out.println(f2.get(s3));


        System.out.println("================获取成员方法==============");//匹配方法名字和参数类型
        //获取所有成员方法
        Method[] m1 = c1.getDeclaredMethods();
        for (Method m:m1) {
            System.out.println(m.getName()+"("+m.getParameterCount()+")");
        }
        //获取指定成员方法
        Method setName = c1.getDeclaredMethod("setName", String.class);
        System.out.println(setName.getName()+"("+setName.getParameterCount()+")");

        //获取成员方法的目的：调用成员方法
        Object hJh3 = setName.invoke(s1, "HJh3");
        System.out.println(hJh3);//如果方法有返回值，则返回值封装在hJh3中


    }
}
