package arry;

/**
 * @description：238. 除自身以外数组的乘积
 * @author: zhangxianglong
 * @date: 2022/7/22
 */
public class ProductExceptSelfXXX {

    public static int[] productExceptSelf(int[] nums) {

        int length = nums.length;

        int[] L = new int[nums.length];

        int[] R = new int[nums.length];

        int[] answer = new int[nums.length];

        L[0] = 1;

        for (int i = 1; i < length; i++) {
            L[i] = nums[i - 1] * L[i - 1];
        }

        // R[i] 为索引 i 右侧所有元素的乘积
        // 对于索引为 'length-1' 的元素，因为右侧没有元素，所以 R[length-1] = 1
        R[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            R[i] = nums[i + 1] * R[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            answer[i] = L[i] * R[i];
        }

        return answer;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        int[] res = productExceptSelf(nums);
        System.out.println(res);
    }
}
