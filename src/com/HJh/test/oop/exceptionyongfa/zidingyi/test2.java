package com.HJh.test.oop.exceptionyongfa.zidingyi;
//自定义的运行时异常
public class test2 {
    public static void main(String[] args) {
        System.out.println("程序开始执行");
        saveAge(200);
        //可以省略掉try catch
        try {
            saveAge(200);
        } catch (AgeIllegalRuntimeException e) {
            e.printStackTrace();//输出异常信息
        }
        System.out.println("程序结束");
    }

    private static void saveAge(int age) {//默认throws RuntimeException
        if(age<0||age>=200){
            throw new AgeIllegalRuntimeException("年龄非法");
        }else{
            System.out.println("保存年龄成功"+ age);
        }
    }
}
