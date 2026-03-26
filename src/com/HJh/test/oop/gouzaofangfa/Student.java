package com.HJh.test.oop.gouzaofangfa;
//所谓构造方法，就是类名与方法名一致，但无返回值，无返回值类型，在创建对象时就给成员变量初始化
//系统都会有一个默认的空参构造方法，比如Dog d1 = new Dog();就是调用空参构造方法，但是要一一赋值，如果自己写了构造方法，系统就不会提供默认无参构造方法，需要自己创建
//构造方法可以快速初始化，不需要一一赋值，比如Dog d1 = new Dog("小白",15);
public class Student {
    private String name;
    private int age;
    private String gender;
    private int weight;


    //构造方法
     //空参构造方法
    public Student(){
        //空
    }

     //带全部参数的构造方法

        // 注意  没有返回值类型
    public Student(String name,int age,String gender,int weight){
        this.name = name;
        if (age<0||age>100){
            System.out.println("请输入正确的年龄");

        }else{
            this.age = age;
        }
        this.gender = gender;
        this.weight = weight;
    }




    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAge(int age){
        if(age>0&&age<100){
            this.age = age;
        }else{
            System.out.println("请输入正确的年龄");
        }
    }
    public int getAge(){
        return age;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public String getGender(){
        return gender;
    }
    public void setWeight(int weight){
        this.weight = weight;
    }
    public int getWeight(){
        return weight;
    }

}
