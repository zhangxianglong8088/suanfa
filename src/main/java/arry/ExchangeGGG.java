package arry;

/**
 * @description：剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * @author: zhangxianglong
 * @date: 2022/5/16
 */
public class ExchangeGGG {
    /**
     * 定义双指针，开辟一个新数组，遍历原数组，偶数丛左开始放，奇数从右边开始放
     *
     * @param nums
     * @return
     */
    public static int[] exchange(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int[] result = new int[nums.length];
        //i指针找偶数 j 指针找奇数
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] % 2 == 0) {
                result[r] = nums[i];
                r--;
            } else {
                result[l] = nums[i];
                l++;
            }

        }
        return result;
    }

    /**
     * 双指针 分别从头 从尾开始遍历，如果l<r 前提下 l位置为奇数 l++，如果r位置为偶数 r--
     *
     * @param nums
     * @return
     */
    public static int[] exchange2(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            while (l < r && nums[l] % 2 == 1) {
                l++;
            }
            while (l < r && nums[r] % 2 == 0) {
                r--;
            }
            //交换l和r
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        int[] res = exchange2(nums);
    }
}
