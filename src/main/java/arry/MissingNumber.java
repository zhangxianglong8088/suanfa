package arry;

/**
 * @description： https://leetcode.cn/problems/que-shi-de-shu-zi-lcof/submissions/
 * @author: zhangxianglong
 * @date: 2022/5/16
 */
public class MissingNumber {

    public static int missingNumber(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] + 1 != nums[i + 1]) {
                return nums[i] + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 4, 5};
        System.out.println(missingNumber(nums));
    }
}
