package com.HJh.test.oop.shijian;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        //jdk8前方式：date 获取此刻日期和时间
        Date date = new Date();
        System.out.println(date);

        //格式化:simpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss EEE a");
        String format = sdf.format(date);
        System.out.println(format);

        //jdk8之后：LocalDateTime
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.getYear()+"年"+now.getMonthValue()+"月"+now.getDayOfMonth()+"日"
                +now.getHour()+":"+now.getMinute()+":"+now.getSecond());

        LocalDateTime now2 = now.plusHours(3);
        System.out.println(now2);

        //格式化:DateTimeFormatter
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss EEE a");
        String format2 = dtf.format(now);
        System.out.println(format2);
    }
}
