package arry;

import java.util.HashMap;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/5/15
 */
public class MinNumberDisappeared {

    /**
     * @param nums
     * @return
     */
    public static int minNumberDisappeared(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> mp = new HashMap<>();
        //哈希表记录数组中出现的每个数字
        for (int i = 0; i < n; i++) {
            mp.put(nums[i], 1);
        }
        int res = 1;
        //从1开始找到哈希表中第一个没有出现的正整数
        while (mp.containsKey(res)) {
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 3, 4, 1, 5};
        System.out.println(minNumberDisappeared(nums));
    }
}
