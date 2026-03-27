package com.HJh.test.oop.jichenyongfa.jichenzonghe;

/*本科学生：属性：姓名、年龄、年级。行为：吃饭、睡觉、学习（攻读学士学位）
研究生：属性：姓名、年龄、年纪。行为：吃饭、睡觉、学习（攻读硕士学位）
专业课老师：属性：姓名、年龄、学科。行为：吃饭、睡觉、教学（讲授专业课）
通识课老师：属性：姓名、年龄、学科。行为：吃饭、睡觉、教学（讲授通识课）*/


public class test {
    public static void main(String[] args) {
        BachelorStudent b = new BachelorStudent("张三", 18, "大一");
        System.out.println(b.getName()+" "+b.getAge()+" "+b.getGrade());
        b.study();
        b.eat();
        b.sleep();
           }
}
