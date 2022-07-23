package arry;

/**
 * @description：https://leetcode.cn/problems/sort-colors/solution/ren-zhe-suan-fa-quan-wang-zui-qing-xi-yi-pi8d/
 * @author: zhangxianglong
 * @date: 2022/7/21
 */
public class SortColors {
    public static void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        for (int i = 0; i <= right; i++) {
            //等于0就和left交换
            if (nums[i] == 0) {
                if (i > left) {
                    swap(nums, i, left);
                    left++;
                    //交换后的节点也需要判断，而不是跳到下一个元素
                    i--;
                }
            }
            //等于1就和right交换
            if (nums[i] == 2) {
                if (i < right) {
                    swap(nums, i, right);
                    right--;
                    i--;
                }
            }

        }
    }

    static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(nums);
    }
}
