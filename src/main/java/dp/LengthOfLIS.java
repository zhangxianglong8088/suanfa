package dp;

import java.util.Arrays;

/**
 * 300. 最长递增子序列
 *
 * @description：https://leetcode.cn/problems/longest-increasing-subsequence/
 * @author: zhangxianglong
 * @date: 2022/5/25
 */
public class LengthOfLIS {

    static int lengthOfLIS(int[] nums) {
        // 定义：dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        // base case：dp 数组全都初始化为 1
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(dp[j] + 1, max);
                    dp[i] = max;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 7, 7, 7, 7, 7, 7};
        System.out.println(lengthOfLIS(nums));
    }
}