package arry;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/find-the-duplicate-number/
 *
 * @description：287. 寻找重复数
 * @author: zhangxianglong
 * @date: 2022/5/26
 */
public class FindDuplicateXXX {

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

    /**
     * 快慢指针思想
     *
     * @param nums
     * @return
     */
    public static int findDuplicate2(int[] nums) {

        //　1、定义快慢直至
        int slow = 0;
        int fast = 0;

        //2、找到快慢指针相遇的位置
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (slow == fast) {
                break;
            }
        }

        //3、快慢指针相遇的位置不一定是环的入口
        //重新定义一个指针从数组头部开始遍历，slow指针也同步遍历，当finder和slow相等的时候，就找到了环的入口点
        int finder = 0;

        while (finder != slow) {
            finder = nums[finder];
            slow = nums[slow];
        }

        return slow;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 2, 2};
        System.out.println(findDuplicate(nums));
    }
}
