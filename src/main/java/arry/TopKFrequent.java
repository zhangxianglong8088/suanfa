package arry;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 * https://leetcode.cn/problems/top-k-frequent-elements/
 *
 * @description：
 * @author: zhangxianglong
 * @date: 2022/5/18
 */
public class TopKFrequent {

    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int times = map.getOrDefault(nums[i], 0);
            times++;
            map.put(nums[i], times);
        }

        //定义小顶堆
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() < k) {
                queue.offer(new int[]{entry.getKey(), entry.getValue()});
            } else {
                int[] peek = queue.peek();
                if (peek[1] < entry.getValue()) {
                    queue.poll();
                    queue.offer(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }

        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        topKFrequent(nums, 2);
    }
}
