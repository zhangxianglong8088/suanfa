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

    public static int findLength(int[] nums1, int[] nums2) {
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

    public static void main(String[] args) {

        int[] nums1 = new int[]{1, 2, 3, 2, 1};
        int[] nums2 = new int[]{3, 2, 1, 1, 4};

        findLength(nums1, nums2);

    }
}
