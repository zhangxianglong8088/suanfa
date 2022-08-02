package dp;

import java.util.Arrays;

/**
 * 674. 最长连续递增序列
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * 解法参考：https://leetcode.cn/problems/longest-continuous-increasing-subsequence/solution/tu-biao-si-lu-kan-bu-dong-ni-da-wo-ji-ba-7fr7/
 *
 * @description：674. 最长连续递增序列（子数组）
 * @author: zhangxianglong
 * @date: 2022/6/25
 */
public class FindLengthOfLCIS {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 4, 7};
        int res = findLengthOfLCIS5(nums);
        System.out.println(res);
    }

    /**
     * 初始化数组dp,每个索引所对应的值均为1。
     * 从索引 0 的位置开始遍历，若后一个元素 大于 前一个元素，则 dp[i] = dp[i - 1] + 1; 递减则不做任何操作,相当于dp[i] = 1。
     * 循环结束，dp = [1, 2, 3, 1, 2, 3, 4, 1]，取最大值4。
     * <p>
     * 作者：ju-ren-zhang
     * 链接：https://leetcode.cn/problems/longest-continuous-increasing-subsequence/solution/tu-biao-si-lu-kan-bu-dong-ni-da-wo-ji-ba-7fr7/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public static int findLengthOfLCIS(int[] nums) {
        //定义dp数组 dp[i] 表示以nums[i] 为结尾的连续递增子序列的最大长度
        int res = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }


    public static int findLengthOfLCIS5(int[] nums) {
        //以nums[i] 为结尾的连续递增数组的长
        int[] dp = new int[nums.length];
        dp[0] = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] <= nums[i - 1]) {
                dp[i] = 1;
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }

        int max = 0;

        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
