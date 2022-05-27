package arry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @description：两数和 https://leetcode.cn/problems/two-sum/submissions/
 * @author: zhangxianglong
 * @date: 2022/5/14
 */
public class TwoSum {
    /**
     * 求两数之和为11的两个数组元素
     *
     * @param target
     */
    public static Integer[] twoSum(Integer[] nums, Integer target) {

        if (null == nums) {
            return new Integer[]{};
        }

        Integer[] arr = new Integer[2];

        for (int i = 0; i <= nums.length - 1; i++) {
            for (int j = i + 1; j <= nums.length - 1; j++) {
                if (nums[i] + nums[j] == target) {
                    arr[0] = nums[i];
                    arr[1] = nums[j];
                }
            }

        }
        return arr;
    }


    /**
     * 求两数之和为11的两个数组元素 hash
     *
     * @param target
     */
    public static int[] twoSumByHash(Integer[] nums, Integer target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[2];
        for (int i = 0; i <= nums.length - 1; i++) {
            if (map.containsKey(target - nums[i])) {
                arr[0] = map.get(target - nums[i]);
                arr[1] = i;
            }
            map.put(nums[i], i);
        }
        return arr;
    }


    /**
     * 求两数之和为11的两个数组元素
     *
     * @param target
     */
    public static ArrayList<Integer> twoSum1(Integer[] nums, Integer target) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else {
                list.add(nums[i]);
                list.add(target - nums[i]);
                break;
            }
        }
        return list;
    }

    /**
     * 如果假设输入一个数组 nums 和一个目标和 target，请你返回 nums 中能够凑出 target 的两个元素的值，比如输入 nums = [1,3,5,6], target = 9，那么算法返回两个元素 [3,6]。可以假设只有且仅有一对儿元素可以凑出 target。
     * <p>
     * 我们可以先对 nums 排序，然后利用前文 双指针技巧 写过的左右双指针技巧，从两端相向而行就行了：
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum3(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                return new int[]{nums[left], nums[right]};
            }
        }
        return new int[]{};
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 11, 15};
        int[] result = twoSum3(arr, 9);
    }
}
