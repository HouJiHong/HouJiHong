package com.HJh.test.oop.jihe.bianliqubie;

//遍历集合的同时又存在增删集合元素的行为时可能出现业务异常，这种现象被称之为并发修改异常问题。

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

public class test {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("JAVA");
        list.add("宁夏枸杞");
        list.add("黑枸杞");
        list.add("特级枸杞");
        list.add("杯子");
        list.add("枸杞子");

        //方法一：
        //遍历集合的同时又存在增删集合元素行为,
        //会出现并发修改异常问题,不能删除完整。
        /*for (int i = 0; i < list.size(); i++) {
            String name = list.get(i);
            if(name.contains("枸杞")){
                list.remove(name);
            }
        }
        System.out.println(list);*/

        //方法二：
        //可避免
        /*for (int i = 0; i < list.size(); i++) {
            String name = list.get(i);
            if(name.contains("枸杞")){
                list.remove(name);
                i--;
            }
        }
        System.out.println(list);*/

        //方法三：
        //从后往前，由于删除元素，索引值会变，但索引值已经是检查过的
        /*for(int i =list.size()-1;i>=0;i--){
            String name = list.get(i);
            if(name.contains("枸杞")){
                list.remove(name);
            }
        }
        System.out.println(list);*/

        //=====================================================================================
        //三种遍历的区别：
        //1)如果集合支持索引，可以使用for循环遍历，每删除数据后做i--；或者可以倒着遍历
        //2)可以使用迭代器遍历，并用迭代器提供的删除方法删除数据。
        //注意：增强for循环/Lambda遍历均不能解决并发修改异常问题，因此增它们只适合做数据的遍历，不适合同时做增删操作。

        //1.迭代器遍历
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String name = it.next();
            if(name.contains("枸杞")){
                //这里用list.remove(name)会报异常，因为迭代器遍历的时候，会判断当前的索引值是否改变，
                //如果索引值已经改变，就会报异常
                //list.remove(name);

                //要用迭代器自己的remove()方法
                it.remove();
            }
        }
        System.out.println(list);
        
        //2.增强for遍历和lambda
        //都不能解决问题
        /*for (String name : list) {
            if(name.contains("枸杞")){
                list.remove(name);
            }
        }
        System.out.println(list);*/


        /*list.forEach( s-> {
                if(s.contains("枸杞")){
                    list.remove(s);
                }
            });
        System.out.println(list);*/

        




    }
}
