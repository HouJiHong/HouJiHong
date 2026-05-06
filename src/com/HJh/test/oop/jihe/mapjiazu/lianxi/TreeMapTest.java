package com.HJh.test.oop.jihe.mapjiazu.lianxi;



import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {

        Map<Teacher,Integer> map = new TreeMap<>((o1, o2)->Double.compare(o1.getSalary(), o2.getSalary()));
        map.put(new Teacher("张三", 18, 5000.2), 12);
        map.put(new Teacher("李四", 19, 9287.3), 13);
        map.put(new Teacher("王五", 20, 3242.4), 14);
        map.put(new Teacher("小丑", 18, 5000.3), 15);
        System.out.println(map);

    }

}
class Teacher implements Comparable<Teacher>{
    private String name;
    private int age;
    private double salary;

    @Override
    public int compareTo(Teacher o) {
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

