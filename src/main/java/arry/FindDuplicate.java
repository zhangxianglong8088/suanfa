package arry;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/find-the-duplicate-number/
 *
 * @description：287. 寻找重复数
 * @author: zhangxianglong
 * @date: 2022/5/26
 */
public class FindDuplicate {

    /**
     * 排序之后异或
     *
     * @param nums
     * @return
     */
    public static int findDuplicate(int[] nums) {

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int c = nums[i] ^ nums[i + 1];
            if (c == 0) {
                return nums[i];
            }
        }

        return 0;
    }

    public static int findDuplicate2(int[] nums) {
        int slow = 0, fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);


        slow = 0;

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 2, 2};
        System.out.println(findDuplicate(nums));
    }
}
