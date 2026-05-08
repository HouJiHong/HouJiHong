package com.HJh.test.oop.streamyongfa;
//是Jdk8开始新增的一套APl(java.util.stream.*)，可以用于操作集合或者数组的数据。
//优势：Stream流大量的结合了Lambda的语法风格来编程，功能强大，性能高效，代码简洁，可读性好。


//1.获取stream源（集合或者数组等）
//2.调用方法操作（中间方法）
//3.获取结果(遍历，统计，收集)

//获取集合的Stream流
  //Collection提供的如下方法
  //default Stream<E> stream()        获取当前集合对象的stream流

//获取数组的stream流
  //Arrays类提供的如下方法(通过Arrays（类名）调用)
  //public static <T> Stream<T> stream(T[]array)  获取当前数组的stream流

  //Stream类提供的如下方法(通过Stream（类名）调用)
  //public static<T> Stream<T> of(T... values)    获取当前接收数据的stream流
                                    //T... values为可变参数 (如果接受基本数据类型的数组，会处理整个数组。或者直接填写多个数据)

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class streamTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张三丰");
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");

        //传统方法
        List<String> newList = new ArrayList<>();
        for (String name : list) {
            if(name.startsWith("张")&&name.length()==3){
                newList.add(name);
            }
        }
        System.out.println(newList);
        System.out.println("=========================================");

        //Stream流方法
        List<String> newList2 = list.stream().filter(name -> name.startsWith("张")).filter(name -> name.length() == 3).collect(Collectors.toList());
        System.out.println(newList2);
        System.out.println("=========================================");


        //获取集合的stream流
         //获取collection的stream流
        Collection< String> clist = new ArrayList<>();
        Stream<String> stream = clist.stream();
         //获取map的stream流
        Map<String,Double> map = new HashMap<>();
        Set<String> keys = map.keySet();
        Stream<String> stream2 = map.keySet().stream();
        Stream<Map.Entry<String,Double>> stream1 = map.entrySet().stream();

        //获取数组的stream流
        String[] array = new String[]{"张三丰","张无忌","周芷若","赵敏","张强"};
        Stream<String> stream3 = Arrays.stream(array);
        Stream<String> stream4 = Stream.of(array);
        Stream<String> stream5 = Stream.of("张三丰","张无忌","周芷若","赵敏","张强");

        System.out.println(stream3.count());
        System.out.println(stream4.count());
        System.out.println(stream5.count());



    }
}
