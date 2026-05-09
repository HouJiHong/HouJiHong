package com.HJh.test.oop.streamyongfa;
//终结方法指的是调用完成后，不会返回新stream了，没法继续使用流了。
//Stream提供的常用终结方法
//void forEach(Consumer action)                     对此流运算后的元素执行遍历
//long count()                                      统计此流运算后的元素个数
//Optional<T> max(Comparator<? super T> comparator) 获取此流运算后的最大值元素
//Optional<T> min(Comparator<? super T> comparator) 获取此流运算后的最小值元素


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class zhongJieFangFa {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("张三丰", 18, 90.5));
        list.add(new Person("张无忌", 19, 80.5));
        list.add(new Person("周芷若", 20, 81.5));
        list.add(new Person("赵敏", 18, 60.5));
        list.add(new Person("张强", 18, 90.5));

        System.out.println( list);

        System.out.println("=========================================");
        list.stream().sorted().forEach(System.out::println);
        System.out.println("=========================================");
        list.stream().filter(p -> p.getAge()>18).forEach(System.out::println);
        System.out.println("=========================================");
        long count = list.stream().filter(p -> p.getScore() > 80).count();
        System.out.println(count);
        System.out.println("=========================================");
        Optional<Person> max = list.stream().max((p1, p2) -> Double.compare(p1.getScore(), p2.getScore()));
        Person person = max.get();
        System.out.println(person);
        System.out.println("=========================================");
        Optional<Person> min = list.stream().min((p1, p2) -> Double.compare(p1.getScore(), p2.getScore()));
        Person person1 = min.get();
        System.out.println(person1);
    }
}
class Person implements Comparable<Person>{
    private String name;
    private int age;
    private double score;


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
