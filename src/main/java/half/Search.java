package half;

/**
 * 33. 搜索旋转排序数组
 *
 * @description：https://leetcode.cn/problems/search-in-rotated-sorted-array/
 * @author: zhangxianglong
 * @date: 2022/7/19
 */
public class Search {

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
//            int middle = (right + left) / 2;上面写法的空间复杂度要小很多
            if (target == nums[middle]) {
                return middle;
            } else if (nums[left] <= nums[middle]) {
                //左边是连续的
                //目标值是否在左边的区间
                if (nums[left] <= target && target < nums[middle]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }

            } else {
                //右边是连续的
                //目标值是否在右边的区间
                if (nums[middle] < target && target <= nums[right]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int res = search(nums, 0);
        System.out.println(res);
    }
}
