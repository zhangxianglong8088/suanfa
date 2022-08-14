package back;

import java.util.*;

/**
 * 40. 组合总和 II
 * 不可以重复使用元素
 * 难点：对结果集如何去重
 *
 * @description： https://leetcode.cn/problems/combination-sum-ii/
 * @author: zhangxianglong
 * @date: 2022/6/26
 */
public class CombinationSumII {

    public static void main(String[] args) {

        int[] arr = new int[]{10, 1, 2, 7, 6, 1, 5};

        List<List<Integer>> res = combinationSum2(arr, 8);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();

        ArrayDeque<Integer> path = new ArrayDeque<>();
        //排序 目的是将相同的元素放到一起 进行去重复
        Arrays.sort(candidates);

        boolean[] flag = new boolean[candidates.length];

        backtracing(res, path, candidates, target, 0, 0, flag);

        return res;
    }

    /**
     * 定义递归函数
     *
     * @param res
     * @param path
     * @param candidates
     * @param target
     * @param sum
     * @param index
     * @param flag
     */
    static void backtracing(List<List<Integer>> res, ArrayDeque<Integer> path, int[] candidates, int target, int sum, int index, boolean[] flag) {

        //递归终止条件
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        //单层递归逻辑
        for (int i = index; i < candidates.length; i++) {
            //判断sum是否超过target
            if (sum + candidates[i] > target) {
                continue;
            }

            //去重复逻辑
            if (i > index && candidates[i - 1] == candidates[i] && !flag[i - 1]) {
                continue;
            }

            path.add(candidates[i]);

            flag[i] = true;

            //递归调用
            backtracing(res, path, candidates, target, sum + candidates[i], i + 1, flag);

            flag[i] = false;
            //回溯
            path.removeLast();

        }
    }
}
