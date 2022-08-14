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
public class RemoveElementIGGG {

    /**
     * 删除数
     */


    public static int removeDuplicates1(int[] nums) {
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


    /**
     * 自己理解的思路
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates2(int[] nums) {
        int left = 0;
        int right = 1;

        while (right < nums.length) {

            //如果left和right的值不相同，left和right同时往后走
            if (nums[left] != nums[right]) {
                left++;
                right++;
            } else {
                while (right < nums.length) {
                    //如果相同，right去后面找一个数和left不相同，赋值给left++的位置，然后left和right同时往后走
                    if (nums[left] != nums[right]) {
                        left++;
                        nums[left] = nums[right];
                    }
                    right++;
                }
            }
        }
        return left + 1;
    }


    /**
     * 自己理解的第二个思路
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates3(int[] nums) {

        int n = nums.length;

        int left = 0;
        int right = 1;


        while (right < n) {

            if (nums[left] != nums[right]) {
                left++;
                right++;
            } else {
                while (right < n && nums[left] == nums[right]) {
                    right++;
                }
                if (right < n) {
                    nums[left + 1] = nums[right];
                    left++;
                }
            }
        }

        return left + 1;


    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2};
        int result = removeDuplicates3(arr);
    }

}


