package arry;

/**
 * @description：剑指 Offer 42. 连续子数组的最大和
 * <p>
 * https://leetcode.cn/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * @author: zhangxianglong
 * @date: 2022/5/16
 */
public class MaxSubArray {

    /**
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {

        int asn = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length - 1; i++) {
            int sum;
            int j = i + 1;
            while (j < nums.length) {
                sum = nums[i] + nums[j];
                asn = Math.max(asn, sum);
                j++;
            }
        }
        return asn;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }
}
