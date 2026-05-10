package com.HJh.test.oop.streamyongfa;
//终结方法指的是调用完成后，不会返回新stream了，没法继续使用流了。
//Stream提供的常用终结方法
//void forEach(Consumer action)                     对此流运算后的元素执行遍历
//long count()                                      统计此流运算后的元素个数
//Optional<T> max(Comparator<? super T> comparator) 获取此流运算后的最大值元素
//Optional<T> min(Comparator<? super T> comparator) 获取此流运算后的最小值元素

//收集stream流：就是把Stream流操作后的结果转回到集合或者数组中去返回。（一个流只能收集一次）
//Stream流：方便操作集合/数组的手段，集合/数组：才是开发中的目的。
//Stream提供的常用终结方法
//R collect(Collector collector)                    把流处理后的结果收集到一个指定的集合中去
//Object[] toArray()                                把流处理后的结果收集到一个数组中去

//Collectors工具类提供了具体的收集方式
//public static <T> Collector toList()              把元素收集到List集合中
//public static <T> Collector toSet()               把元素收集到set集合中
//public static Collector toMap(Function keyMapper, Function valueMapper)   把元素收集到Map集合中


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class zhongJieFangFa {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("张三丰", 18, 90.5));
        list.add(new Person("张无忌", 19, 80.5));
        list.add(new Person("周芷若", 20, 81.5));
        list.add(new Person("赵敏", 18, 60.5));
        list.add(new Person("张强", 18, 90.5));
        list.add(new Person("张强", 18, 90.5));

        System.out.println( list);
        //终结方法
        System.out.println("=========================================");
        list.stream().sorted().forEach(System.out::println);//使用了重写的方法排序
        System.out.println("==================foreach====================");
        list.stream().filter(p -> p.getAge()>18).forEach(System.out::println);
        System.out.println("==================统计=====================");
        long count = list.stream().distinct().filter(p -> p.getScore() > 80).count();
        System.out.println(count);
        System.out.println("=================max=====================");
        Optional<Person> max = list.stream().max((p1, p2) -> Double.compare(p1.getScore(), p2.getScore()));
        Person person = max.get();
        System.out.println(person);
        System.out.println("=================min=====================");
        Optional<Person> min = list.stream().min((p1, p2) -> Double.compare(p1.getScore(), p2.getScore()));
        Person person1 = min.get();
        System.out.println(person1);
        System.out.println("=================list====================");

        //收集
        List<String> lt = new ArrayList<>();
        lt.add("张三");
        lt.add("张三");
        lt.add("李四");
        lt.add("王五");
        lt.add("赵六");
        lt.add("张三三");
        //收集到新list集合中
        List<String> zhangList = lt.stream().filter(s -> s.startsWith("张")).collect(Collectors.toList());
        System.out.println(zhangList);
        System.out.println("================set=======================");
        //收集到新set集合中 (注意不能用zhangList了，他已经收集过了，只能开新流) 自动去重
        Set<String> zhangSet = lt.stream().filter(s -> s.startsWith("张")).collect(Collectors.toSet());
        System.out.println(zhangSet);
        System.out.println("===============数组=====================");
        //收集到数组中
        Stream<String> s1 =lt.stream().filter(s -> s.startsWith("张"));
        Object[] array = s1.toArray();
        System.out.println(Arrays.toString( array));
        System.out.println("==============map======================");

        //收集到Map集合中(person对象)
        //在对象的类中重写了equals和hashCode方法，在使用.distinct()时去重（注意：重写了只有属性都相同才去重，不灵活）
        Map<String, Double> collect = list.stream().distinct().collect(Collectors.toMap(new Function<Person, String>() {
            @Override
            public String apply(Person person) {
                return person.getName();
            }
        }, new Function<Person, Double>() {
            @Override
            public Double apply(Person person) {
                return person.getScore();
            }
        }));
        System.out.println(collect);
        System.out.println("=========================================");

        //在toMap中定义规则，如果key重复，则保留原先的，只关注key的内容，更灵活
        Map<String, Double> collect2 = list.stream().collect(Collectors.
                toMap(Person::getName,Person::getScore,(existing,replacement)-> existing));
        System.out.println(collect2);


    }
}






class Person implements Comparable<Person>{
    private String name;
    private int age;
    private double score;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Double.compare(score, person.score) == 0 && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, score);
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}'+"\n";
    }


    public Person() {
    }

    public Person(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }


}
