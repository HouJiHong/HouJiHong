package com.HJh.test.oop.fileyongfa;
//递归三要素:
//递归的公式：f(n) = f(n-1)* n;
//递归的终结点：f(1)=1
//递归的方向必须走向终结点
public class diGui {
    public static void main(String[] args) {
        //猴子吃桃,每一天吃前一天的一半多一,第十天只有一个桃子,第一天有多少桃子
        //递归公式：f(n+1) = f(n)-f(n)/2-1
        //变形：f(n) = 2f(n+1)+2
        //递归的终结点：f(10)=1

        System.out.println(f(1));


    }
    public static int f(int n){
        if(n==10){
            return 1;
        }
        return 2*f(n+1)+2;
    }
}
