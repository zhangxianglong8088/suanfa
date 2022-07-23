package hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 *
 * @description： https://leetcode.cn/problems/longest-consecutive-sequence/
 * @author: zhangxianglong
 * @date: 2022/5/24
 */
public class LongestConsecutiveGGG {

    public static void main(String[] args) {

        int[] nums = new int[]{100, 4, 200, 1, 3, 2};

        System.out.println(longestConsecutive5(nums));
    }

    /**
     * @param nums
     * @return
     */
    public static int longestConsecutive5(int[] nums) {
        //所有元素都放到set里面
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int max = 0;
        for (int n : set) {
            //如果set集合中不存在 n-1 这个数 那么计算n开头的最大连续长度
            if (!set.contains(n - 1)) {
                int length = 1;
                while (set.contains(n + 1)) {
                    length++;
                    n++;
                }
                max = Math.max(length, max);
            }
        }
        return max;

    }
}
