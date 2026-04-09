package com.HJh.test.oop.duotaiyongfa.jichu.lianxi2;
//1．雇员是人类社会中的一种角色，每个雇员信息描述中应包括名字和工作报酬。
//2．学生也是人类社会中的一种角色，每个学生描述信息中应包括名字和就读的学校名。
public class test {
    public static void main(String[] args) {
        People[] people = new People[2];
        people[0] = new Employee("abc",5000);
        people[1] = new Student("bcd","cde");
        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i].getName()+people[i].getDescription());
        }

        for(People p:people){
            System.out.println(p.getName()+p.getDescription());
        }

        People p1 = new Student("张三","cde");
        People p2 = new Employee("张三",5000);
        System.out.println(p1.getName()+p1.getDescription());
        System.out.println(p2.getName()+p2.getDescription());
    }
}
