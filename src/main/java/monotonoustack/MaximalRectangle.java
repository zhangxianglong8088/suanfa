package monotonoustack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @description： 85. 最大矩形
 * https://leetcode.cn/problems/maximal-rectangle/
 * @author: zhangxianglong
 * @date: 2022/7/21
 */
public class MaximalRectangle {

    public static int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int col = matrix[0].length;
        int[] heights = new int[col];
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                heights[j] = matrix[i][j] == '1' ? heights[j] + matrix[i][j] - '0' : 0;
            }
            res = Math.max(res, largestRectangleArea(Arrays.copyOf(heights, col + 1)));

        }
        return res;
    }

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
                while (!st.isEmpty() && heights[i] < heights[st.peek()]) {
                    int mid = st.peek();
                    st.pop();
                    if (!st.isEmpty()) {
                        int left = st.peek();
                        int right = i;
                        int w = right - left - 1;
                        int h = heights[mid];
                        result = Math.max(result, w * h);
                    }
                }
                st.push(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] nums = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        int res = maximalRectangle(nums);
        System.out.println(res);
    }
}
