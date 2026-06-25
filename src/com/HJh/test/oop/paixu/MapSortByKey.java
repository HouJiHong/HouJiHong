package com.HJh.test.oop.paixu;

import java.util.*;

public class MapSortByKey {
    
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("banana", 3);
        map.put("apple", 5);
        map.put("cherry", 2);
        map.put("date", 4);
        
        System.out.println("原 HashMap: " + map);
        // 输出无序: {banana=3, apple=5, cherry=2, date=4}
        
        // 1. 自然升序（Key 必须实现 Comparable）
        Map<String, Integer> treeMap = new TreeMap<>(map);
        System.out.println("TreeMap 升序: " + treeMap);
        // 输出: {apple=5, banana=3, cherry=2, date=4}
        
        // 2. Key 降序
        Map<String, Integer> descMap = new TreeMap<>(Collections.reverseOrder());
        descMap.putAll(map);
        System.out.println("Key 降序: " + descMap);
        // 输出: {date=4, cherry=2, banana=3, apple=5}
        
        // 3. 忽略大小写排序
        Map<String, Integer> caseMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        caseMap.put("Banana", 3);
        caseMap.put("apple", 5);
        caseMap.put("Cherry", 2);
        System.out.println("忽略大小写: " + caseMap);
        // 输出: {apple=5, Banana=3, Cherry=2}
        
        // 4. 自定义 Key 排序：按长度
        Map<String, Integer> lenMap = new TreeMap<>(
            Comparator.comparingInt(String::length)
        );
        lenMap.putAll(map);
        System.out.println("按 Key 长度: " + lenMap);
        // 输出: {apple=5, banana=3, cherry=2, date=4} （长度相同按字典序）
    }
}