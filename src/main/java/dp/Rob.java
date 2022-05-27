package dp;

/**
 * @description：打家劫舍 https://leetcode.cn/problems/house-robber/
 * @author: zhangxianglong
 * @date: 2022/5/26
 */
public class Rob {


    public static int rob(int[] nums) {
        if(nums.length<=1){
            return nums[0];
        }

        //定义dp数组
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        int max = 0;

        //状态转移方程
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{0};
        System.out.println(rob(nums));
    }
}
