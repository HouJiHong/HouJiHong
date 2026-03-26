package com.HJh.test;

//超级重要：主方法是static，是静态的，静态方法不能访问非静态成员变量和成员方法，所以创建的方法也必须是静态的（+static）
//如果不加static，则方法必须创建对象才能调用，如：
//public double sum(int a, int b){              // 非静态
//    return a+b;
//}
//public static void main(String[] args) {
//    FangFaTest obj = new FangFaTest();        // 先创建对象
//    System.out.println(obj.sum(a,b));         // 用对象调用
//}




//方法的格式：
    //修饰符 返回值类型 方法名(参数列表){}
    //方法名(参数1，参数2);

//注意：
    //方法不调用不执行
    //方法和方法是平级关系，不能嵌套定义
    //方法调用会优先调用形参和实参匹配的方法，如果没有匹配的，会隐式类型转换且调用转换次数最少的方法
public class FangFaTest {
    public static void main(String[] args) {
        int a=10;
        int b=20;
        System.out.println(sum(a,b));
    }
    //方法重载: 方法名相同，参数列表不同
     //无需看返回类型
    //第一快
    public static double sum(int a,int b){
        return a+b;
    }

    //下两个不要同时定义，类型转换次数都是1，会报错

    public static double sum(int a,double b){
        return a+b;
    }
    public static double sum(double a,int b){
        return a+b;
    }


    //最慢
    public static double sum(double a,double b){
        return a+b;
    }

}
