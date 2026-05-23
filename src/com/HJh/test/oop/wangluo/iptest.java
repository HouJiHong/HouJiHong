package com.HJh.test.oop.wangluo;

import java.net.InetAddress;
//InetAddress的常用方法
//public static InetAddress getLocalHost() throws UnknownHostException  获取本机IP，返回一个InetAddress对象
//public String getHostName()           获取该ip地址对象对应的主机名。
//public String getHostAddress()        获取该ip地址对象中的ip地址信息。
//public static InetAddress getByName(String host) throws UnknownHostException  根据ip地址或者域名，
//                                                                              返回一个inetAddress对象
//public boolean isReachable(int timeout) throws IOException    判断主机在指定毫秒内与该ip对应的主机是否能连通

public class iptest {
    public static void main(String[] args) {
        try {
            // 获取本机ip(连接的网络的ip)
            InetAddress ip1 = InetAddress.getLocalHost();
            System.out.println(ip1);
            System.out.println(ip1.getHostName());
            System.out.println(ip1.getHostAddress());

            // 获取指定ip
            InetAddress ip2 = InetAddress.getByName("www.baidu.com");
            System.out.println(ip2);
            System.out.println(ip2.getHostName());
            System.out.println(ip2.getHostAddress());

            //判断ip是否可达
            System.out.println(ip2.isReachable(5000));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
