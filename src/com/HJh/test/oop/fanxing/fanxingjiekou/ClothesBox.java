package com.HJh.test.oop.fanxing.fanxingjiekou;

import java.util.ArrayList;

// 📦 实现2：装衣服的仓库
public class ClothesBox implements Container<Clothes> {

    private ArrayList<Clothes> clothesList = new ArrayList<>();

    @Override
    public void put(Clothes clothes) {
        clothesList.add(clothes);
        System.out.println("放入衣服: " + clothes.getName());
    }

    @Override
    public Clothes take() {
        if (clothesList.isEmpty()) return null;
        return clothesList.remove(0);
    }

    @Override
    public int size() {
        return clothesList.size();
    }
}

