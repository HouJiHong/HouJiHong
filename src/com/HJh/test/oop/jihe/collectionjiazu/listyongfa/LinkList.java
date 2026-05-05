package com.HJh.test.oop.jihe.collectionjiazu.listyongfa;

import java.util.LinkedList;

public class LinkList {
    public static void main(String[] args) {
        //用linkedList实现一个队列
        LinkedList<String> queue = new LinkedList<>();
        queue.addLast("第一个人");
        queue.addLast("第二个人");
        queue.addLast("第三个人");
        System.out.println(queue);
        System.out.println(queue.removeFirst());
        System.out.println(queue.removeFirst());
        System.out.println(queue);

        //用linkedList实现一个栈
        LinkedList<String> stack = new LinkedList<>();
        stack.addLast("第一颗子弹");
        stack.push("第二颗子弹");
        stack.push("第三颗子弹");
        System.out.println(stack);
        System.out.println(stack.removeFirst());
        System.out.println(stack.pop());
        System.out.println(stack);

    }
}
