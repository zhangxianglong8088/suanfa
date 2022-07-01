package arry;

/**
 * @description： 122. 买卖股票的最佳时机 II
 * 一只股票可以多次买入和卖出
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
 * @author: zhangxianglong
 * @date: 2022/5/15
 */
public class MaxProfitIIXXX {
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

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 4, 5};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }
}
