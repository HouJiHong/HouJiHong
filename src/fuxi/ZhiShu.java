package fuxi;

import java.lang.Math;
import java.util.Scanner;

public class ZhiShu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取输入的整数
        int n = scanner.nextInt();

        // 判断是否为质数
        boolean isPrime = true;

        // 小于2的数不是质数
        if (n < 2) {
            isPrime = false;
        } else {
            // 检查从2到n-1是否有因数
            // 优化：只需要检查到平方根即可
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        // 输出结果
        if (isPrime) {
            System.out.println(n + "是质数。");
        } else {
            System.out.println(n + "不是质数。");
        }

        scanner.close();
    }
}