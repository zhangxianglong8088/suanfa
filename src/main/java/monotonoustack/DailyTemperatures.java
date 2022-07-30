package monotonoustack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @description：739. 每日温度
 * https://leetcode.cn/problems/daily-temperatures/
 * @author: zhangxianglong
 * @date: 2022/5/24
 */
public class DailyTemperatures {

    /**
     * 暴力解法
     *
     * @param temperatures
     * @return
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] tem = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {

                if (temperatures[j] > temperatures[i]) {
                    tem[i] = j - i;
                    break;
                }
            }
        }
        return tem;

    }

    /**
     * 单调栈解法
     * 通常是一维数组，要寻找任一个元素的右边或者左边第一个比自己大或者小的元素的位置，此时我们就要想到可以用单调栈了。
     *
     * @param temperatures
     * @return
     */
    public static int[] dailyTemperatures2(int[] temperatures) {
        int lens = temperatures.length;
        int[] res = new int[lens];

        /**
         如果当前遍历的元素 大于栈顶元素，表示 栈顶元素的 右边的最大的元素就是 当前遍历的元素，
         所以弹出 栈顶元素，并记录
         如果栈不空的话，还要考虑新的栈顶与当前元素的大小关系
         否则的话，可以直接入栈。
         注意，单调栈里 加入的元素是 下标。
         */
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < lens; i++) {

            if (temperatures[i] <= temperatures[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    res[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[] tem = new int[]{73, 74, 75, 71, 69, 72, 76, 73};

        int[] result = temperatures(tem);

    }

    public static int[] temperatures(int[] dailyTemperatures) {
        //定义单调栈

        Stack<Integer> stack = new Stack<>();
        int[] temp = new int[dailyTemperatures.length];

        stack.push(0);

        for (int i = 1; i < dailyTemperatures.length; i++) {
            //当前元素小于栈顶元素 没法计算 直接入栈
            if (dailyTemperatures[i] <= dailyTemperatures[stack.peek()]) {
                stack.push(i);
            } else {

                //当前元素大与栈顶元素 说明当前元素就是栈顶元素最近的一个高温
                while (!stack.isEmpty() && dailyTemperatures[i] > dailyTemperatures[stack.peek()]) {
                    temp[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }

        return temp;
    }
}
