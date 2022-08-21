package dp;

/**
 * @description：121. 买卖股票的最佳时机
 * 限制条件：只能一次买入 一次卖出
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 * @author: zhangxianglong
 * @date: 2022/5/15
 */
public class MaxProfitIGGG {

    /**
     * 暴力循环 超出时间限制
     *
     * @param prices
     * @return
     */
    public static int maxProfit1(int[] prices) {
        int ans = 0;

        for (int i = 0; i < prices.length - 1; i++) {

            for (int j = i + 1; j <= prices.length - 1; j++) {
                int profit = prices[j] - prices[i];
                ans = Math.max(profit, ans);
            }
        }
        return ans;
    }


    /**
     * 一次遍历
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/solution/121-mai-mai-gu-piao-de-zui-jia-shi-ji-by-leetcode-/
     * 一次遍历的过程中记录，历史的最小值，用当前值减去最小值就是
     *
     * @return
     */
    public static int maxProfit2(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            minPrice = Math.min(minPrice, prices[i]);

            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }

    /**
     * 动态规划
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/solution/121-mai-mai-gu-piao-de-zui-jia-shi-ji-by-leetcode-/
     *
     * @return
     */
    public static int maxProfit3(int[] prices) {
        //定义dp数组
        int n = prices.length;
        int[][] dp = new int[n][2];
        //i表示第几天
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            //j表示持有或者不持有股票
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            //思考这里为什么是 -prices[i] 因为 这个题目股票只能买卖一次
            dp[i][1] = Math.max(-prices[i], dp[i - 1][1]);
        }
        return dp[n - 1][0];
    }


    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int maxProfit = maxProfit1(prices);
        System.out.println(maxProfit);
    }
}
