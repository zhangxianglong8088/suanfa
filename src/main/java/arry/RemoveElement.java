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
    static int removeElement(int[] nums, int val) {
        int idx = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != val) {
                nums[idx++] = nums[i];
            }
        }
        return idx;
    }

    /**
     * 自己的理解方法
     *
     * @param nums
     * @param val
     * @return
     */
    static int removeElement2(int[] nums, int val) {
        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
                fast++;
            } else {
                fast++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 2, 3};
        int length = removeElement2(nums, 3);
    }
}
