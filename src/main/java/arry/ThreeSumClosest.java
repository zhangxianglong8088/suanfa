package arry;

import java.util.*;

/**
 * @description：最接近的三数之和 nums = [-1,2,1,-4], target = 1
 * https://leetcode.cn/problems/3sum-closest/submissions/
 * @author: zhangxianglong
 * @date: 2022/5/14
 */
public class ThreeSumClosest {


    /**
     * 排序+双指针
     *
     * @param nums
     * @param target
     * @return
     */
    static int threeSumClosest(int[] nums, int target) {
        int closestNums = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (right < nums.length - 1) {
                int sum = nums[i] + nums[left] + nums[right];
                //说明sum 更接近target
                if (Math.abs(sum - target) < Math.abs(closestNums - target)) {
                    closestNums = sum;
                }
                if (sum < target) {
                    left++;
                }
                if (sum > target) {
                    right--;
                }
                if (sum == target) {
                    return sum;
                }

            }
        }
        return closestNums;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4, 10000};
        System.out.println(threeSumClosest(nums, 1));

    }
}
