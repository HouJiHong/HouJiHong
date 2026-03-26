package com.HJh.test.oop;

public class Stu {
    private String name;
    private int age;

    //alt+insert打开快捷创建构造方法
    public Stu() {

    }
    public Stu(String name, int age) {
        this.name = name;
        if(age>0&&age<100){
            this.age = age;
        }else{
            System.out.println("请输入正确的年龄");
        }
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
        if(age>0&&age<100){
            this.age = age;
        }else{
            System.out.println("请输入正确的年龄");
        }
    }

    public void eat(){
        System.out.println(this.name+"正在吃东西");
    }
    public void sleep(){
        System.out.println(this.name+"正在睡觉");
    }
    public void study(){
        System.out.println(this.name+"正在学习");
    }

}
