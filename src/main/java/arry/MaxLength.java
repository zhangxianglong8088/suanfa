package arry;

import java.util.HashSet;
import java.util.Set;

/**
 * @description：NC41 最长无重复子数组
 * @author: zhangxianglong
 * @date: 2022/5/15
 */
public class MaxLength {


    static int maxLength(int[] arr) {

        Set<Integer> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int max = Integer.MIN_VALUE;

        while (j < arr.length) {
            //集合中不包含当前数 ，直接加入集合
            if (!set.contains(arr[j])) {
                set.add(arr[j]);
                j++;
                max = Math.max(set.size(), max);
            } else {
                //集合中包含要加入的值，删除下标为i的值
                set.remove(arr[i]);
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 1, 99, 6};
        int maxLength = maxLength(nums);
        System.out.println(maxLength);
    }
}
