package arry;

/**
 * @description：121. 买卖股票的最佳时机
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 * @author: zhangxianglong
 * @date: 2022/5/15
 */
public class MaxProfitI {

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
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i <= prices.length - 1; i++) {
            minPrice = Math.min(prices[i], minPrice);
            if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 6, 4, 3, 1};
        int maxProfit = maxProfit3(prices);
    }

    public static int maxProfit3(int[] prices) {

        int minPrice = Integer.MAX_VALUE;

        int maxPrifit = 0;

        for (int i = 0; i < prices.length; i++) {
            minPrice = Integer.min(prices[i], minPrice);
            maxPrifit = Math.max(maxPrifit, prices[i] - minPrice);

        }
        return maxPrifit;
    }
}
