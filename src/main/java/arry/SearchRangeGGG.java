package arry;

/**
 * @description：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 * @author: zhangxianglong
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * @date: 2022/5/17
 */
public class SearchRangeGGG {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] result = searchRange(nums, 6);
    }

    public static int[] searchRange(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[]{-1, -1};

        while (left < nums.length) {
            if (nums[left] == target) {
                res[0] = left;
                break;
            }
            left++;
        }

        while (right >= 0) {
            if (nums[right] == target) {
                res[1] = right;
                break;
            }
            right--;
        }
        return res;

    }
}
