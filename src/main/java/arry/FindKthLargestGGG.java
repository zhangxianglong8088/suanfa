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
public class FindKthLargestGGG {

    public static int findKthLargest(int[] nums, int k) {

        //定义大顶堆 把所以元素全部放到堆中 从堆顶取出第k个元素
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


    /**
     * 定义小顶堆，不断的比较堆顶元素和数组元素 最后取出堆顶元素
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest2(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> (a - b));


        for (int i = 0; i < nums.length; i++) {
            if (queue.size() < k) {
                queue.offer(nums[i]);
            } else {
                if (nums[i] >= queue.peek()) {
                    queue.poll();
                    queue.offer(nums[i]);
                }
            }
        }

        return queue.poll();
    }

    /**
     * 快速排序
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest3(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);

        int n = nums.length;

        return nums[n - k];

    }

    static void quickSort(int[] nums, int start, int end) {

        //递归终止条件
        if (start > end) {
            return;
        }

        int left = start;
        int right = end;

        int povit = nums[left];

        while (left < right) {

            while (left < right && nums[right] >= povit) {
                right--;
            }

            while (left < right && nums[left] <= povit) {
                left++;
            }


            //交换left和right的值
            if (left < right) {
                swap(nums, left, right);
            }
        }

        //交换pivot和left的值

        swap(nums, start, left);

        quickSort(nums, start, left - 1);

        quickSort(nums, right + 1, end);
    }

    static void swap(int[] nums, int start, int end) {

        int tmp = nums[start];
        nums[start] = nums[end];
        nums[end] = tmp;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 5, 5, 7, 8};
        System.out.println(findKthLargest3(nums, 5));
    }

}
