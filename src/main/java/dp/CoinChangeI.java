package dp;

import java.util.*;

/**
 * * https://www.bilibili.com/video/BV13f4y1e7vL?spm_id_from=333.337.search-card.all.click
 * 322. 零钱兑换
 * 注意点：分不开的问题
 *
 * @description： https://leetcode.cn/problems/coin-change/
 * @author: zhangxianglong
 * @date: 2022/5/21
 */
public class CoinChangeI {

    /**
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 数组大小为 amount + 1，初始值也为 amount + 1
        //为什么不能用0初始化 ，因为我们比较的是最小值 比较的值可能比0大了，最小值就变成0 错误
        //为什么要用amount+1初始化
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        // 外层 for 循环在遍历所有状态的所有取值
        for (int i = 0; i < dp.length; i++) {

            int min = Integer.MAX_VALUE;

            for (int conin : coins) {
                if (i - conin < 0) {
                    continue;
                }
                min = Math.min(min, dp[i - conin] + 1);
                dp[i] = min;
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4};

        int result = coinChange(arr, 11);

        System.out.println(result);
    }
}
