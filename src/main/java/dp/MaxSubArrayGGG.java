package dp;

/**
 * 最大子数组和
 *
 * @description： https://leetcode.cn/problems/maximum-subarray/
 * @author: zhangxianglong
 * @date: 2022/5/21
 */
public class MaxSubArrayGGG {

    public static int maxSubArray(int[] nums) {
        //0-i之间最最大和
        int[] dp = new int[nums.length];

        dp[0] = nums[0];

        /**
         * 注意体会这里
         * Math.max(dp[i - 1] + nums[i], nums[i])
         * 为什么是这两个比较，而不是 Math.max(dp[i - 1] + nums[i], dp[i-1]) ，如果是dp[i-1] 则发生不连续了
         */
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < dp.length; i++) {

            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(maxSubArray(nums));
    }
}
