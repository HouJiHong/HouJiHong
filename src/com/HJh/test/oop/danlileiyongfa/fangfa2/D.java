package com.HJh.test.oop.danlileiyongfa.fangfa2;

public enum D {

    INSTANCE;  // 唯一的枚举常量，即单例实例

    private String data;

    /**
     * 初始化数据（模拟懒加载后的操作）
     */
    public void initData(String data) {
        this.data = data;
        System.out.println("数据已初始化: " + data);
    }

    /**
     * 获取数据
     */
    public String getData() {
        return data;
    }

    /**
     * 获取单例实例
     */
    public static D getInstance() {
        return INSTANCE;
    }

    /**
     * 示例方法
     */
    public void showMessage() {
        System.out.println("这是枚举单例 D");
    }
}
