package com.HJh.test.oop.jiekou.jiekouxintexing2;

public class test {
    public static void main(String[] args) {
//     接口中的静态方法：
//        作用：为了接口升级而存在的，不能被重写
//        格式：public static 返回值类型 方法名(参数列表）{}
//                注意事项：
//                1，静态方法只能通过接口名调用，不能通过实现类名或者对象名调用
//                2.public可以省略，static不能省略
        Inter.show();
    }
}
