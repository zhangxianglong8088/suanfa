package arry;

import java.util.*;

/**
 * 448. 找到所有数组中消失的数字
 *
 * @description：https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/submissions/
 * @author: zhangxianglong
 * @date: 2022/5/18
 */
public class FindDisappearedNumbers {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], 1);
        }

        for (int i = 1; i <= nums.length; i++) {
            Integer result = map.get(i);
            if (result == null) {
                list.add(i);
            }
        }
        return list;
    }


    public static void main(String[] args) {

        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> result = findDisappearedNumbers5(nums);
    }

    public static List<Integer> findDisappearedNumbers5(int[] nums) {
        List<Integer> res = new ArrayList();

        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, 1);
        }

        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            if (map.get(i) == null) {
                res.add(i);
            }
        }
        return res;
    }
}
