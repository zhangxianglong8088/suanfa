package dp;

/**
 * https://programmercarl.com/0718.%E6%9C%80%E9%95%BF%E9%87%8D%E5%A4%8D%E5%AD%90%E6%95%B0%E7%BB%84.html#%E6%BB%9A%E5%8A%A8%E6%95%B0%E7%BB%84
 * https://leetcode.cn/problems/maximum-length-of-repeated-subarray/
 *
 * @description：718. 最长重复子数组
 * @author: zhangxianglong
 * @date: 2022/6/25
 */
public class FindLength {

    public static int findLength1(int[] nums1, int[] nums2) {
        //定义dp数组

        //dp[i][j] ：以下标i - 1为结尾的A，和以下标j - 1为结尾的B，最长重复子数组长度为dp[i][j]。

        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        //初始化dp数组
        int result = 0;

        //遍历dp数组
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        //返回
        return result;
    }


    /**
     * 这也是一个思路 但是效率不高 问题：这个思路是在推倒dp数组 思路一是直接求了最大值
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int findLength2(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;

        int[][] dp = new int[n1][n2];
        int max = 0;

        for (int i = 0; i < n2; i++) {
            if (nums1[0] == nums2[i]) {
                dp[0][i] = 1;
            }
        }

        for (int i = 0; i < n1; i++) {
            if (nums2[0] == nums1[i]) {
                dp[i][0] = 1;
            }
        }

        for (int i = 1; i < n1; i++) {
            for (int j = 1; j < n2; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        int res = 0;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }


    public static void main(String[] args) {

        int[] nums1 = new int[]{0, 1, 1, 1, 1};
        int[] nums2 = new int[]{1, 0, 1, 0, 1};

        System.out.println(findLength1(nums1, nums2));

    }
}
