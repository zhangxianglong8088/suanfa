package arry;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/
 *
 * @description：215. 数组中的第K个最大元素
 * @author: zhangxianglong
 * @date: 2022/5/16
 */
public class FindKthLargest {

    public static int findKthLargest(int[] nums, int k) {
        //定义大顶堆
        Queue<Integer> queue = new PriorityQueue<>((v1, v2) -> (v2 - v1));
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
        }

        for (int i = 0; i < k; i++) {
            if (i == k - 1) {
                return queue.poll();
            } else {
                queue.poll();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 5, 5, 7, 8};
        System.out.println(findKthLargest(nums, 5));
    }
}
