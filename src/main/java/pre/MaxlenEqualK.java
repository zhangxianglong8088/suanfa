package pre;

import java.util.HashMap;
import java.util.Map;

/**
 * @description： https://www.nowcoder.com/practice/704c8388a82e42e58b7f5751ec943a11?tpId=117&tqId=37794&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3Dk%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=undefined&judgeStatus=undefined&tags=&title=k
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
                map.put(preSum[i + 1], i + 1);
            }
        }

        int maxLen = 0;

        for (int i = nums.length; i >= 0; i--) {
            int target = k - preSum[i];
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
