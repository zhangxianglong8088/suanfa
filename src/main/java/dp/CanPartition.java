package dp;

/**
 * 416. 分割等和子集
 *
 * @description：https://leetcode.cn/problems/partition-equal-subset-sum/
 * @author: zhangxianglong
 * @date: 2022/6/16
 */
public class CanPartition {

    public static boolean canPartition(int[] nums) {
        //定义dp数组 dp[i][j] i表示0-i个数，j表示剩余容积
        int sum = 0;
        //1、计算数组总和
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        int n = nums.length;

        //定义dp数组
        boolean[][] dp = new boolean[n + 1][target + 1];

        //初始化dp数组 背包容量为0
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        //遍历物品
        for (int i = 1; i <= n; i++) {
            //遍历背包重量
            for (int j = 1; j <= target; j++) {
                //容量不足
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n - 1][target];
    }

    public static void main(String[] args) {
        int[] nusm = new int[]{1, 5, 11, 5};

        boolean res = canPartition(nusm);
        System.out.println(res);
    }
}
