package com.HJh.test.oop.diceng;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CustomClassLoader extends ClassLoader {
    
    private String classPath; // 自定义类的存放路径

    public CustomClassLoader(String classPath) {
        this.classPath = classPath;
    }

    /**
     * 核心：重写 loadClass 打破双亲委派模型
     */
    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        synchronized (getClassLoadingLock(name)) {
            // 1. 首先检查该类是否已经被加载过
            Class<?> clazz = findLoadedClass(name);
            
            if (clazz == null) {
                // 2. 【打破双亲委派的关键】：优先尝试自己加载
                try {
                    clazz = findClass(name);
                } catch (ClassNotFoundException e) {
                    // 3. 如果自己加载失败，再委派给父类加载器（保证基础类如 java.lang.Object 正常加载）
                    clazz = getParent().loadClass(name);
                }
            }
            
            // 4. 解析类
            if (resolve) {
                resolveClass(clazz);
            }
            return clazz;
        }
    }

    /**
     * 从自定义路径读取字节码
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            String fileName = name.replace(".", File.separator) + ".class";
            byte[] classBytes = Files.readAllBytes(Paths.get(classPath, fileName));
            return defineClass(name, classBytes, 0, classBytes.length);
        } catch (IOException e) {
            throw new ClassNotFoundException("自定义路径下找不到类: " + name);
        }
    }
}

class ClassLoaderTest {
    public static void main(String[] args) throws Exception {
        // 1. 创建两个指向同一个路径的自定义类加载器
        CustomClassLoader loader1 = new CustomClassLoader("/tmp/my_classes");
        CustomClassLoader loader2 = new CustomClassLoader("/tmp/my_classes");

        // 2. 分别加载同一个类
        Class<?> clazz1 = loader1.loadClass("com.example.MyService");
        Class<?> clazz2 = loader2.loadClass("com.example.MyService");

        // 3. 打印类的加载器信息
        System.out.println("Class 1 的加载器: " + clazz1.getClassLoader());
        System.out.println("Class 2 的加载器: " + clazz2.getClassLoader());

        // 4. 比较两个 Class 对象是否相等
        System.out.println("两个 Class 对象是否相等: " + clazz1.equals(clazz2));
    }
}