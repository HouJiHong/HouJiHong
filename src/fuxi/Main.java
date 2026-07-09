package fuxi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取一行字符串
        String str = scanner.nextLine();

        int upperCount = 0;  // 大写字母计数
        int lowerCount = 0;  // 小写字母计数
        int otherCount = 0;  // 其他字符计数

        // 遍历字符串中的每个字符
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                upperCount++;  // 大写字母
            } else if (ch >= 'a' && ch <= 'z') {
                lowerCount++;  // 小写字母
            } else {
                otherCount++;  // 其他字符（包括空格、数字、标点等）
            }
        }

        // 输出结果
        System.out.println(upperCount);
        System.out.println(lowerCount);
        System.out.println(otherCount);

        scanner.close();
    }
}