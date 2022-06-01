package back;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. 组合总和
 * https://leetcode.cn/problems/combination-sum/
 *
 * @description：
 * @author: zhangxianglong
 * @date: 2022/6/1
 */
public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);

        backTracking(res, new ArrayList<>(), candidates, target, 0, 0);
        return res;

    }

    public static void backTracking(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int sum, int index) {
        //递归终止
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            path.add(candidates[i]);
            backTracking(res, path, candidates, target, sum + candidates[i], i);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 6, 7};
        List<List<Integer>> list = combinationSum(nums, 7);
    }
}
