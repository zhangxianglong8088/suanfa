package dp;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/6/25
 */
public class RobII {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 2};
        int n = rob(nums);
        System.out.println(n);

    }

    public static int rob(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int len = nums.length;
        // 1、第一个和最后一个都不取
        //2、取第一个，第二个不取
        //3、取最后一个，第一个不取
        //第二种情况和第三种情况已经包含第一种情况
        int[] dp1 = new int[len - 1];
        int[] dp2 = new int[len - 1];

        for (int i = 0; i < len - 1; i++) {
            dp1[i] = nums[i];
            dp2[i] = nums[i + 1];
        }
        return Math.max(robHelper(dp1), robHelper(dp2));
    }

    public static int robHelper(int[] nums) {
        if (nums.length <= 1) {
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
}
