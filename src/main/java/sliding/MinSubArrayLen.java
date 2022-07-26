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


    public static int minSubArrayLen1(int target, int[] nums) {

        int left = 0;
        int right = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        while (right < nums.length) {

            sum = sum + nums[right];

            while (sum >= target) {
                //满足条件的情况下 不断缩小窗口
                minLen = Math.min(right - left + 1, minLen);
                sum = sum - nums[left];
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }


    /**
     * 自己理解的思路
     *
     * @param nums
     * @param target
     * @return
     */
    public static int minSubarray2(int[] nums, int target) {


        int left = 0;
        int right = 0;

        int n = nums.length;
        int sum = 0;
        int res = Integer.MAX_VALUE;


        while (right < n) {
            sum += nums[right];
            if (sum >= target) {
                res = Math.min(res, right - left + 1);
            }

            while (sum > target) {
                sum = sum - nums[left];
                if (sum >= target) {
                    left++;
                    res = Math.min(res, right - left + 1);
                } else {
                    left++;
                }
            }

            right++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(minSubarray2(nums, 15));
    }
}
