package dp;

/**
 * 188. 买卖股票的最佳时机 IV
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/
 * K次交易
 *
 * @description：
 * @author: zhangxianglong
 * @date: 2022/7/22
 */
public class MaxProfitIV {


    /**
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices, int k) {
        if (prices.length == 0) {

        }
        //定义dp数组
        int n = prices.length;

        //maxK 表示剩余的可以交易次数 （0，1，2）所以定义maxK为3
        int maxK = k + 1;

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
                //第i天不持有股票 *** 这里买入一次和卖出一次算一次交易，选择在卖出的时候减去交易次数
                dp[i][j][0] = Math.max(dp[i - 1][j][1] + prices[i], dp[i - 1][j][0]);
                //第i天持有股票
                dp[i][j][1] = Math.max(dp[i - 1][j - 1][0] - prices[i], dp[i - 1][j][1]);
            }
        }
        return dp[n - 1][maxK - 1][0];
    }

    public static void main(String[] args) {

        int[] nums = new int[]{3, 2, 6, 5, 0, 3};
        int k = 2;

        int res = maxProfit(nums, k);

        System.out.println(res);


    }
}
