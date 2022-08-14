package arry;

import java.util.HashMap;

/**
 * 缺失的第一个正整数
 *
 * @description： https://www.nowcoder.com/practice/50ec6a5b0e4e45348544348278cdcee5?tpId=117&tqId=37800&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%25E7%25AC%25AC%25E4%25B8%2580%25E4%25B8%25AA%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=undefined&judgeStatus=undefined&tags=&title=%E7%AC%AC%E4%B8%80%E4%B8%AA
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
