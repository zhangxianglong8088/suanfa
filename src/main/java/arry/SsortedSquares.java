package arry;

/**
 * @description：977. 有序数组的平方
 * https://leetcode.cn/problems/squares-of-a-sorted-array/
 * @author: zhangxianglong
 * @date: 2022/6/3
 */
public class SsortedSquares {

    public static int[] sortedSquares(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        int j = nums.length - 1;
        int[] arr = new int[nums.length];
        /**
         * 双指针 left 和 right 绝对值大的放到j的位置
         */
        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                arr[j] = nums[left] * nums[left];
                left++;
            } else {
                arr[j] = nums[right] * nums[right];
                right--;
            }
            j--;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-4, -1, 0, 3, 10};
        sortedSquares(nums);
    }
}
