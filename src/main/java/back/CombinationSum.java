package back;

import java.util.*;

/**
 * 39. 组合总和
 * https://leetcode.cn/problems/combination-sum/
 * 元素可以重复使用
 *
 * @description：
 * @author: zhangxianglong
 * @date: 2022/6/1
 */
public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);

        Deque<Integer> path = new ArrayDeque<>();

        backTracking(res, path, candidates, 0, 0, target);

        return res;
    }


    /**
     * 确定递归函数的参数、返回值
     *
     * @param res
     * @param path
     * @param candidates
     * @param index
     * @param sum
     * @param target
     */
    static void backTracking(List<List<Integer>> res, Deque<Integer> path, int[] candidates, int index, int sum, int target) {
        //递归终止条件就是满足题意条件
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        //单层递归逻辑
        for (int i = index; i < candidates.length; i++) {
            sum = sum + candidates[i];
            if (sum > target) {
                break;
            }
            path.add(candidates[i]);
            //因为选取元素可以重复 这里index还是从i开始
            backTracking(res, path, candidates, i, sum, target);
            //开始回溯 弹出最右一个元素
            if (path.size() > 0) {
                sum = sum - candidates[i];
                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 6, 7};
        List<List<Integer>> list = combinationSum(nums, 7);
    }
}
