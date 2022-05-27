package arry;

/**
 * @description：https://leetcode.cn/problems/container-with-most-water/
 * @author: zhangxianglong
 * @date: 2022/5/24
 */
public class MaxArea {

    /**
     * 暴力解法
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int squar = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int iValue = height[i];
                int jValue = height[j];
                int result = Math.max(Math.min(iValue, jValue) * Math.abs(i - j), squar);
                squar = result;
            }
        }
        return squar;
    }

    /**
     * 双指针
     *
     * @param height
     * @return
     */
    public static int maxArea2(int[] height) {
        int squar = Integer.MIN_VALUE;


        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int iValue = height[left];
            int jValue = height[right];

            squar = Math.max(Math.min(iValue, jValue) * Math.abs(right - left), squar);
            //left小于right 增大left 如果right小于left 则减小right
            if (iValue < jValue) {
                left++;
            } else {
                right--;
            }

        }
        return squar;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = maxArea2(nums);
    }
}
