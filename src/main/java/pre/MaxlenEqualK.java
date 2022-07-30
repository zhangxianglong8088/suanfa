package pre;

import java.util.HashMap;
import java.util.Map;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/7/29
 */
public class MaxlenEqualK {

    public static int maxlenEqualK(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        //定义前缀和数组
        int[] preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
            if (map.get(preSum[i + 1]) == null) {
                map.put(preSum[i], i);
            }
        }

        int maxLen = 0;

        for (int i = nums.length; i >= 0; i--) {
            int target = preSum[i] - k;
            Integer index = map.get(target);
            if (index != null) {
                maxLen = Math.max(maxLen, i - map.get(target));
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, -2, 1, 1, 1};

        int k = 0;

        int res = maxlenEqualK(nums, k);

        System.out.println(res);

    }
}
