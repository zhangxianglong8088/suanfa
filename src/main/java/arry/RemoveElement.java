package arry;

/**
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

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 2, 3};
        int length = removeElement(nums, 3);
    }
}
