package com.HJh.test.oop.enumyongfa.lianxi;

public enum Season {
    // 1. 枚举常量（本质上是该类的单例对象）
    SPRING("春天", 1),
    SUMMER("夏天", 2),
    AUTUMN("秋天", 3),
    WINTER("冬天", 4);

    // 2. 成员变量
    private final String name;
    private final int code;

    // 3. 构造方法（枚举的构造方法默认且只能是 private）
    Season(String name, int code) {
        this.name = name;
        this.code = code;
    }

    // 4. Getter 方法
    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    // 5. 自定义方法：根据 code 获取枚举
    public static Season getByCode(int code) {
        for (Season season : values()) {
            if (season.getCode() == code) {
                return season;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }
}