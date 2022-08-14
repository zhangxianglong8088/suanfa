package arry;


import java.util.Arrays;

/**
 * @description：最接近的三数之和 nums = [-1,2,1,-4], target = 1
 * https://leetcode.cn/problems/3sum-closest/submissions/
 * @author: zhangxianglong
 * @date: 2022/5/14
 */
public class ThreeSumClosestGGG {


    /**
     * 排序+双指针
     *
     * @param nums
     * @param target
     * @return
     */
    static int threeSumClosest(int[] nums, int target) {
        // 排序
        Arrays.sort(nums);
        int closestNum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int threeSum = nums[l] + nums[r] + nums[i];
                if (Math.abs(threeSum - target) < Math.abs(closestNum - target)) {
                    closestNum = threeSum;
                }
                if (threeSum > target) {
                    r--;
                } else if (threeSum < target) {
                    l++;
                } else {
                    // 如果已经等于target的话, 肯定是最接近的
                    return target;
                }

            }

        }

        return closestNum;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4, 10000};
        System.out.println(threeSumClosest2(nums, 1));

    }

    public static int threeSumClosest2(int[] nums, int target) {

        int res = nums[0] + nums[1] + nums[2];
        int abs = Math.abs(target - res);

        Arrays.sort(nums);


        for (int i = 0; i < nums.length; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (Math.abs(target - sum) < abs) {
                    res = sum;
                    abs = Math.abs(target - sum);
                }

                if (sum > target) {
                    right--;
                } else {
                    left++;
                }

            }
        }

        return res;

    }
}
