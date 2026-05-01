package com.HJh.test.oop.fanxing.fanxingfangfa;
//假设要写一个方法，能打印任意类型数组的内容（Integer[]、String[]、Double[] 等）,
//每新增一种类型，就要重写一个方法

//修饰符 <类型变量，……> 返回值类型\也可以是泛型 方法名(形参列表){}
public class test {
    public static void main(String[] args) {
        Integer[] intArr = {1, 2, 3};
        String[] strArr = {"Hello", "World"};
        Double[] doubleArr = {1.1, 2.2, 3.3};

        // 调用时编译器自动推断 T 是什么类型
        printArray(intArr);      // 输出: 1 2 3
        printArray(strArr);      // 输出: Hello World
        printArray(doubleArr);   // 输出: 1.1 2.2 3.3
        System.out.println("----------------------------------------------");

        String first = getFirst(new String[]{"a", "b"});  // 返回 "a"
        Integer num = getFirst(new Integer[]{10, 20});    // 返回 10
        System.out.println(first);
        System.out.println(num);
    }
    public static <T> void printArray(T[] arr) {
        for (T item : arr) {  // item 的类型就是 T
            System.out.print(item + " ");
        }
        System.out.println();
    }


    // 返回数组的第一个元素，返回值类型和传入的数组一致
    public static <T> T getFirst(T[] arr) {
        return arr.length > 0 ? arr[0] : null;
    }

}


