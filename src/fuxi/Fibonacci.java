package fuxi;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取输入的整数n
        int n = scanner.nextInt();

        // 如果n <= 0，则没有输出
        if (n <= 0) {
            scanner.close();
            return;
        }

        // 输出斐波那契数列的前n项
        long a = 0;  // 第一项
        long b = 1;  // 第二项

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                System.out.println(a);
            } else if (i == 2) {
                System.out.println(b);
            } else {
                long c = a + b;
                System.out.println(c);
                a = b;
                b = c;
            }
        }

        scanner.close();
    }
}