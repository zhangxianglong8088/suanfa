package back;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 494. 目标和
 *
 * @description：https://leetcode.cn/problems/target-sum/
 * @author: zhangxianglong
 * @date: 2022/7/5
 */
public class FindTargetSumWays {
    int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        Deque<Integer> path = new ArrayDeque<>();
        backtracing(nums, target, 0, 0);
        return count;
    }

    void backtracing(int[] nums, int target, int index, int sum) {
        //递归终止条件
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            backtracing(nums, target, index + 1, sum + nums[index]);
            backtracing(nums, target, index + 1, sum - nums[index]);
        }
    }
}
