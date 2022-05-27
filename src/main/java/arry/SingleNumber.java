package arry;

/**
 * @description：136. 只出现一次的数字
 * https://leetcode.cn/problems/single-number/
 * @author: zhangxianglong
 * @date: 2022/5/18
 */
public class SingleNumber {
    /**
     * 异或运算有以下三个性质。
     * <p>
     * 任何数和 0 做异或运算，结果仍然是原来的数，即 a⊕0=a
     * 任何数和其自身做异或运算，结果是 0，即 a⊕a=0。
     * 异或运算满足交换律和结合律，即 a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。
     *
     * @param nums
     * @return
     */

    public static int singleNumber(int[] nums) {
        int single = 0;
        for (int i = 0; i < nums.length; i++) {
            single ^= nums[i];
        }
        return single;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 4, 4, 1, 7};
        singleNumber(nums);
    }
}
