package dp;

/**
 * @description： 122. 买卖股票的最佳时机 II
 * 交易次数不限制 k为无穷大（可以转为二维数组）
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
 * @author: zhangxianglong
 * @date: 2022/5/15
 */
public class MaxProfitII {
    /**
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices.length == 1) {
            return 0;
        }
        for (int i = 1; i < prices.length; i++) {
            // 卖出有利可图 就卖出
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    /**
     * 动态规划思想
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        //定义dp数组
        int n = prices.length;
        int[][] dp = new int[n][2];
        //i表示第几天
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            //j表示持有或者不持有股票
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            //注意这里和121的区别
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return dp[n - 1][0];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 4, 5};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }
}
