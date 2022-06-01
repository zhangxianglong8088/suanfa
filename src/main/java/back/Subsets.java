package back;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
        LinkedList<Integer> path = new LinkedList<>();

        if (nums.length == 0) {
            return new ArrayList<>();
        }
        res.add(new LinkedList<>());
        backTracking(res, path, nums, 0);

        return res;
    }


    static void backTracking(List<List<Integer>> res, LinkedList<Integer> path, int[] nums, Integer index) {
        //递归终止条件 剩余集合为空 终止
        if (index >= nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            res.add(new LinkedList<>(path));
            backTracking(res, path, nums, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> res = subsets(nums);
    }
}
