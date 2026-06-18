package com.HJh.test.oop.fanxing;

import java.util.Scanner;

public class Main{
    // 泛型方法，用于计算指定元素在数组中的出现次数
    public static <T> int countOccurrences(T[] array, T element) {
        int count = 0;
        for (T item : array) {
            if (item.equals(element)) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 读取输入的数组类型
        String type = scanner.nextLine();
        // 读取输入的数组元素
        String elementsInput = scanner.nextLine();
        String[] elements = elementsInput.split(",");
        // 读取查找的目标元素
        String targetElementInput = scanner.nextLine();
        // 根据输入的类型创建对应的数组
        Object[] array;
        if ("Integer".equals(type)) {
            array = new Integer[elements.length];
            for (int i = 0; i < elements.length; i++) {
                array[i] = Integer.parseInt(elements[i]);
            }
        } else if ("String".equals(type)) {
            array = elements;
        } else {
            System.out.println("Unsupported type");
            return;
        }
        // 将目标元素转换为对应的类型
        Object targetElement;
        if ("Integer".equals(type)) {
            targetElement = Integer.parseInt(targetElementInput);
        } else {
            targetElement = targetElementInput;
        }
        // 调用泛型方法并输出结果
        int count = countOccurrences(array, targetElement);
        System.out.println(count);
        scanner.close();
    }
}