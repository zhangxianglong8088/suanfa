package arry;

/**
 * https://leetcode.cn/problems/binary-search/submissions/
 *
 * @description：二分查找
 * @author: zhangxianglong
 * @date: 2022/5/21
 */
public class BinarySearch {


    static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            int locationVal = nums[middle];
            if (locationVal > target) {
                right = middle - 1;
            } else if (locationVal < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{5};
        int location = binarySearch(nums, 5);
        System.out.println(location);
    }
}
