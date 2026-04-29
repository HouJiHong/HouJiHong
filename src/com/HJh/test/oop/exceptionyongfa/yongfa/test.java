package com.HJh.test.oop.exceptionyongfa.yongfa;
//可以作为方法内部的一种特殊返回值,以便通知上层调用者，方法的执行问题
public class test {
    public static void main(String[] args) {
        System.out.println("程序开始执行");
        try {
            System.out.println(div(10,0));
        } catch (Exception e) {
            e.printStackTrace();//输出异常信息
        }
        System.out.println("程序结束");
    }


    //当发现方法中有异常，想中断方法的执行(替代return)，或者想将异常信息返回给调用者，就可以使用throws关键字
    private static int div(int i, int i1) throws Exception {
        if(i1==0){
            System.out.println("除数不能为0");
            throw new Exception("除数不能为0");
        }
        return i/i1;
    }
}

