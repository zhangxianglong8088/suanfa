package back;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/permutations-ii/
 * 47. 全排列 II
 *
 * @description： 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * @author: zhangxianglong
 * @date: 2022/6/26
 */
public class PermuteUnique {

    //存放结果
    static List<List<Integer>> result = new ArrayList<>();
    //暂存结果
    static List<Integer> path = new ArrayList<>();

    public static List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        Arrays.sort(nums);
        backTrack(nums, used);
        return result;
    }

    static void backTrack(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // used[i - 1] == true，说明同⼀树⽀nums[i - 1]使⽤过
            // used[i - 1] == false，说明同⼀树层nums[i - 1]使⽤过
            // 如果同⼀树层nums[i - 1]使⽤过则直接跳过
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }
            //如果同⼀树⽀nums[i]没使⽤过开始处理
            if (used[i] == false) {
                //标记同⼀树⽀nums[i]使⽤过，防止同一树枝重复使用
                used[i] = true;
                path.add(nums[i]);
                backTrack(nums, used);
                //回溯，说明同⼀树层nums[i]使⽤过，防止下一树层重复
                path.remove(path.size() - 1);
                //回溯
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        List<List<Integer>> list  =  permuteUnique(nums);
    }
}
