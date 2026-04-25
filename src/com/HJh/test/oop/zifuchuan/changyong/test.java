package com.HJh.test.oop.zifuchuan.changyong;
//String类当中常见的方法：
//      比较          equals    equalsIgnoreCase      返回值类型：boolean
//      长度          length                          返回值类型：int
//      获取单个字符   charAt                         返回值类型：char
//      截取          substring                       返回值类型：String
//      替换          replace                         返回值：String


//      是否包含       contains
//      判断开头、结尾  startsWith/endsWith
//      查找           indexOf(int ch)  lastIndexOf(int ch)
//      判断是否为空    isEmpty()
//      转字符数组      toCharArray()
//      字符数组转字符串 String s3 = new String(chs);
//      指定位置替换    setCharAt(int index, char ch)

//      大小写转换      toUpperCase()、toLowerCase()
//      去除头尾空格    trim()
public class test {
    public static void main(String[] args) {
        String str = "abcdefg";
        //是否包含
        boolean result = str.contains("cde");
        System.out.println(result);
        //判断开头、结尾(第二个参数是指定开始下标)
        boolean result2 = str.startsWith("abc");
        boolean result3 = str.startsWith("abc",1);
        System.out.println(result2);
        System.out.println(result3);
        boolean result4 = str.endsWith("g");
        System.out.println(result4);
        //查找    indexOf(int ch)  lastIndexOf(int ch)
        //找到返回下标，找不到返回-1
        int index = str.indexOf(98);
        System.out.println(index);
        int index2 = str.indexOf("efg",2);
        System.out.println(index2);
        int index3 = str.lastIndexOf('c');
        System.out.println(index3);
        //判断是否为空
        boolean result5 = str.isEmpty();
        System.out.println(result5);
        //转字符数组
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]+" ");
        }
        System.out.println();
        //大小写转换
        String result6 = str.toUpperCase();
        System.out.println(result6);
        //去除头尾空格
        String str2 = "   a b c d   ";
        String result7 = str2.trim();
        System.out.println(result7);
    }
}
