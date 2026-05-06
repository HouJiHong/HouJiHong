package com.HJh.test.oop.jihe.mapjiazu;
//Map集合也被叫做“键值对集合”，格式：{key=value1，key2=value2，key3=value3，...} (接口)
//Map集合的所有键是不允许重复的，但值可以重复，键和值是一一对应的，每一个键只能找到自己对应的值

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//注意：Map系列集合的特点都是由键决定的，值只是一个附属品，值是不做要求的，可以重复（本质上set系列集合，都用的是map）
//HashMap（由键决定特点）：无序、不重复、无索引 （实现类）
//LinkedHashMap（由键决定特点）：由键决定的特点：有序、不重复、无索引。（实现类）
//TreeMap（由键决定特点）:按照大小默认升序排序、不重复、无索引。（实现类）


//Map集合的常用方法
//public V put(K key,V value)                   添加元素
//public int size()                             获取集合的大小
//public void clear()                           清空集合
//public boolean isEmpty()                      判断集合是否为空，为空返回true，反之
//public V get(Object key)                      根据键获取对应值
//public V remove(Object key)                   根据键删除整个元素
//public boolean containsKey(Object key)        判断是否包含某个键
//public boolean containsValue(Object value)    判断是否包含某个值
//public Set<K> keySet()                        获取全部键的集合
//public Collection<V> values()                 获取Map集合的全部值

public class MapTest {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("张三",18);
        map.put("李四",19);
        map.put("王五",20);
        map.put("王五",22);
        map.put("赵六",18);
        map.put(null,null);
        System.out.println(map);

        //获取全部键的集合(键放在set集合是因为键是唯一的不重复)
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key+"---"+map.get(key));
        }
        //获取全部值的集合(值放在Collection集合是因为值是可以重复的)
        Collection<Integer> values = map.values();
        for (Integer value : values) {
            System.out.println(value);
        }

    }

}
