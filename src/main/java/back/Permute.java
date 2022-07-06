package back;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode.cn/problems/permutations/
 *
 * @description：46. 全排列
 * @author: zhangxianglong
 * @date: 2022/5/27
 */
public class Permute {
    public static List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        backTracking(nums, res, path);

        return res;
    }


    static void backTracking(int[] nums, List<List<Integer>> res, List<Integer> path) {
        //递归终止条件
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            backTracking(nums, res, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nms = new int[]{1, 2, 3};
        List<List<Integer>> res = permute(nms);
    }
}
