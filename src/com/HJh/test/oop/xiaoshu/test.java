package com.HJh.test.oop.xiaoshu;
//ctrl+f 搜索,ctrl+r 替换

//BigDecimal的常见构造器、常用方法
//构造器
//public BigDecimal(double val) 将double转换为BigDecimal (注意：不推荐使用这个)
//public BigDecimal(String val)把String转成BigDecimal
//方法名
    //public static BigDecimal valueOf(double val)  转换一个double成BigDecimal
//public BigDecimal add(BigDecimal b)           加法
//public BigDecimal subtract(BigDecimal b)      减法
//public BigDecimal multiply(BigDecimal b)      乘法
//public BigDecimal divide(BigDecimal b)        除法
//public BigDecimal divide(另一个BigDecimal对象，精确几位，舍入模式)   除法、可以控制精确到小数几位
    //public double doubleValue()                   将BigDecimal转换为double

import java.math.BigDecimal;
import java.math.RoundingMode;

public class test {
    public static void main(String[] args) {
        //利用BigDecimal类处理浮点数精度问题
        double a = 0.1;
        double b = 0.2;
        System.out.println(a+b);

        BigDecimal a1 = new BigDecimal(a+ "");
        BigDecimal a11 = BigDecimal.valueOf(a);    //转换一个double成BigDecimal(推荐)
        BigDecimal b1 = new BigDecimal(b+ "");
        System.out.println(a11.add(b1));
        double result = a11.add(b1).doubleValue(); //转换为double

        BigDecimal a2 = new BigDecimal("0.1");
        BigDecimal b2 = new BigDecimal("0.3");
        //由于0.1/0.3除不尽，需要舍入
        BigDecimal result1 = a2.divide(b2, 2, RoundingMode.HALF_UP);
        double result2 = result1.doubleValue();
        System.out.println(result2);
    }
}
