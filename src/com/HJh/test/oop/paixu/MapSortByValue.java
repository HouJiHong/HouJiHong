package com.HJh.test.oop.paixu;

import java.util.*;
import java.util.stream.Collectors;

public class MapSortByValue {
    
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("张三", 85);
        map.put("李四", 92);
        map.put("王五", 78);
        map.put("赵六", 92);
        
        // 1. 按 Value 升序
        Map<String, Integer> asc = map.entrySet().stream()
            .sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1,  // 处理 Key 冲突
                LinkedHashMap::new  // 保持顺序
            ));
        System.out.println("Value 升序: " + asc);
        // 输出: {王五=78, 张三=85, 李四=92, 赵六=92}
        
        // 2. 按 Value 降序
        Map<String, Integer> desc = map.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1,
                LinkedHashMap::new
            ));
        System.out.println("Value 降序: " + desc);
        // 输出: {李四=92, 赵六=92, 张三=85, 王五=78}
        
        // 3. 按 Value 降序，Value 相同再按 Key 升序
        Map<String, Integer> complex = map.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                .thenComparing(Map.Entry.comparingByKey()))
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1,
                LinkedHashMap::new
            ));
        System.out.println("复杂排序: " + complex);
        // 输出: {李四=92, 赵六=92, 张三=85, 王五=78}
    }
}