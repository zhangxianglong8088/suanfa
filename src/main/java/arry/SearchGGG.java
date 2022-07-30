package arry;

/**
 * https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 *
 * @description：剑指 Offer 53 - I. 在排序数组中查找数字 I
 * @author: zhangxianglong
 * @date: 2022/5/16
 */
public class SearchGGG {

    public static int search(int[] nums, int target) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println(search(nums, 8));
    }
}
