package com.HJh.test.oop.fanxing.lianxi;

public class GenericDemo {
    public static void main(String[] args) {
        // 测试泛型接口
        Repository<String> repo = new StringRepository();
        repo.save("Hello Generic");
        System.out.println(repo.findById(1L));

        System.out.println("---");

        // 测试泛型方法
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"A", "B", "C"};

        // 调用泛型方法时，通常不需要显式指定类型，编译器会自动推断
        Utils.printArray(intArray);
        Utils.printArray(strArray);

        System.out.println("First Integer: " + Utils.getFirst(intArray));
        System.out.println("First String: " + Utils.getFirst(strArray));
    }
}
