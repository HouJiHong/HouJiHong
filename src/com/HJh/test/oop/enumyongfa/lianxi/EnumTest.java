package com.HJh.test.oop.enumyongfa.lianxi;

public class EnumTest {
    public static void main(String[] args) {
        // 1. 直接获取枚举实例
        Season season = Season.SPRING;
        System.out.println(season.getName()); // 输出: 春天
        System.out.println(season.getCode()); // 输出: 1

        // 2. 遍历所有枚举
        System.out.println("--- 遍历所有季节 ---");
        for (Season s : Season.values()) {
            System.out.println(s.name() + " -> " + s.getName() + " (Code: " + s.getCode() + ")");
        }

        // 3. 根据字符串获取枚举
        Season summer = Season.valueOf("SUMMER");
        System.out.println(summer.getName()); // 输出: 夏天

        // 4. 使用自定义方法
        Season winter = Season.getByCode(4);
        System.out.println(winter.getName()); // 输出: 冬天
    }
}