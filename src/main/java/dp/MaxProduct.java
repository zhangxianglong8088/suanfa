package dp;

/**
 * @description：152. 乘积最大子数组
 * https://leetcode.cn/problems/maximum-product-subarray/
 * @author: zhangxianglong
 * @date: 2022/5/23
 */
public class MaxProduct {

    public static int maxProduct(int[] nums) {

        //1、定义dp数组
        int[] dp = new int[nums.length];

        //2、初始化dp数组
        dp[0] = nums[0];

        //3、状态转移方程
        for (int i = 0; i < dp.length; i++) {

            int max = Integer.MIN_VALUE;

            for (int j = 0; j < i; j++) {
                max = Math.max(max, dp[j] * nums[i]);
                dp[i] = max;
            }
        }
        return dp[0];
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, -2, 4};
        maxProduct(nums);
    }

}
