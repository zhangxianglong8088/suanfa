package arry;

import java.util.*;

/**
 * 448. 找到所有数组中消失的数字
 *
 * @description：https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/submissions/
 * @author: zhangxianglong
 * @date: 2022/5/18
 */
public class FindDisappearedNumbersHHH {

    /**
     * 比较好的一个思路：
     * 找出 1 - n 中没有出现的数字。不能使用额外的空间，两次循环时间复杂度为 2O(n)，即为 O(n)。
     * <p>
     * 解题思路：使用数组的下标来标记数字的出现于否，通过一遍遍历即可标记出全部已经出现的数组
     * <p>
     * [4,3,2,7,8,2,3,1] 初始数据
     * <p>
     * [4,3,2,-7,8,2,3,1] 第一个数据 4 出现，将数组的第四个也就是下标 3 的数据修改为负数。-7 计算时，通过绝对值处理一下即可不影响数据的计算
     * [4,3,-2,-7,8,2,3,1]
     * [4,-3,-2,-7,8,2,3,1]
     * [4,-3,-2,-7,8,2,-3,1]
     * [4,-3,-2,-7,8,2,-3,-1]
     * [4,-3,-2,-7,8,2,-3,-1]
     * [4,-3,-2,-7,8,2,-3,-1]
     * [-4,-3,-2,-7,8,2,-3,-1]
     * <p>
     * 计算结束，数组的第五个，第六个依然为整数，证明 5,6 没有出现
     *
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                results.add(i + 1);
            }
        }
        return results;
    }


    public static List<Integer> findDisappearedNumbers(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int n : nums) {
            set.add(n);
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= nums.length; i++) {

            if (!set.contains(i)) {
                list.add(i);
            }
        }
        return list;

    }


    public static void main(String[] args) {

        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> result = findDisappearedNumbers1(nums);
    }
}
