package com.HJh.test.oop.jichenyongfa.jichen_gouzaofangfa_tedian;
//在子类中的空参构造中会默认有一个super（），用来调用父类的空参构造方法，没写也可以用
//如果要访问父类的带参构造，super(参数列表)必须写上，不能省略
//在创建对象的时候，先执行父类在执行子类的构造方法




public class test {
    public static void main(String[] args) {
        Student s1 = new Student("zhangsan", 18, "一年级");
        Teacher t1 = new Teacher("lisi", 30,"数学");
    }
}
