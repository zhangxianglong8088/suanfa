package dp;

/**
 * 最大子数组和
 *
 * @description：https://leetcode.cn/problems/maximum-subarray/
 * @author: zhangxianglong
 * @date: 2022/5/21
 */
public class MaxSubArray {

    public static int maxSubArray(int[] nums) {

        //定义dp数组
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i <= dp.length - 1; i++) {

            max = Math.max(dp[i],max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }
}
