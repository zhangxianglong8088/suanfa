package arry;

/**
 * 我们让慢指针 slow 走在后面，快指针 fast 走在前面探路，找到一个不重复的元素就赋值给 slow 并让 slow 前进一步。
 * <p>
 * 这样，就保证了 nums[0..slow] 都是无重复的元素，当 fast 指针遍历完整个数组 nums 后，nums[0..slow] 就是整个数组去重之后的结果。
 *
 * @description：有序数组删除重复元素 https://leetcode.cn/problems/remove-duplicates-from-sorted-array/submissions/
 * @author: zhangxianglong
 * @date: 2022/5/14
 */
public class RemoveDuplicatesXXX {

    /**
     * 删除数
     *
     * @param args
     */

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2};
        int result = removeDuplicates(arr);
    }

    public static int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 1;

        while (right < nums.length) {
            //如果nums[left] 和nums[right] 相等 让right往后走，
            //往后走的过程中，找一个和nums[left]不相等的数，覆盖right原来的位置，也就是left++的位置
            if (nums[left] != nums[right]) {
                left++;
                nums[left] = nums[right];
            }
            right++;
        }
        return left + 1;
    }
}


