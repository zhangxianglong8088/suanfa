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
public class RemoveDuplicates {

    /**
     * 有序数组删除重复元素
     *
     * @param arr
     * @return
     */
    static int removeDuplicates(int[] arr) {

        if (arr == null || arr.length == 0) {
            return 0;
        }

        int slow = 0;
        int fast = slow + 1;

        while (fast <= arr.length - 1) {
            if (arr[slow] != arr[fast]) {
                arr[slow + 1] = arr[fast];
                slow++;
            }
            fast++;
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2};
        int result = removeDuplicates(arr);
    }
}
