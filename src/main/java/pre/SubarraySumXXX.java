package pre;

/**
 * https://leetcode.cn/problems/subarray-sum-equals-k/
 *
 * @description：560. 和为 K 的子数组
 * @author: zhangxianglong
 * @date: 2022/5/26
 */
public class SubarraySumXXX {

    /**
     * 暴力解法
     *
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = nums[i];
            if (sum == k) {
                count++;
            }

            for (int j = i + 1; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * 前缀和
     * https://leetcode.cn/problems/subarray-sum-equals-k/solution/de-liao-yi-wen-jiang-qian-zhui-he-an-pai-yhyf/
     *
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum2(int[] nums, int k) {

        //1、构建前缀和数组 前缀和数组的长度比愿数组长1

        int[] preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int count = 0;

        //2、区间和满足条件count++；
        for (int left = 0; left < nums.length; left++) {

            for (int right = left; right < nums.length; right++) {
                if (preSum[right + 1] - preSum[left] == k) {
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        int res = subarraySum2(nums, 3);
        System.out.println(res);
    }
}
