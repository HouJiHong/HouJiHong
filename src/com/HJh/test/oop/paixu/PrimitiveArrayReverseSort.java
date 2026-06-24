package com.HJh.test.oop.paixu;

import java.util.Arrays;

public class PrimitiveArrayReverseSort {
    
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 9, 3};
        
        // 先升序排序
        Arrays.sort(arr);
        System.out.println("升序后: " + Arrays.toString(arr));
        // 输出: [1, 2, 3, 5, 8, 9]
        
        // 再手动反转
        reverse(arr);
        System.out.println("逆序后: " + Arrays.toString(arr));
        // 输出: [9, 8, 5, 3, 2, 1]
    }
    
    // 手动反转数组
    public static void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}