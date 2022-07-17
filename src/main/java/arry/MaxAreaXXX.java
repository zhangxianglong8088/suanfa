package arry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 11. 盛最多水的容器
 *
 * @description：https://leetcode.cn/problems/container-with-most-water/
 * @author: zhangxianglong
 * @date: 2022/5/24
 */
public class MaxAreaXXX {

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
     * 一开始两个指针一个指向开头一个指向结尾，此时容器的底是最大的，接下来随着指针向内移动，会造成容器的底变小，
     * 在这种情况下想要让容器盛水变多，就只有在容器的高上下功夫。 那我们该如何决策哪个指针移动呢？我们能够发现不管是左指针向右移动一位，
     * 还是右指针向左移动一位，容器的底都是一样的，都比原来减少了 1。这种情况下我们想要让指针移动后的容器面积增大，就要使移动后的容器的高尽量大，
     * 所以我们选择指针所指的高较小的那个指针进行移动，这样我们就保留了容器较高的那条边，放弃了较小的那条边，以获得有更高的边的机会
     *
     * @param height
     * @return
     */
    public static int maxArea2(int[] height) {
        int squar = Integer.MIN_VALUE;

        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int leftValue = height[left];
            int rightValue = height[right];

            squar = Math.max(Math.min(leftValue, rightValue) * Math.abs(right - left), squar);

            //leftValue小于rightValue  增大left 如果right小于left 则减小right
            if (leftValue < rightValue) {
                left++;
            } else {
                right--;
            }
        }
        return squar;
    }

    /**
     * 更优的解法
     *
     * @param height
     * @return
     */
    public static int maxArea3(int[] height) {

        int max = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            max = Math.max(max, (j - i + 1) * minHeight);
        }
        return max;

    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = maxArea3(nums);
        System.out.println(result);
    }
}
