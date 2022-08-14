package back;

import java.util.*;

/**
 * https://leetcode.cn/problems/subsets-ii/
 * 90. 子集 II
 * 去重思路：
 * https://labuladong.github.io/algo/4/30/106/
 *
 * @description：给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * @author: zhangxianglong
 * @date: 2022/6/26
 */
public class SubsetsWithDupGGG {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};
        List<List<Integer>> res = subsetsWithDup(nums);
    }


    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        Deque<Integer> path = new ArrayDeque();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtracing(res, path, nums, 0, used);
        return res;
    }


    static void backtracing(List<List<Integer>> res, Deque<Integer> path, int[] nums, int index, boolean[] used) {
        //递归终止条件
        res.add(new ArrayList(path));
        if (index >= nums.length) {
            return;
        }


        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtracing(res, path, nums, i + 1, used);
            path.removeLast();
            used[i] = false;
        }

    }
}
