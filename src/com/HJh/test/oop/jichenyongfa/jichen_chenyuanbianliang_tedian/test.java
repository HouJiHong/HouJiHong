package com.HJh.test.oop.jichenyongfa.jichen_chenyuanbianliang_tedian;
//就近原则
//先在局部位置中查找，没有再在成员位置中查找，父类位置找

//注意：最多只能查找到父类，不能查找到根类


public class test {
    public static void main(String[] args) {
        Zi zi = new Zi();
        zi.zishow();
    }
}

class Fu {
    String name = "Fu";
}

class Zi extends Fu {
    String name = "Zi";
    public void zishow(){
        String name ="zishow";
        System.out.println(name);           //从局部位置中开始查找
        System.out.println(this.name);      //从成员位置中开始查找
        System.out.println(super.name);     //从父类位置中查找
    }
}
