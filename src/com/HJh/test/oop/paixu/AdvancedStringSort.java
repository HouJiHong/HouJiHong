package com.HJh.test.oop.paixu;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdvancedStringSort {
    
    public static void main(String[] args) {
        String[] files = {
            "file10.txt", "file1.txt", "file2.txt", 
            "img10.png", "img1.png", "img2.png"
        };
        
        // 自然排序（字典序，10 排在 2 前面，不符合直觉）
        String[] natural = files.clone();
        Arrays.sort(natural);
        System.out.println("字典序: " + Arrays.toString(natural));
        // [file1.txt, file10.txt, file2.txt, img1.png, img10.png, img2.png]
        
        // 自然顺序排序（Numeric String Sort，10 排在 2 后面）
        String[] naturalOrder = files.clone();
        Arrays.sort(naturalOrder, new NaturalOrderComparator());
        System.out.println("自然顺序: " + Arrays.toString(naturalOrder));
        // [file1.txt, file2.txt, file10.txt, img1.png, img2.png, img10.png]
    }
    
    // 自然顺序比较器（处理数字部分按数值比较）
    static class NaturalOrderComparator implements Comparator<String> {
        private final Pattern numberPattern = Pattern.compile("\\d+");
        
        @Override
        public int compare(String s1, String s2) {
            int len1 = s1.length(), len2 = s2.length();
            int i = 0, j = 0;
            
            while (i < len1 && j < len2) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);
                
                if (Character.isDigit(c1) && Character.isDigit(c2)) {
                    // 提取完整数字
                    int num1 = 0, num2 = 0;
                    while (i < len1 && Character.isDigit(s1.charAt(i))) {
                        num1 = num1 * 10 + (s1.charAt(i) - '0');
                        i++;
                    }
                    while (j < len2 && Character.isDigit(s2.charAt(j))) {
                        num2 = num2 * 10 + (s2.charAt(j) - '0');
                        j++;
                    }
                    if (num1 != num2) return Integer.compare(num1, num2);
                } else {
                    if (c1 != c2) return c1 - c2;
                    i++;
                    j++;
                }
            }
            return len1 - len2;
        }
    }
}