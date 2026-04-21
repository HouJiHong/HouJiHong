package com.HJh.test.oop.neibulei.nimingneibulei.lianxi2;

import java.util.Arrays;
import java.util.Comparator;

public class test {
    //对数组进行排序
    public static void main(String[] args) {
        Student[] students = new Student[5];
        students[0] = new Student("张三",18,"男",170.1);
        students[1] = new Student("李四",30,"女",170.2);
        students[2] = new Student("王五",20,"男",170.3);
        students[3] = new Student("赵六",17,"女",170.4);
        students[4] = new Student("孙七",22,"男",170.5);

        //利用arrays.sort()方法排序
        //参数一：要排序的数组
        //参数二：比较器对象，进行两两比较，o1小于o2，返回负数，大于返回正数，等于返回0
                 //他是一个接口，可以用匿名内部类实现
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //return o1.getAge()-o2.getAge();   // 升序
                return o2.getAge()-o1.getAge();   // 降序
            }
        });

        //简化为lambda
        Arrays.sort(students, (Student o1, Student o2) -> {
            //return o1.getAge()-o2.getAge();   // 升序
            return o2.getAge()-o1.getAge();   // 降序
        });

        //省略
        Arrays.sort(students, (o1, o2) ->  o2.getAge()-o1.getAge() );



        for (int i = 0; i < students.length; i++) {
            Student student = students[i];
            System.out.println(student.getName()+"---"+student.getAge()+"---"+student.getSex()+"---"+student.getHeight());
        }


    }
}
