package dp;

/**
 * 714. 买卖股票的最佳时机含手续费
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 *
 * @description：
 * @author: zhangxianglong
 * @date: 2022/7/22
 */
public class MaxProfitVI {

    public static int maxProfit(int[] prices, int fee) {
        //定义dp数组
        int n = prices.length;

        //不限制交易次数 可以转为二维dp数组
        int[][] dp = new int[n][2];

        //初始化dp数组
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        //i表示第几天
        for (int i = 1; i < n; i++) {
            //第i-1天卖掉股票 卖出扣手续费
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i] - fee, dp[i - 1][0]);

            //第i天持有股票
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }

        return dp[n - 1][0];
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 3, 7, 5, 10, 3};

        int res = maxProfit(nums, 3);

        System.out.println(res);
    }
}
