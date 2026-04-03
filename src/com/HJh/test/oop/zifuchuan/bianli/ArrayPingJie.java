package com.HJh.test.oop.zifuchuan.bianli;

public class ArrayPingJie {
    private ArrayPingJie() {
    }
    public static String arrayToString(int[] arr) {
        String string = "[";
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                string += arr[i] + "]";
            } else {
                string += arr[i] + ",";
            }
        }
        return string;
    }
}
