package com.HJh.test.oop.IOyongfa.zijie;
//字节输入流

//public FileInputStream(File file)         创建字节输入流管道与源文件接通
//public FileInputStream(String pathname)   创建字节输入流管道与源文件接通

//public int read()                 每次读取一个字节返回，如果发现没有数据可读会返回-1.
//public int read(byte[] buffer)    每次用一个字节数组buffer去读取数据，返回字节数组读取了多少个字节，
// 如果发现没有数据可读会返回-1.

//一次读取完全部字节
//public byte[]readAllBytes() throws IOException    直接将当前字节输入流对应的文件对象的字节数据装到一个字节数组返回
//此方法只能用于读取小文件，如果文件过大，会抛出异常
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class InputStreamYongFa {
    public static void main(String[] args) throws Exception {
        /*//法一：
        //创建字节输入流管道连接源文件
        InputStream is = new FileInputStream("filecaozuo.txt");
        int b;//存储每次读取的字节
        while ((b = is.read()) != -1) {
            System.out.print((char) b);
            //每次读取一个字节，性能差，容易乱码
        }*/

        //法二：
        InputStream is2 = new FileInputStream("filecaozuo.txt");
        byte[] buffer = new byte[3];   //定义一个字节数组，作为容器来装3个字节
        int len;   //存储每次读取的字节个数
        while ((len = is2.read(buffer)) != -1) {
            String s = new String(buffer);//由于每次读三个字节，下一次读取的字节会覆盖上一次读取的字节，
                                            // 当读取的字节个数小于3时，会覆盖不完整

            //想要读多少倒多少，就要限制长度
            String s2 = new String(buffer,0,len);
            System.out.print(s2);
            //每次读取多个字节，性能好，但因为读多个字节时还是存在切割字节，所以还是存在乱码
        }

        is2.close();//关闭流

        //如果想要读取字节流不乱码，可以定义一个与文件一样大小的字节数组，作为容器，不会存在切割字节
        InputStream is3 = new FileInputStream("filecaozuo.txt");
        byte[] buffer2 = is3.readAllBytes();
        String s3 = new String(buffer2);
        System.out.println(s3);

        is3.close();
    }
}
