package sliding;

/**
 * @description：209. 长度最小的子数组  滑动窗口
 * https://leetcode.cn/problems/minimum-size-subarray-sum/
 * @author: zhangxianglong
 * @date: 2022/5/23
 */
public class MinSubArrayLen {

    /**
     * 滑动窗口
     *
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        while (right < nums.length) {
            sum = sum + nums[right];
            while (sum >= target) {
                //条件满足，缩小窗口
                minLen = Math.min(minLen, right - left + 1);
                //总和减去满足条件的最近一个值
                sum = sum - nums[left];
                //窗口缩小
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }


    public static int minSubArrayLen3(int target, int[] nums) {

        int left = 0;
        int right = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        while (right < nums.length) {
            sum = sum + nums[right];
            while (sum >= target) {
                minLen = Math.min(right - left + 1, minLen);
                sum = sum - nums[left];
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen3(7, nums));
    }
}
