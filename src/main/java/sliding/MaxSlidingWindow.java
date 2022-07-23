package sliding;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description：239. 滑动窗口最大值
 * maxSlidingWindow
 * https://leetcode.cn/problems/sliding-window-maximum/
 * @author: zhangxianglong
 * @date: 2022/5/23
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {

        //判断特殊条件
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[]{};
        }

        //定一个一个双端队列
        // 队列表示滑动窗口
        //queue里面存储的是下标，这个下标对应的元素是单调递减的
        //为什么队列里面存储的不是数组元素而是下标：因为这个队列的长度不一定和滑动窗口的长度保持一致
        Deque<Integer> queue = new LinkedList<>();

        //数组的长度
        int n = nums.length;

        //定义返回结果的数组
        int[] res = new int[n - k + 1];
        int idx = 0;


        for (int i = 0; i < n; i++) {
            //1、头：清理超期元素(清理i-k位置的元素)
            if (!queue.isEmpty() && queue.peek() == i - k) {
                queue.remove();
            }

            //2、尾：维护单调递减队列(清除队列内<新入队元素的元素)
            //删除所有比新入队元素小的旧元素
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.removeLast();
            }

            // 3、尾：当前元素进队列
            queue.add(i);

            //4、头：获取窗口最大值（返回头部元素）
            //思考为什么 i>k-1 原因是i<k-1 的时候滑动窗口还没有形成
            if (i >= k - 1) {
                res[idx++] = nums[queue.peek()];
            }
        }
        return res;
    }
}
