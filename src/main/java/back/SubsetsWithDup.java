package back;

import java.util.*;

/**
 * https://leetcode.cn/problems/subsets-ii/
 * 90. 子集 II
 *
 * @description：给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * @author: zhangxianglong
 * @date: 2022/6/26
 */
public class SubsetsWithDup {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtracing(res, path, nums, 0, used);
        return res;
    }

    static void backtracing(List<List<Integer>> res, Deque<Integer> path, int[] nums, int index, boolean[] used) {
        res.add(new ArrayList<>(path));
        //递归函数的终止条件
        if (index >= nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtracing(res, path, nums, i + 1, used);
            path.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};
        List<List<Integer>> res = subsetsWithDup(nums);
    }
}
