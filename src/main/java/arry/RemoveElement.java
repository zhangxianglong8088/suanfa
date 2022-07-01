package arry;

/**
 * 27. 移除元素（还没理解）
 * https://leetcode.cn/problems/remove-element/
 *
 * @description：删除数组中指定的元素
 * @author: zhangxianglong
 * @date: 2022/5/14
 */
public class RemoveElement {

    /**
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int fast = 0;
        int slow = 0;

        while (fast < nums.length) {
            //如果fast的值和目标值相同，fast往回走，直到找到一个和目标值不相同的数
            // 用这个数覆盖left位置的数，然后left和right同时往后移动
            if (nums[fast] == val) {
                fast++;
            } else {
                nums[slow] = nums[fast];
                slow++;
                fast++;
            }
        }
        return slow;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 2, 3};
        int length = removeElement(nums, 3);
    }

}
