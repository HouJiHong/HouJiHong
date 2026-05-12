package com.HJh.test.oop.jihe.doudizhu;

import java.util.*;

public class Room {
    //准备54张牌
    List<Cards> allCards = new ArrayList<>();
    //初始化牌
    {
        String[] colors = {"♠","♥","♣","♦"};
        String[] numbers = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        int num = 0;//牌值
        for (String number : numbers) {
            num++;
            for (String color : colors) {
                Cards cards = new Cards(number, color, num);
                allCards.add(cards);
            }
        }
        Collections.addAll(allCards, new Cards("🃏", "小王", ++num), new Cards("🤡", "大王", ++num));
        System.out.println("初始化牌完成"+allCards);
    }
    public void start() {
        //洗牌
        Collections.shuffle(allCards);
        System.out.println("洗牌完成"+allCards);
        System.out.println("开始斗地主");
        //发牌，定义三个玩家 张三= 李四= 王五=
        Map<String, List<Cards>> players = new HashMap<>();
        List<Cards> zhangsan = new ArrayList<>();
        players.put("张三", zhangsan);
        List<Cards> lisi = new ArrayList<>();
        players.put("李四", lisi);
        List<Cards> wangwu = new ArrayList<>();
        players.put("王五", wangwu);
        //发出51张牌
        for (int i = 0; i < allCards.size()-3; i++) {
            Cards cards = allCards.get(i);
            if (i % 3 == 0) {
                zhangsan.add(cards);
            } else if (i % 3 == 1) {
                lisi.add(cards);
            }else {
                wangwu.add(cards);
            }
        }
        //拿3张底牌
        List<Cards> dipai = allCards.subList(allCards.size()-3, allCards.size());

        //抢地主（随机一个人拿三张底牌）
        Random r = new Random();
        int index = r.nextInt(3);
        switch (index) {
            case 0:
                zhangsan.addAll(dipai);
                break;
            case 1:
                lisi.addAll(dipai);
                break;
            case 2:
                wangwu.addAll(dipai);
                break;
        }
        //把每个人的牌排序
        sortedCards(zhangsan);
        sortedCards(lisi);
        sortedCards(wangwu);

        //看牌
        for (Map.Entry<String, List<Cards>> entry : players.entrySet()) {
            System.out.println(entry.getKey()+"的牌是："+entry.getValue());
        }


    }

    private void sortedCards(List<Cards>  cards) {
        Collections.sort(cards, new Comparator<Cards>() {
            @Override
            public int compare(Cards o1, Cards o2) {
                return o2.getValue()-o1.getValue();
            }
        });
    }
}
