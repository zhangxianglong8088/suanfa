package arry;

import java.util.HashSet;
import java.util.Set;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/5/24
 */
public class LongestConsecutive {

    public static int longestConsecutive(int[] nums) {
        int res = 0;

        Set<Integer> hash = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            hash.add(nums[i]);
        }

        for (Integer num : hash) {
            if (!hash.contains(num - 1)) {
                //以当前数x向后枚举
                int y = num;
                while (hash.contains(y + 1)) {
                    y++;
                }
                //更新答案
                res = Math.max(res, y - num + 1);
            }
        }
        return res;

    }

    public static void main(String[] args) {

        int[] nums = new int[]{100, 4, 200, 1, 3, 2};

        System.out.println(longestConsecutive(nums));
    }
}
