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

    static int lengthOfLIS1(int[] nums) {

        // 定义：dp[i] 表示以从0号位置到i号位置这个闭区间的最长递增子序列的长度
        int[] dp = new int[nums.length];

        // base case：dp 数组全都初始化为 1 初始化为1的原因是 最小的长度是1 比如递减的数组 5 4 3 2 1 最长的递增序列是1
        Arrays.fill(dp, 1);
        //注意这里，如果求的是连续的递增序列 通过一次for循环就可以
        //如果求的是非连续的递增序列，需要通过两次for循环，用j指针取探，然后比最大值
        for (int i = 0; i < nums.length; i++) {
            //这里max也可以为1
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
        System.out.println(lengthOfLIS2(nums));
    }

    public static int lengthOfLIS2(int[] nums) {

        int n = nums.length;

        //以nums[i] 为结尾的最长的递增子序列的长度
        int[] dp = new int[n];

        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max, dp[j] + 1);
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
}
