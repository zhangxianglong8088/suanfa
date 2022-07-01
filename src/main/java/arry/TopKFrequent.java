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

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        topKFrequent(nums, 2);
    }

    /**
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent(int[] nums, int k) {
        //遍历数组 将数组中的元素放到Map中，key表示该元素，value表示元素出现的次数
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        //定义大顶堆
        Queue<Integer[]> queue = new PriorityQueue<>((v1, v2) -> (v2[1] - v1[1]));

        //遍历map 把map中所有元素都放入大顶堆中
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            queue.add(new Integer[]{m.getKey(), m.getValue()});
        }

        int[] res = new int[k];
        //遍历大顶堆 取出前K个堆顶元素
        for (int i = 0; i < k; i++) {
            Integer[] item = queue.poll();
            res[i] = item[0];
        }

        return res;
    }

}
