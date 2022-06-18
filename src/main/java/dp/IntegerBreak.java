package dp;

import java.util.Arrays;

/**
 * 343. 整数拆分
 * https://programmercarl.com/0343.%E6%95%B4%E6%95%B0%E6%8B%86%E5%88%86.html#%E6%80%BB%E7%BB%93
 *
 * @description：https://leetcode.cn/problems/integer-break/
 * @author: zhangxianglong
 * @date: 2022/6/16
 */
public class IntegerBreak {

    public static int integerBreak(int n) {
        //定义dp数组 dp[i]的含义是值为i的整数拆分的乘积的最大值
        int[] dp = new int[n + 1];

        dp[2] = 1;
        //i是要拆分的整数
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i - j; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];

    }

    public static void main(String[] args) {
        Integer res = integerBreak(10);
        System.out.println(res);
    }
}
