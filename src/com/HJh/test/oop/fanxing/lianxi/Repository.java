package com.HJh.test.oop.fanxing.lianxi;

// 1. 定义一个泛型接口，T 是类型参数
public interface Repository<T> {
    // 根据 id 获取数据
    T findById(Long id);
    
    // 保存数据
    void save(T entity);
}

// 2. 实现泛型接口，指定具体的类型参数为 String
class StringRepository implements Repository<String> {
    @Override
    public String findById(Long id) {
        return "String-Entity-" + id;
    }

    @Override
    public void save(String entity) {
        System.out.println("保存字符串: " + entity);
    }
}

// 3. 包含泛型方法的类
class Utils {
    // 这是一个泛型方法，<E> 声明了该方法自己的类型参数 E
    // 泛型方法的类型参数通常放在返回值之前
    public static <E> void printArray(E[] array) {
        for (E element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // 泛型方法也可以有返回值
    public static <T> T getFirst(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        return array[0];
    }
}

