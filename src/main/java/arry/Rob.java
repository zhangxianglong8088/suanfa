package arry;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/5/24
 */
public class Rob {
    public static int rob(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            int k = i;
            while (k < nums.length) {
                sum += nums[k];
                k = k + 2;
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 1, 2};
        rob(nums);
    }
}
