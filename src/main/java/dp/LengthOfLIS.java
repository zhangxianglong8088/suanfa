package dp;

import java.util.Arrays;

/**
 * 300. 最长递增子序列
 *
 * @description： https://leetcode.cn/problems/longest-increasing-subsequence/
 * @author: zhangxianglong
 * @date: 2022/5/25
 */
public class LengthOfLIS {

    static int lengthOfLIS(int[] nums) {

        // 定义：dp[i] 表示以从0号位置到i号位置这个闭区间的最长递增子序列的长度
        int[] dp = new int[nums.length];

        // base case：dp 数组全都初始化为 1
        Arrays.fill(dp, 1);
        //注意这里，如果求的是连续的递增序列 通过一次for循环就可以
        //如果求的是非连续的递增序列，需要通过两次for循环，用j指针取探，然后比最大值
        for (int i = 0; i < nums.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    //体会这里dp[j]+1的含义
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
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS4(nums));
    }

    public static int lengthOfLIS4(int[] nums) {

        //dp表示以nums[i] 为结尾的递增序列的长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max, dp[j] + 1);
                    dp[i] = max;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;

    }
}
