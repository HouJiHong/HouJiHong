package com.HJh.test.oop.danlileiyongfa.fangfa2;

public enum C {

    INSTANCE;  // 唯一的枚举常量，即单例实例

    /**
     * 获取单例实例
     */
    public static C getInstance() {
        return INSTANCE;
    }

    /**
     * 示例方法
     */
    public void showMessage() {
        System.out.println("这是枚举单例 C");
    }
}
