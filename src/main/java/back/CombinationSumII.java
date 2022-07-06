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

    static List<List<Integer>> lists = new ArrayList<>();
    static Deque<Integer> deque = new ArrayDeque<>();
    static int sum = 0;

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        //为了将重复的数字都放到一起，所以先进行排序
        Arrays.sort(candidates);
        //加标志数组，用来辅助判断同层节点是否已经遍历
        boolean[] flag = new boolean[candidates.length];
        backTracking(candidates, target, 0, flag);
        return lists;
    }

    public static void backTracking(int[] arr, int target, int index, boolean[] flag) {
        if (sum == target) {
            lists.add(new ArrayList(deque));
            return;
        }
        for (int i = index; i < arr.length && arr[i] + sum <= target; i++) {
            //*** 组合的去重复 固定相同的元素在排列中的相对位置  如果前面的相邻相等元素没有用过，则跳过
            if (i > 0 && arr[i] == arr[i - 1] && !flag[i - 1]) {
                continue;
            }
            flag[i] = true;
            sum += arr[i];
            deque.push(arr[i]);
            //每个节点仅能选择一次，所以从下一位开始
            backTracking(arr, target, i + 1, flag);
            int temp = deque.pop();
            flag[i] = false;
            sum -= temp;
        }
    }


    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        Deque<Integer> path = new ArrayDeque();
        boolean[] used = new boolean[candidates.length];
        backtracing(res, path, candidates, 0, 0, target, used);
        return res;
    }


    static void backtracing(List<List<Integer>> res, Deque<Integer> path, int[] candidates, int index, int sum, int target, boolean[] used) {

        //递归终止条件
        if (sum == target) {
            res.add(new ArrayList(path));
            return;
        }

        //单层递归的逻辑
        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] > target && !used[i] && candidates[i - 1] == candidates[i - 1]) {
                continue;
            }

            used[i] = true;
            path.add(candidates[i]);

            backtracing(res, path, candidates, i + 1, sum += candidates[i], target, used);

            //回溯
            path.removeLast();
            sum = sum - candidates[i];
            used[i] = false;
        }
    }
}
