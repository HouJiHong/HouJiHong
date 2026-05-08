package com.HJh.test.oop.streamyongfa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//中间方法指的是调用完成后会返回新的stream流，可以继续使用（支持链式编程）。
//Stream提供的常用中间方法
//Stream<T> filter(Predicate<? super T>predicate)       用于对流中的数据进行过滤。
//Stream<I> sorted()                                    对元素进行升序排序
//Stream<T> sorted(Comparator<? super T> comparator)    按照指定规则排序
//Stream<T> limit(long maxSize)                         获取前几个元素
//Stream<T> skip(long n)                                跳过前几个元素
//Stream<T> distinct()                                  去除流中重复的元素。
//<R>Stream<R> map(Function<? super L,? extends R> mapper)对元素进行加工，并返回对应的新流
//static <T> Stream<T> concat(Stream a, Stream b)        合并a和b两个流为一个流
public class zhongJianFangFa {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张三丰");
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        List<Double> score =new ArrayList<>();
        score.add(90.5);
        score.add(60.5);
        score.add(80.5);
        score.add(70.5);
        int[] abc = new int[]{1,2,3,4,5};

        score.stream().sorted().forEach(System.out::println);//升序排序
        System.out.println("=========================================");
        score.stream().sorted((a,b)->Double.compare(b,a)).forEach(System.out::println);//降序排序
        System.out.println("=========================================");
        score.stream().sorted((a,b)->Double.compare(b,a)).limit(2).forEach(System.out::println);//获取前几个元素
        System.out.println("=========================================");
        score.stream().sorted((a,b)->Double.compare(b,a)).skip(2).forEach(System.out::println);//跳过前几个元素
        System.out.println("=========================================");
        //如果自定义对象要去重，需要重写equals和hashCode方法
        score.stream().distinct().forEach(System.out::println);//去重
        System.out.println("=========================================");
        //映射/加工方法：把流上原来的数据拿出来变成新数据又放到流上去。
        score.stream().map(s->"加10分"+(s+10)).forEach(System.out::println);//加10分
        System.out.println("=========================================");
        //合并
//        Stream.of(String[]) → 展开数组 → 5 个元素
//        Stream.of(abc) → 因为 int[] 是基本类型数组，不是引用类型
//        Java 无法将 int[] 自动展开为可变参数
//        所以整个 int[] 数组被当作一个对象放入流中
//        结果只有 1 个元素
        Stream<Object> s1 = Stream.concat(list.stream(),Stream.of(abc));
        System.out.println(s1.count());

        System.out.println("=========================================");

//        Arrays.stream(int[]) 返回的是 IntStream 类型（专门处理基本类型 int 的流）
//        而不是 Stream<Integer>（处理包装类型的流）
//        IntStream 和 Stream<Integer> 是不同的类型，不能直接赋值
//        方案1：使用 IntStream 接收 (把Stream<Integer>改成IntStream)
//        方案2：将 IntStream 转换为 Stream<Integer> (在后面加上.boxed())
//        方案3：先将 int[] 改为 Integer[] (把数组类型改掉)
        Stream<Integer> stream = Arrays.stream(abc).boxed();
        Stream<Object> s2 = Stream.concat(list.stream(),stream);
        System.out.println(s2.count());

        System.out.println("=========================================");
        System.out.println("直接填写");
        Stream<String> s3 = Stream.of("张三丰", "张无忌", "周芷若", "赵敏", "张强");
        Stream<Integer> s4 = Stream.of(1, 2, 3, 4, 5);
        Stream<Object> s5 = Stream.concat(s3, s4);
        System.out.println(s5.count());


    }
}
