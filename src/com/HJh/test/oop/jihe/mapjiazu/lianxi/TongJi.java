package com.HJh.test.oop.jihe.mapjiazu.lianxi;

import java.util.*;

public class TongJi {
    public static void main(String[] args) {
        tongJi();
    }
    public static void tongJi() {
        List<String>  result = new ArrayList<>();
        String[] locations = {"北京","上海","广州","深圳"};
        Random random = new Random();
        for(int i = 0; i < 80; i++){
            int index = random.nextInt(locations.length);
            result.add(locations[index]);
        }

        Map<String,Integer> map = new HashMap<>();
        for (String key : result) {
            if(map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }else{
                map.put(key,1);
            }

        }

        map.forEach((key,value)->{
            System.out.println(key+" 有 "+value+" 个人选择");
        });
    }
}
