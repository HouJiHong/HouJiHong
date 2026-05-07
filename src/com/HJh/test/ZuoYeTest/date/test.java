package com.hjh.test.zuoye.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class test {
    public static void main(String[] args) {
        // 1. 生成10个0~100的随机正整数
        System.out.println("生成的10个随机数：");
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int num = random.nextInt(101); // 0~100（包含100）
            System.out.print(num + " ");
        }
        System.out.println("\n");

        // 2. 计算100天后的日期并格式化输出
        Calendar calendar = Calendar.getInstance(); // 获取当前日期
        calendar.add(Calendar.DAY_OF_YEAR, 100); // 加100天

        Date date = calendar.getTime(); // 获取Date对象

        DateFormat df = new SimpleDateFormat("yyyy年MM月dd日"); // 格式化日期
        String formattedDate = df.format(date); // 格式化日期为字符串

        System.out.println("100天后的日期：" + formattedDate); // 输出格式化后的日期
    }
}
