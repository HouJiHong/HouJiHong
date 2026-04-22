package com.HJh.test.oop.lambdayongfa.shiliyinyong;

import java.util.Arrays;
import java.util.Comparator;

//实例方法引用

//使用场景
//如果某个Lambda表达式里只是通过对象名称调用一个实例方法，并且“→”前后参数的形式一致，就可以使用实例方法引用。

//对象名::实例方法。

public class test {
    //对数组进行排序
    public static void main(String[] args) {
        Student[] students = new Student[5];
        students[0] = new Student("张三",18,"男",170.8);
        students[1] = new Student("李四",30,"女",170.2);
        students[2] = new Student("王五",20,"男",170.1);
        students[3] = new Student("赵六",17,"女",170.4);
        students[4] = new Student("孙七",22,"男",170.5);

        //利用arrays.sort()方法排序
        //参数一：要排序的数组
        //参数二：比较器对象，进行两两比较，o1小于o2，返回负数，大于返回正数，等于返回0
                 //他是一个接口，可以用匿名内部类实现

        //原来的使用匿名内部类方法
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //使用Double.compare()方法比较大小
                return Double.compare(o1.getHeight(), o2.getHeight());
            }
        });

        //发现Comparator方法是函数式接口，可以简化为lambda函数
        Arrays.sort(students, (Student o1, Student o2) -> {
            return Double.compare(o1.getHeight(), o2.getHeight());
        });

        //省略
        Arrays.sort(students, (o1, o2) ->  Double.compare(o1.getHeight(), o2.getHeight()));

        //实例方法引用
        //在Student类中定义了一个实例方法compareHeight，和静态不一样的是需要创建先对象,在调用时,发现它的形参和实现类一致
        Student t = new Student();
        //Arrays.sort(students, (o1, o2) -> t.compareHeight(o1, o2) );
        Arrays.sort(students, t::compareHeight);

        for (int i = 0; i < students.length; i++) {
            Student student = students[i];
            System.out.println(student.getName()+"---"+student.getAge()+"---"+student.getSex()+"---"+student.getHeight());
        }


    }
}
