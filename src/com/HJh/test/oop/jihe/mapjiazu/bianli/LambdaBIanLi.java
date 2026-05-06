package com.HJh.test.oop.jihe.mapjiazu.bianli;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class LambdaBIanLi {
    public static void main(String[] args) {
        Map<String,Double> map = new HashMap<>();
        map.put("蜘蛛精",168.5);
        map.put("紫霞",169.5);
        map.put("至尊宝",170.5);
        map.put("牛魔王",180.5);
        System.out.println( map);

        //foreach只实现了迭代功能
        //发现foreach用到的是一个BiConsumer的函数式接口，里面有一个accept抽象方法，所以我创建一个匿名内部类对象给foreach，
        //并重写BiConsumer接口的accept方法。调用foreach时会调用我给的匿名内部类对象，并且还要回来调用我的accept方法

        map.forEach(new BiConsumer<String, Double>() {
            @Override
            public void accept(String key, Double value) {
                System.out.println(key+"---"+value);
            }
        });
        //简化
        map.forEach((key,value)->{
            System.out.println(key+"==="+value);
        });
    }
}
