package fuxi;

import java.util.Scanner;

public class JieChen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取输入的整数
        int n = scanner.nextInt();

        // 如果 n < 0，则没有输出（程序直接结束）
        if (n < 0) {
            scanner.close();
            return;
        }

        // 计算阶乘
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        // 输出结果
        System.out.println(result);

        scanner.close();
    }
}