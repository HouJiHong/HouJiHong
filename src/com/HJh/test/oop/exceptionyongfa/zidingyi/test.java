package com.HJh.test.oop.exceptionyongfa.zidingyi;
//自定义的编译时异常
public class test {
    public static void main(String[] args) {
        System.out.println("程序开始执行");
        try {
            saveAge(200);
        } catch (AgeIllegalException e) {
            e.printStackTrace();//输出异常信息
        }
        System.out.println("程序结束");
    }

    private static void saveAge(int age) throws AgeIllegalException {
        if(age<0||age>=200){
            throw new AgeIllegalException("年龄非法");
        }else{
            System.out.println("保存年龄成功"+ age);
        }
    }
}
