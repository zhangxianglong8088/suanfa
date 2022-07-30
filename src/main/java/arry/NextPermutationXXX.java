package arry;

import java.util.Arrays;

/**
 * @description：31. 下一个排列
 * https://leetcode.cn/problems/next-permutation/
 * @author: zhangxianglong
 * @date: 2022/7/19
 */
public class NextPermutationXXX {

    /**
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        //思考这里为什么是两层for循环
        //从尾部一直往前找
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] < nums[j]) {
                    //交换i 、j的位置
                    swap(nums, i, j);
                    //i后面的元素排序
                    Arrays.sort(nums, i + 1, nums.length);
                    return;
                }
            }
        }
        //如果不存在一个前小后大的组合，说明当前数组的排列是最大的，直接将原数组进行排序
        Arrays.sort(nums);
    }

    static void swap(int[] nums, int i, int j) {

        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1};
        nextPermutation3(nums);
    }


    public static void nextPermutation3(int[] nums) {
        int n = nums.length;
        int lastValue = nums[n - 1];
        int last = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] < nums[j]) {
                    //交换i 、j的位置
                    swap(nums, i, j);
                    //i后面的元素排序
                    Arrays.sort(nums, i + 1, nums.length);
                    return;
                }
            }

        }
        //如果不存在一个前小后大的组合，说明当前数组的排列是最大的，直接将原数组进行排序
        Arrays.sort(nums);
    }

}

