package com.HJh.test.oop.jihe.mapjiazu.bianli;
//把键值对看成一个整体，此时用增强for循环时，发现类型不知道怎么填。
// 所以用map.entrySet()方法，将map键值对转换成Set集合,类型是Map.Entry<K,V>


//Set< Map.Entry<K,V> > entrySet()   获取所有“键值对”的集合


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JianZhidui {
    public static void main(String[] args) {
        Map<String,Double> map = new HashMap<>();
        map.put("蜘蛛精",168.5);
        map.put("紫霞",169.5);
        map.put("至尊宝",170.5);
        map.put("牛魔王",180.5);
        System.out.println( map);
        //{蜘蛛精=168.5, 牛魔王=180.5, 至尊宝=170.5, 紫霞=169.5}
        //{(蜘蛛精=168.5), (牛魔王=180.5), (至尊宝=170.5), (紫霞=169.5)}

        Set< Map.Entry<String,Double> > entrySet = map.entrySet();
        for (Map.Entry<String,Double> entry : entrySet) {
            System.out.println(entry.getKey()+"---"+entry.getValue());
        }
    }
}
