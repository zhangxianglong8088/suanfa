package arry;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 17.04. 消失的数字
 *
 * @description： https://leetcode.cn/problems/que-shi-de-shu-zi-lcof/submissions/
 * @author: zhangxianglong
 * @date: 2022/5/16
 */
public class MissingNumberXXX {

    /**
     * 通过位运算骚操作
     *
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {

        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            res ^= i;
            res ^= nums[i];
        }
        res ^= nums.length;

        return res;
    }

    /**
     * 通过hashMap
     *
     * @param nums
     * @return
     */
    public static int missingNumber3(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, 1);
        }

        for (int i = 0; i <= nums.length; i++) {
            Integer n = map.get(i);
            if (n == null) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0};
        System.out.println(missingNumber3(nums));
    }
}
