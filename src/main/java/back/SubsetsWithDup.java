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
public class SubsetsWithDup {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};
        List<List<Integer>> res = subsetsWithDup(nums);
    }


    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        // 先排序，让相同的元素靠在一起
        Arrays.sort(nums);

        backtrack(res, path, nums, 0);

        return res;
    }

    static void backtrack(List<List<Integer>> res, Deque<Integer> path, int[] nums, int index) {
        res.add(new ArrayList(path));
        //递归终止条件
        if (index >= nums.length) {
            return;
        }

        //单层递归逻辑
        for (int i = index; i < nums.length; i++) {
            // *** 子集的去重 值相同的相邻树枝，只遍历第一条
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);

            backtrack(res, path, nums, i + 1);

            path.removeLast();
        }
    }
}
