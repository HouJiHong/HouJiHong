package com.HJh.test.oop.duoxiancheng.threadsate.qianghongbao;

import java.util.*;

public class test {
    public static void main(String[] args) {
        List<Integer> HongBao = getHongBao();
        Map<String, Employee> employeeMap = new HashMap<>();

        for (int i = 0; i < 100; i++) {
            String name = "人" + i;
            employeeMap.put(name, new Employee(name));
            Thread th = new Qiang(HongBao, name, employeeMap);
            th.start();
        }

        System.out.println("\n========== 抢红包结果统计 ==========");
        for (Employee employee : employeeMap.values()) {
            if (employee.getTotalAmount() > 0) {
                System.out.println(employee);
            }
        }


    }
    public static List<Integer> getHongBao(){
        List<Integer> HongBao = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 160; i++) {
            HongBao.add(random.nextInt(30)+1);//随机1-30
        }
        for (int i = 0; i < 40; i++) {
            HongBao.add(random.nextInt(70)+31);//随机31-100
        }
        return HongBao;
    }
}
