package arry;

/**
 * @description：209. 长度最小的子数组  滑动窗口
 * https://leetcode.cn/problems/minimum-size-subarray-sum/
 * @author: zhangxianglong
 * @date: 2022/5/23
 */
public class MinSubArrayLen {
    public static int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int right = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        while (right < nums.length) {
            sum = sum + nums[right];
            if (sum < target) {
                right++;
            } else {
                minLen = Math.min(minLen, right - left + 1);
                left++;
                right = left;
                sum = 0;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, nums));
    }
}
