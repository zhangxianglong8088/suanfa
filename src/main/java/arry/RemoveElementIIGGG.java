package arry;

/**
 * 27. 移除元素（还没理解）
 * https://leetcode.cn/problems/remove-element/
 *
 * @description：删除数组中指定的元素
 * @author: zhangxianglong
 * @date: 2022/5/14
 */
public class RemoveElementIIGGG {

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
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int length = removeElement3(nums, 2);
    }

    /***
     * 自己的理解思路
     * left和right同步往后走，如果找到了一个和目标元素相等的数，left不动，让right去找一个和target不想等的数来覆盖left的值
     * 然后left和right同步再往后走
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement3(int[] nums, int val) {
        int left = 0;
        int right = 0;

        while (right < nums.length) {
            if (nums[right] != val) {
                left++;
                right++;
            } else {
                while (right < nums.length) {
                    if (nums[right] != val) {
                        nums[left] = nums[right];
                        left++;
                    }
                    right++;
                }
            }
        }
        return left;
    }
}
