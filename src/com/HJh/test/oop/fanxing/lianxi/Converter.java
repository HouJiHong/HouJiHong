package com.HJh.test.oop.fanxing.lianxi;

// 1. 定义一个泛型接口
public interface Converter<T, R> {
    R convert(T source);
}

// 2. 实现该泛型接口
class StringToIntegerConverter implements Converter<String, Integer> {
    @Override
    public Integer convert(String source) {
        return Integer.parseInt(source);
    }
}

// 3. 包含泛型方法的工具类
class GenericUtils {

    // 泛型方法：将数组中的第一个元素转换为目标类型
    public static <T, R> R convertFirst(T[] array, Converter<T, R> converter) {
        if (array == null || array.length == 0) {
            return null;
        }
        return converter.convert(array[0]);
    }

    // 泛型方法：打印任意类型的数组
    public static <T> void printArray(T[] array) {
        for (T item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}

// 4. 测试
class Main {
    public static void main(String[] args) {
        // 使用泛型接口
        Converter<String, Integer> converter = new StringToIntegerConverter();
        System.out.println(converter.convert("123")); // 输出: 123

        // 使用泛型方法
        String[] strArray = {"10", "20", "30"};
        Integer result = GenericUtils.convertFirst(strArray, new StringToIntegerConverter());
        System.out.println(result); // 输出: 10

        // 泛型方法自动推断类型
        Integer[] intArray = {1, 2, 3};
        GenericUtils.printArray(intArray); // 输出: 1 2 3

        String[] names = {"Alice", "Bob"};
        GenericUtils.printArray(names); // 输出: Alice Bob
    }
}