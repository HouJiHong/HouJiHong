package com.HJh.test.oop.jihe.collectionjiazu.setyongfa;
//特点：不重复、无索引、可排序（默认升序排序，按照元素的大小，由小到大排序）
//底层是基于红黑树实现的排序。

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

//注意：
//对于数值类型：Integer，Double，默认按照数值本身的大小进行升序排序。
//对于字符串类型：默认按照首字符的编号升序排序。
//对于自定义类型如Student对象，TreeSet默认是无法直接排序的,需要自定义排序规则

//方法一：
//对象类实现一个Comparable比较接口，重写compareTo方法，指定大小比较规则
//方法二：
//public TreeSet(Comparator）集合自带比较器comparator对象，指定比较规则

public class TreeSetTest {
    public static void main(String[] args) {
        //方法二：(优先比较)
        Set< Teacher>  ts= new TreeSet<>(new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                return Double.compare(o1.getSalary(), o2.getSalary());
            }
        });



        ts.add(new Teacher("张三", 18, 5000.2));
        ts.add(new Teacher("李四", 19, 9287.3));
        ts.add(new Teacher("王五", 20, 3242.4));
        //根据实现的compareTo方法进行指定内容的排序（当前是salary，出现相同的salary会去重）
        //如果要保留相同的数据，将compareTo方法的return 0改成1或-1
        ts.add(new Teacher("小丑", 18, 5000.3));
        System.out.println(ts);


    }
}

class Teacher implements Comparable<Teacher>{
    private String name;
    private int age;
    private double salary;

    //方法一：
    //按照要比较的属性进行排序
    //o1为当前对象，o2为传入的参数对象
    //如果返回1，则o1排在o2前面；如果返回-1，则o1排在o2后面；如果返回0，则o1和o2相等
    @Override
    public int compareTo(Teacher o) {
//        if(this.age > o.age){
//            return 1;
//        }else if(this.age < o.age){
//            return -1;
//        }
//        return 0;
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}'+"\n";
    }

    public Teacher() {
    }

    public Teacher(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
