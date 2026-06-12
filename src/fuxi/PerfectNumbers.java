package fuxi;

import java.util.Scanner;

public class PerfectNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取自然数n
        int n = scanner.nextInt();
        scanner.close();

        // 从2开始检查每个数是否为完全数（1不是完全数）
        for (int i = 2; i <= n; i++) {
            if (isPerfect(i)) {
                System.out.print(i + " ");
            }
        }
    }

    // 判断一个数是否为完全数
    public static boolean isPerfect(int num) {
        int sum = 0;

        // 找出所有真因子并求和
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }

        // 判断真因子之和是否等于原数
        return sum == num;
    }
}
