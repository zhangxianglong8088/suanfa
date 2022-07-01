package arry;

import java.util.HashMap;
import java.util.Map;

/**
 * @description：剑指 Offer 39. 数组中出现次数超过一半的数字
 * https://leetcode.cn/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 * 思路：对数排序，半数以上的数字在中间
 * @author: zhangxianglong
 * @date: 2022/5/16
 */
public class MajorityElement {
    /**
     * 通过hash 表
     *
     * @param nums
     * @return
     */
    public static int majorityElement1(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
            if (map.get(nums[i]) > ((nums.length) / 2)) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * https://leetcode.cn/problems/find-majority-element-lcci/solution/zhu-yao-yuan-su-by-leetcode-solution-xr1p/
     * 投票算法
     *
     * @return
     */
    public static int majorityElement2(int[] nums) {

        int count = 1;
        int cadidate = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (cadidate == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    cadidate = nums[i];
                    count = 1;
                }
            }
        }

        /**
         * 验证是否为众数
         */
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == cadidate) {
                x++;
            }
        }

        return x > nums.length / 2 ? cadidate : -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3};
        System.out.println(majorityElement2(nums));
    }
}
