package dp;

/**
 * @description：152. 乘积最大子数组
 * https://leetcode.cn/problems/maximum-product-subarray/
 * @author: zhangxianglong
 * @date: 2022/5/23
 */
public class MaxProduct {

    /**
     * 参考题解
     * https://leetcode.cn/problems/maximum-product-subarray/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--36/
     *
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {

        //定义dp数组 dpMax 表示0到i位置乘积最大的子数组
        int[] dpMax = new int[nums.length];
        dpMax[0] = nums[0];

        //dpMin 表示0到i位置乘积最小的子数组
        int[] dpMin = new int[nums.length];

        dpMin[0] = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dpMax[i] = Math.max(dpMax[i - 1] * nums[i], Math.max(dpMin[i - 1] * nums[i], nums[i]));
            dpMin[i] = Math.min(dpMin[i - 1] * nums[i], Math.min(dpMax[i - 1] * nums[i], nums[i]));
            res = Math.max(res, dpMax[i]);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, -3, -4};

        int res = maxProduct(nums);

    }
}
