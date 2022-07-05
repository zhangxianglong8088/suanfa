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

    public static int[] topKFrequent4(int[] nums, int k) {
        //出现次数放到map
        Map<Integer, Integer> timeMap = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            Integer n = timeMap.get(nums[i]);
            if (n != null) {
                n = n + 1;
            } else {
                n = 1;
            }
            timeMap.put(nums[i], n);
        }
        Queue<Integer[]> queue = new PriorityQueue<>((n1, n2) -> (n2[1] - n1[1]));

        //遍历map 将nums[i] 和出现次数封装位一个数组 放到优先级队列(大顶堆)
        for (Map.Entry<Integer, Integer> entry : timeMap.entrySet()) {
            queue.add(new Integer[]{entry.getKey(), entry.getValue()});
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        topKFrequent4(nums, 1);
    }

}
