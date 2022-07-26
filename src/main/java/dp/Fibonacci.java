package dp;

/**
 * 509. 斐波那契数
 *
 * @description：https://leetcode.cn/problems/fibonacci-number/
 * @author: zhangxianglong
 * @date: 2022/5/25
 */
public class Fibonacci {

    public static int fibonacci(int n) {

        if (n <= 1) {
            return n;
        }
        //定义dp数组
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        //遍历dp数组
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int result = Fibonacci3(4);
        System.out.println(result);
    }

    public static int Fibonacci3(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];

    }
}
