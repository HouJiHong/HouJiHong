package com.HJh.test.oop.diceng;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MyObject {
    boolean marked = false; // 标记位
    List<MyObject> references = new ArrayList<>(); // 模拟对象间的引用关系
    void addReference(MyObject ref) { references.add(ref); }
}

public class MarkAndSweepGC {
    List<MyObject> heap = new ArrayList<>(); // 模拟堆内存
    List<MyObject> rootSet = new ArrayList<>(); // 模拟 GC Roots

    public static void main(String[] args) {
        new MarkAndSweepGC().simulateGC();
    }

    void simulateGC() {
        MyObject obj1 = new MyObject();
        MyObject obj2 = new MyObject();
        rootSet.add(obj1); // obj1 作为根对象
        obj1.addReference(obj2); // obj1 引用 obj2
        heap.add(obj1);
        heap.add(obj2);
        heap.add(new MyObject()); // 添加一个未引用的对象，模拟垃圾

        mark(); // 标记阶段
        sweep(); // 清除阶段
        System.out.println("GC完成，当前存活对象数量：" + heap.size());
    }

    // 从根集合开始递归标记
    void mark() { rootSet.forEach(this::markFrom); }
    void markFrom(MyObject obj) {
        if (!obj.marked) {
            obj.marked = true;
            obj.references.forEach(this::markFrom);
        }
    }

    // 清除未标记的对象
    void sweep() {
        Iterator<MyObject> iterator = heap.iterator();
        while (iterator.hasNext()) {
            MyObject obj = iterator.next();
            if (!obj.marked) iterator.remove(); // 回收垃圾
            else obj.marked = false; // 重置标记位
        }
    }
}

class ZGCTest {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        // 模拟短时间内创建大量短生命周期对象
        for (int i = 0; i < 1000000; i++) {
            new Object();
        }
        System.gc(); // 显式触发垃圾回收
        long endTime = System.currentTimeMillis();
        System.out.println("执行时间: " + (endTime - startTime) + "ms");
    }
}

