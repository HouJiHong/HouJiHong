package com.HJh.test;

import java.util.Scanner;

public class YiChuYuanSu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int n = sc.nextInt();
        int [] nums = new int [n];
        System.out.println("请输入" + n + "个数：");
        for (int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        System.out.println("请输入要删除的数：");
        int delNum = sc.nextInt();
        int slow = 0;
        int fast = 0;
        while(fast<nums.length){
            if(nums[fast]==delNum){
                fast++;
            }else{
                nums[slow]=nums[fast];
                slow++;
                fast++;

            }
        }
        System.out.println("删除后的数组");
        for (int i = 0; i < slow; i++) {
            System.out.println(nums[i]);
        }

    }
}
