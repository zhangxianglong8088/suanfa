package back;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @description：216. 组合总和 III
 * https://leetcode.cn/problems/combination-sum-iii/
 * @author: zhangxianglong
 * @date: 2022/6/26
 */
public class CombinationSumIII {

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();

        backtracking(1, n, 0, k, res, path);

        return res;
    }

    /**
     * 递归函数
     */
    static void backtracking(int index, int n, int sum, int k, List<List<Integer>> res, Deque<Integer> path) {
        //1、确定递归函数的终止条件
        if (sum == n && path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        //2、单层递归
        for (int i = index; i <= 9; i++) {
            path.add(i);
            backtracking(i + 1, n, sum + i, k, res, path);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int n = 7;
        List<List<Integer>> list = combinationSum34(k, n);
    }

    /**
     * @param k
     * @param n
     * @return
     */
    public static List<List<Integer>> combinationSum34(int k, int n) {
        List<List<Integer>> res = new ArrayList();
        Deque<Integer> path = new ArrayDeque();
        backtracing4(res, path, 1, n, 0, k);

        return res;


    }


    static void backtracing4(List<List<Integer>> res, Deque<Integer> path, int index, int target, int sum, int k) {
        //递归终止条件
        if (sum == target && path.size() == k) {
            res.add(new ArrayList(path));
            return;
        }

        //单层递归逻辑
        for (int i = index; i <= 9; i++) {
            if (sum > target || path.size() >= k) {
                break;
            }
            path.add(i);
            backtracing4(res, path, i + 1, target, sum + i, k);
            path.removeLast();
        }
    }
}
