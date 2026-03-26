package com.HJh.test.oop;
//this 关键字就是使用成员变量
public class Dog {
    private String name;
    private int age;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setAge(int age){
        if(age>0&&age<15){
            this.age = age;
        }else{
            System.out.println("请输入正确的年龄");
        }
    }
    public int getAge(){
        return age;
    }

    public void bark() {
        System.out.println(age+"岁的"+name+"正在汪汪叫");
    }

    public Dog() {
    }

    public Dog(String name, int age) {
        this.name = name;
        if(age>0&&age<15){
            this.age = age;
        }else{
            System.out.println("请输入正确的年龄");
        }
    }
}
