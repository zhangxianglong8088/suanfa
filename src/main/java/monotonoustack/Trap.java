package monotonoustack;

import java.util.Stack;

/**
 * 42. 接雨水
 *
 * @description：https://leetcode.cn/problems/trapping-rain-water/comments/
 * @author: zhangxianglong
 * @date: 2022/6/27
 */
public class Trap {

    /**
     * 单调栈解法
     *
     * @param height
     * @return
     */
    public static int trap1(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        //定义单调栈
        Stack<Integer> stack = new Stack<>();

        //默认栈中push0进去
        stack.push(0);

        //雨水的总量
        int sum = 0;

        for (int i = 1; i < height.length; i++) {
            //比较当前元素和栈顶元素
            if (height[i] < height[stack.peek()]) {
                stack.push(i);
                //如果当前元素的高度=栈顶的元素，则用当前元素替换栈顶元素
            } else if (height[i] == height[stack.peek()]) {
                stack.pop();
                stack.push(i);

            } else {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    //获取栈顶元素  栈中栈顶元素的下一个元素 当前元素
                    int middle = stack.pop();
                    if (!stack.isEmpty()) {
                        //栈顶元素的前面一个元素
                        int left = stack.peek();

                        //计算雨水的高度
                        int h = Math.min(height[left], height[i]) - height[middle];
                        int w = i - left - 1;

                        //当前雨水的量
                        int hold = h * w;
                        if (hold > 0) {
                            sum += hold;
                        }
                    }
                }
                stack.push(i);
            }
        }
        return sum;
    }

    /**
     * 动态规划解法
     *
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int length = height.length;
        if (length <= 2) return 0;
        int[] maxLeft = new int[length];
        int[] maxRight = new int[length];

        // 记录每个柱子左边柱子最大高度
        maxLeft[0] = height[0];
        for (int i = 1; i < length; i++) {
            maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
        }

        // 记录每个柱子右边柱子最大高度
        maxRight[length - 1] = height[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(height[i], maxRight[i + 1]);
        }

        // 求和
        int sum = 0;
        for (int i = 0; i < length; i++) {
            int count = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (count > 0) {
                sum += count;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums2 = new int[]{4, 2, 0, 3, 2, 5};
        int[] nums1 = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int res1 = trap1(nums1);
        int res2 = trap1(nums2);
        System.out.println(res1);
        System.out.println(res2);
    }
}
