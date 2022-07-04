package sliding;

import java.util.HashSet;
import java.util.Set;

/**
 * @description：NC41 最长无重复子数组
 * @author: zhangxianglong
 * @date: 2022/5/15
 */
public class MaxLength {

    /**
     * 滑动窗口
     *
     * @param arr
     * @return
     */
    static int maxLength(int[] arr) {
        //滑动窗口
        int left = 0;
        int right = 0;
        int len = arr.length;

        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;

        while (right < len) {
            //如果集合中j不存在 直接加入
            if (!set.contains(arr[right])) {
                set.add(arr[right]);
                right++;
            } else {
                //如果集合中存在right则删除left 下次循环把right再加进去
                set.remove(arr[left]);
                left++;
            }
            max = Math.max(set.size(), max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2};
        int maxLength = maxLength2(nums);
        System.out.println(maxLength);
    }

    static int maxLength2(int[] nums) {

        int left = 0;
        int right = 0;
        int maxLen = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();

        while (right < nums.length) {
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                left++;
            }
            set.add(nums[right]);
            maxLen = Math.max(maxLen, set.size());
            right++;
        }
        return maxLen;
    }
}
