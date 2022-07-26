package dp;

import java.util.*;

/**
 * * https://leetcode.cn/problems/coin-change-2/
 * 518. 零钱兑换 II
 *
 * @description： https://leetcode.cn/problems/coin-change/
 * @author: zhangxianglong
 * @date: 2022/5/21
 */
public class CoinChangeII {

    /**
     * 动态规划 完全背包问题
     *
     * @param amount
     * @param coins
     * @return
     */
    public static int change(int amount, int[] coins) {

        int n = coins.length;
        // dp的含义：表示用前i种硬币兑换j元（amout）有多少种方法
        int[][] dp = new int[n + 1][amount + 1];

        //初始化dp数组
        for (int i = 0; i <= n; i++) {
            //背包装满,dp[1][0] = dp[0][0]=1,所以边界dp[0][0]可以认为满足
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= amount; j++) {

                if (j < coins[i - 1]) {
                    //当前选择的金额比目标金额要大 则保留i-1 的值
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //分为：选择coins[i] 的硬币和不选择 coins[i] 的硬币 将两种情况加起来
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }

        return dp[n][amount];
    }


    /**
     * 回溯算法 但是会超时
     *
     * @param target
     * @param nums
     * @return
     */
    public static int change2(int target, int[] nums) {

        List<List<Integer>> res = new ArrayList();

        Deque<Integer> path = new ArrayDeque();

        backtracing(res, path, 0, 0, target, nums);

        return res.size();

    }


    static void backtracing(List<List<Integer>> res, Deque<Integer> path, int index, int sum, int target, int[] nums) {
        //递归终止条件

        if (sum == target) {
            res.add(new ArrayList<>(path));
        }


        for (int i = index; i < nums.length; i++) {
            if (sum + nums[i] > target) {
                continue;
            }

            path.add(nums[i]);

            backtracing(res, path, i, sum += nums[i], target, nums);
            sum = sum - nums[i];

            path.removeLast();

        }
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 5};
        int target = 4;

        int res = change(target, nums);

        System.out.println(res);

    }
}
