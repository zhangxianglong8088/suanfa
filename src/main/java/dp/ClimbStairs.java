package dp;

/**
 * https://leetcode.cn/problems/climbing-stairs/
 *
 * @description： 70. 爬楼梯
 * @author: zhangxianglong
 * @date: 2022/5/24
 */
public class ClimbStairs {

    public static int climbStairs(int n) {

        if (n <= 2) {
            return n;
        }
        // 1. 定义状态数组，dp[i] 表示的是数字 i 的斐波那契数
        int[] arr = new int[n + 1];

        // 2. 状态初始化
        arr[1] = 1;
        arr[2] = 2;

        // 3. 状态转移
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }

        return arr[n];
    }

    public static void main(String[] args) {
        int result = climbStairs2(3);
        System.out.println(result);
    }

    public static  int climbStairs2(int n) {
        if (n <= 2) {
            return n;
        }

        //定义dp数组
        int[] dp = new int[n+1];

        //初始化dp数组
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        //遍历dp数组
        for (int i = 3; i <= dp.length-1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];

    }
}
