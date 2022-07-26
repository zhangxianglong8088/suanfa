package dp;

/**
 * @description： 123. 买卖股票的最佳时机 III
 * 。你最多可以完成 两笔 交易。
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/
 * @author: zhangxianglong
 * @date: 2022/5/15
 */
public class MaxProfitIIIXXX {

    /**
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        //定义dp数组
        int n = prices.length;

        //maxK 表示剩余的可以交易次数 （0，1，2）所以定义maxK为3
        int maxK = 3;

        //定义dp数组
        int[][][] dp = new int[n][maxK][2];

        //初始化dp数组  第0天不持有股票的时候 收益为0 第0天持有股票的时候收益为第一天股票价格的负数
        for (int i = 0; i <= maxK - 1; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }

        for (int i = 1; i < n; i++) {
            //j表示持有或者不持有股票
            for (int j = 1; j <= maxK - 1; j++) {
                //第i天不持有股票
                dp[i][j][0] = Math.max(dp[i - 1][j][1] + prices[i], dp[i - 1][j][0]);
                //第i天持有股票
                dp[i][j][1] = Math.max(dp[i - 1][j - 1][0] - prices[i], dp[i - 1][j][1]);
            }
        }
        return dp[n - 1][maxK - 1][0];
    }


    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 4, 5};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }
}
