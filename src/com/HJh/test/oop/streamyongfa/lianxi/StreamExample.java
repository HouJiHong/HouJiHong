package com.HJh.test.oop.streamyongfa.lianxi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        // 1. 准备数据
        List<User> users = Arrays.asList(
                new User("Alice", 20),
                new User("Bob", 17),
                new User("Charlie", 22),
                new User("David", 16)
        );

        // 2. Stream 流处理
        List<String> result = users.stream()           // 1. 获取流
                .filter(u -> u.getAge() > 18)          // 2. 过滤：年龄 > 18
                .map(u -> u.getName().toUpperCase())   // 3. 转换：提取名字并转大写
                .sorted()                              // 4. 排序：按字母自然排序
                .collect(Collectors.toList());         // 5. 收集：转为 List

        // 3. 输出结果: [ALICE, CHARLIE]
        System.out.println(result); 
    }
}

// 辅助类
class User {
    private String name;
    private int age;
    // 构造器、Getter 省略...
    public User(String name, int age) { this.name = name; this.age = age; }
    public String getName() { return name; }
    public int getAge() { return age; }
}