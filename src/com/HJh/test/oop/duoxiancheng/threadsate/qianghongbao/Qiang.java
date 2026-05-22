package com.HJh.test.oop.duoxiancheng.threadsate.qianghongbao;

import java.util.List;
import java.util.Map;

public class Qiang extends  Thread{
    private List<Integer> hongBao;
    private Map<String, Employee> employeeMap;

    public Qiang (List<Integer> hongBao, String name, Map<String, Employee> employeeMap){
        super(name);
        this.hongBao = hongBao;
        this.employeeMap = employeeMap;
    }
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        while (true) {
            synchronized (hongBao){
                if (hongBao.size() == 0){
                    break;
                }
                int index = (int)(Math.random()*hongBao.size());
                int money = hongBao.remove(index);
                Employee employee = employeeMap.get(name);
                if (employee != null) {
                    employee.addAmount(money);
                }
                //System.out.println(name+"抢到："+money+"元");
                if (hongBao.size() == 0){
                    System.out.println("活动结束");
                    break;
                }
            }
        }

    }
}
