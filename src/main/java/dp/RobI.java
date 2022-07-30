package dp;

/**
 * @description：打家劫舍 https://leetcode.cn/problems/house-robber/
 * 偷窃第 k 间房屋，那么就不能偷窃第 k-1 间房屋，偷窃总金额为前 k-2 间房屋的最高总金额与第 k 间房屋的金额之和。
 * <p>
 * 不偷窃第 k 间房屋，偷窃总金额为前 k-1 间房屋的最高总金额。
 * <p>
 * 作者：LeetCode-Solution
 * 链接：https://leetcode.cn/problems/house-robber/solution/da-jia-jie-she-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author: zhangxianglong
 * https://leetcode.cn/problems/house-robber/solution/da-jia-jie-she-by-leetcode-solution/
 * @date: 2022/5/26
 */
public class RobI {

    public static int rob(int[] nums) {
        if (nums.length <= 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(rob(nums));
    }
}
