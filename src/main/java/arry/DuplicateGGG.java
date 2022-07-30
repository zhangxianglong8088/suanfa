package arry;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @description：数组中重复的数字 https://www.nowcoder.com/practice/6fe361ede7e54db1b84adc81d09d8524?tpId=196&tqId=39734&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D2%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D196&difficulty=undefined&judgeStatus=undefined&tags=578&title=
 * @author: zhangxianglong
 * @date: 2022/5/16
 */
public class DuplicateGGG {
    /**
     * 通过hash set
     *
     * @param nums
     * @return
     */
    static int duplicate(int[] nums) {
        if (nums == null) {
            return -1;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= nums.length - 1; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            } else {
                set.add(nums[i]);
            }
        }
        return -1;
    }


    static int duplicate2(int[] nums) {
        if (nums == null) {
            return -1;
        }
        Arrays.sort(nums);

        for (int i = 0; i <= nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1, 1};
        System.out.println(duplicate2(arr));

    }
}
