package back;

import java.util.*;

/**
 * https://leetcode.cn/problems/permutations-ii/
 * 47. 全排列 II
 *
 * @description： 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * @author: zhangxianglong
 * @date: 2022/6/26
 */
public class PermuteUnique {
    static boolean[] used;

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtrack(res, path, nums);
        return res;
    }

    static void backtrack(List<List<Integer>> res, Deque<Integer> path, int[] nums) {
        //递归终止条件
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        //单层递归逻辑
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // *** 重点 剪枝逻辑，值相同的相邻树枝，只遍历第一条
            //全排列的去重复 固定相同的元素在排列中的相对位置  如果前面的相邻相等元素没有用过，则跳过
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtrack(res, path, nums);
            path.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1};
        List<List<Integer>> list = permuteUnique(nums);
    }
}
