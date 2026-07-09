package fuxi;

import java.util.Scanner;

public class PrimeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取正整数n
        int n = scanner.nextInt();
        scanner.close();

        // 逐个判断并输出素数
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    // 判断一个数是否为素数
    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        // 只需检查到平方根即可
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}