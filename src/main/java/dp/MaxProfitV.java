package dp;

/**
 * 309. 最佳买卖股票时机含冷冻期
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 *
 * @description：
 * @author: zhangxianglong
 * @date: 2022/7/22
 */
public class MaxProfitV {

    public static int maxProfit(int[] prices) {

        //定义dp数组
        int n = prices.length;

        //不限制交易次数 可以转为二维dp数组
        int[][] dp = new int[n][2];

        //初始化dp数组
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], -prices[1]);

        //i表示第几天
        for (int i = 2; i < n; i++) {
            //j表示持有或者不持有股票
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            //注意这里和121的区别
            dp[i][1] = Math.max(dp[i - 2][0] - prices[i], dp[i - 1][1]);
        }

        return dp[n - 1][0];
    }

    public static void main(String[] args) {

        int[] nusm = new int[]{1};

        int res = maxProfit(nusm);

        System.out.println(res);
    }
}
