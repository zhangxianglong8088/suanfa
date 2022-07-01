package arry;

/**
 * 二分查找
 *
 * @description：https://leetcode.cn/problems/binary-search/
 * @author: zhangxianglong
 * @date: 2022/5/21
 */
public class HalfSearch {

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int middle;
        while (left <= right) {
            middle = (left + right) / 2;
            if (target < nums[middle]) {
                right = middle - 1;
            }
            if (target > nums[middle]) {
                left = middle + 1;
            }
            if (target == nums[middle]) {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 5;
        int rest = search(nums, target);
        System.out.println(rest);
    }

}
