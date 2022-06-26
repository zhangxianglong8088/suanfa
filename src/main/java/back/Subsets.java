package back;

import java.util.*;

/**
 * https://leetcode.cn/problems/subsets/
 *
 * @description：78. 子集
 * @author: zhangxianglong
 * @date: 2022/5/21
 */
public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        backtracking(nums, res, path, 0);
        return res;
    }

    static void backtracking(int[] nums, List<List<Integer>> res, Deque<Integer> path, int index) {
        //递归入口直接收集结果
        res.add(new ArrayList<>(path));
        //递归函数的终止条件
        if (index >= nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, res, path, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};
        List<List<Integer>> res = subsets(nums);
    }
}
