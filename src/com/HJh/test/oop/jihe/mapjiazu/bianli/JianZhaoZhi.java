package com.HJh.test.oop.jihe.mapjiazu.bianli;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JianZhaoZhi {
    public static void main(String[] args) {
        Map<String,Double>map = new HashMap<>();
        map.put("蜘蛛精",168.5);
        map.put("紫霞",169.5);
        map.put("至尊宝",170.5);
        map.put("牛魔王",180.5);
        System.out.println( map);

        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key+"---"+map.get(key));
        }
    }
}
