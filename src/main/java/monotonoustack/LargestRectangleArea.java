package monotonoustack;

import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形
 * https://leetcode.cn/problems/largest-rectangle-in-histogram/solution/dong-hua-yan-shi-dan-diao-zhan-84zhu-zhu-03w3/
 *
 * @description： https://leetcode.cn/problems/largest-rectangle-in-histogram/
 * @author: zhangxianglong
 * @date: 2022/6/27
 */
public class LargestRectangleArea {

    static int largestRectangleArea(int[] heights) {

        //初始化最大面积为0
        int result = 0;

        Stack<Integer> st = new Stack<Integer>();

        //1.先将题目给定的数组左右各添加一个元素0，为了方便确定原有数组中第一个元素和最后一个元素能不能继续扩张；
        int[] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int index = 0; index < heights.length; index++) {
            newHeights[index + 1] = heights[index];
        }

        heights = newHeights;
        st.push(0);

        // 第一个元素已经入栈，从下标1开始
        for (int i = 1; i < heights.length; i++) {
            // 注意heights[i] 是和heights[st.top()] 比较 ，st.top()是下标
            if (heights[i] > heights[st.peek()]) {
                st.push(i);
            } else if (heights[i] == heights[st.peek()]) {
                st.pop(); // 这个可以加，可以不加，效果一样，思路不同
                st.push(i);
            } else {
                // 注意是while
                while (heights[i] < heights[st.peek()]) {
                    int mid = st.peek();
                    st.pop();
                    int left = st.peek();
                    int right = i;
                    int w = right - left - 1;
                    int h = heights[mid];
                    result = Math.max(result, w * h);
                }
                st.push(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 5, 6, 2, 3,};
        int res = largestRectangleArea(nums);
        System.out.println(res);

    }
}
