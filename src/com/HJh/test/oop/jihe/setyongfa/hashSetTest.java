package com.HJh.test.oop.jihe.setyongfa;
//Java中的所有对象都可以调用Object类提供的hashCode方法，返回该对象自己的哈希值
//hashSet用哈希表存储数据
//jdk8前哈希表：数组+链表
//1.创建一个默认长度16的数组，默认加载因子为0.75，数组名table  （也是在添加元素的时候扩容）
//                                                        (16*0.75=12,当集合有12个元素的时候就扩容，16变32)
//2.使用元素的【哈希值】对【数组的长度】做运算计算出应存入的位置
//3.判断当前位置是否为null，如果是null直接存入
//4.如果不为null，表示有元素，则调用equals方法比较
  //相等，则不存；不相等，则存入数组
  //JDK8之前，新元素存入数组，占老元素位置，老元素挂下面（用链表连接）
  //JDK8开始之后，新元素直接挂在老元素下面


//JDK8开始的哈希表：数组+链表+红黑树(为了防止大量元素都加在一个链表上)
//当链表长度超过8，且数组长度>=64时，自动将链表转成红黑树
//红黑树是一种自平衡的二叉搜索树，它通过给节点添加颜色属性（红色或黑色）来确保树在插入和删除操作后二叉树保持大致平衡。


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class hashSetTest {
    public static void main(String[] args) {
        String s1 = "213";
        String s2 = "123";
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());


        //用hashSet去重
        Set<Student> set = new HashSet<>();

        //错误！每创建一个对象，hashCode值就变化了，所以不能去重
        /*set.add(new Student("张三", 18, "男"));
        set.add(new Student("张三", 18, "男"));
        set.add(new Student("李四", 20, "女"));
        set.add(new Student("王五", 21, "女"));
        System.out.println(set);*/

        //必须在类中重写hashCode和equals方法，使用快捷键
        set.add(new Student("张三", 18, "男"));
        set.add(new Student("张三", 18, "男"));
        set.add(new Student("李四", 20, "女"));
        set.add(new Student("王五", 21, "女"));
        System.out.println(set);

    }
}

class Student{
    private String name;
    private int age;
    private String sex;
    //判断两个对象内容是否相等
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name) && Objects.equals(sex, student.sex);
    }
    //如果对象内容相等，则返回相同的哈希值
    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}'+"\n";
    }

    public Student() {
    }

    public Student(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
